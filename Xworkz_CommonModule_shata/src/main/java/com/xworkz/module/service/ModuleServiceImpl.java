package com.xworkz.module.service;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ModuleServiceImpl implements ModuleService{

    @Autowired
     ModuleRepository repository;

    @Override
    public boolean onCommon(ModuleDTO dto) {

        System.out.println("running onCommon in ModuleServiceImpl");
       String password = generateRandomPassword();
        ModuleEntity entity = new ModuleEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAlterEmail(dto.getAlterEmail());
        entity.setPhone(dto.getPhone());
        entity.setAlterPhone(dto.getAlterPhone());
        entity.setLocation(dto.getLocation());
        entity.setPassword(password);
        boolean saved = repository.onModule(entity);
        return true;

       /* try {
           repository.onModule(entity);
            System.out.println("dto details saved successfully:"+dto);
            return true;
       }
        catch (Exception e) {
            System.out.println("error saving dto details:"+e.getMessage());
            return false;
       } */

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