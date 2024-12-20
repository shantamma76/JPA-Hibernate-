package com.xworkz.module.service;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ModuleServiceImpl implements ModuleService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
     ModuleRepository repository;

    @Override
    public Long countName(String name) {
        Long count= repository.countName(name);
        return count;
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
        System.out.println("running onCommon in ModuleServiceImpl");

        if ( dto.getName() == null || dto.getPhone() == 0 || dto.getAlterPhone() == 0|| dto.getLocation() == null)
        {
            return false;
        }
       String password = generateRandomPassword();
        ModuleEntity entity = new ModuleEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAlterEmail(dto.getAlterEmail());
        entity.setPhone(dto.getPhone());
        entity.setAlterPhone(dto.getAlterPhone());
        entity.setLocation(dto.getLocation());
        entity.setPassword(password);

        try {
            repository.onModule(entity);
            System.out.println("User details saved successfully: " +dto);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving user details: " + e.getMessage());
            return false;
        }

       // boolean saved = repository.onModule(entity);
       // return true;
    }

    @Override
    public String getName(String name, String password) {
        System.out.println("getName method in ModuleServiceImpl");
        ModuleEntity result = repository.getName(name);
        if (result != null) {
            if (passwordEncoder.matches(password, result.getPassword())) ;
            System.out.println(result.getName());
            return result.getName();
        }
        return "Data did not get";
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
}
