package com.xworkz.module.service;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ModuleServiceImpl implements ModuleService {
    private static final int MAX_ATTEMPTS = 3;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModuleRepository repository;

    @Override
    public Long countName(String name) {
        return repository.countName(name);
    }

    @Override
    public Long countByEmail(String email) {
        return repository.countByEmail(email);
    }

    @Override
    public Long countByAltEmail(String alterEmail) {
        return repository.countByAltEmail(alterEmail);
    }

    @Override
    public Long countByPhone(long phone) {
        return repository.countByPhone(phone);
    }

    @Override
    public Long countByAltPhone(long alterPhone) {
        return repository.countByAltPhone(alterPhone);
    }

    @Override
    public Long countByLocation(String location) {
        return repository.countByLocation(location);
    }

    @Override
    public boolean onCommon(ModuleDTO dto) {
        System.out.println("Running onCommon in ModuleServiceImpl");

        if (dto.getName() == null || dto.getPhone() == 0 || dto.getAlterPhone() == 0 || dto.getLocation() == null) {
            return false;
        }
        String password = generateRandomPassword();
        String encodedPassword = passwordEncoder.encode(password); 

        ModuleEntity entity = new ModuleEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAlterEmail(dto.getAlterEmail());
        entity.setPhone(dto.getPhone());
        entity.setAlterPhone(dto.getAlterPhone());
        entity.setLocation(dto.getLocation());
        entity.setPassword(password);
        entity.setResetStatus(-1);
       //entity.setAttemptCount();
       //entity.setLocked();

        try {
            repository.onModule(entity);
            System.out.println("User details saved successfully: " + dto);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving user details: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ModuleEntity getName(String email, String password) {
        ModuleEntity entity = repository.getName(email,password);
        if (entity != null) {
            if (entity.getPassword().equals(password)) {
                System.out.println("Login successful for email: " + email);
                return entity;
            } else {
                System.out.println("Invalid password for email: " + email);
            }
            return null;
        } else {
            System.out.println("No user with email: " + email);
        }
        return repository.getName(email,password);
    }

    @Override
    public List<ModuleEntity> getAll(String email, String password) {
        List<ModuleEntity> list =repository.getAll(email,password);
        if(list != null){
            return list;
        }
        return null;
    }

    private String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }

    @Override
    public boolean resetPassword(String email, String oldPassword, String newPassword) {
        System.out.println("+++++++++++++++++++++++++++++"+email);
        ModuleEntity entity = repository.findByEmail(email);
        System.out.println("============================="+entity);
        if (entity != null) {
            if (entity.getPassword().equals(oldPassword)) {
                String encryptedPassword = passwordEncoder.encode(newPassword);
                entity.setPassword(encryptedPassword);
                entity.setResetStatus(0);

                return repository.update(entity);
            }
        }
        return false;
    }
}


