package com.xworkz.admin.service;

import com.xworkz.admin.dto.AdminDTO;
import com.xworkz.admin.entity.AdminEntity;
import com.xworkz.admin.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private  AdminRepository adminRepository;

    @Override
    public boolean save(AdminDTO adminDTO) {

        boolean isValid=true;

        String name=adminDTO.getName();

        if(name.length()>5 && name.matches("[A-Za-z ]+")){
            System.out.println("name valid");

        }
        else {
            isValid=false;
            System.out.println("name is invalid");
        }

        int age=adminDTO.getAge();
        if(age>18){

            System.out.println("age is valid");
        }
        else{
            isValid=false;
            System.out.println("age is invalid");
            return isValid;
        }

        String email=adminDTO.getEmail();
        if(email.contains("@gmail.com")){

            System.out.println("email is valid");
        }
        else {
            isValid = false;
            System.out.println("email is invalid");
        }

        String password=adminDTO.getPassword();
        String confirmPassword=adminDTO.getConfirmPassword();
        if(confirmPassword.equals(password)){

            System.out.println("comfpassword is valid");
        }
        else{
            isValid=false;
            System.out.println("confpassword is in valid");

        }

        String phNo= String.valueOf(adminDTO.getPhone());
        if(phNo.startsWith("9") && phNo.length()==10){

            System.out.println("phno is valid");
        }
        else {
            isValid=false;
            System.out.println("phone is in valid");

        }

        if(isValid) {
            AdminEntity entity = new AdminEntity();
            entity.setName(adminDTO.getName());
            entity.setAge(adminDTO.getAge());
            entity.setEmail(adminDTO.getEmail());
            entity.setPassword(adminDTO.getPassword());
            entity.setConfirmPassword(adminDTO.getConfirmPassword());
            entity.setPhone(adminDTO.getPhone());
            System.out.println("calling save to repository");

            boolean saved = adminRepository.save(entity);
            return true;
        }

        return false;
    }
}