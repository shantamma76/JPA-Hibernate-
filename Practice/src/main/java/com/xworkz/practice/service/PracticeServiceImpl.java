package com.xworkz.practice.service;

import com.xworkz.practice.DTO.PracticeDto;
import com.xworkz.practice.Entity.PracticeEntity;
import com.xworkz.practice.repository.PracticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeServiceImpl implements PracticeService{

    @Autowired
    PracticeRepo repository;

    @Override
    public boolean save(PracticeDto practiceDto) {

        System.out.println("Running save in PracticeServiceImpl");

        PracticeEntity entity = new PracticeEntity();
        entity.setName(practiceDto.getName());
        entity.setEmail(practiceDto.getEmail());
        entity.setPassword(practiceDto.getPassword());
        entity.setPhone(practiceDto.getPhone());

        boolean save = repository.save(entity);

     if (save){
         System.out.println("data is saved");
         return  true;
     }
     System.out.println("data is not saved");
        return false;
    }

    @Override
    public boolean getNameByEmail(String email,String password) {
        System.out.println("Running getNameByEmail in PracticeServiceImpl");
           boolean getname = repository.getNameByEmail(email,password);

        return getname;
    }

}
