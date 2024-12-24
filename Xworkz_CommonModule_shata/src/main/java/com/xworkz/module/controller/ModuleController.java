package com.xworkz.module.controller;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleService service;

    ModuleController(){
        System.out.println("running no-arg const in ModuleController");
    }

    @PostMapping("/signup")
    public String onPrinted(ModuleDTO dto) {
        System.out.println("Sign up DTO :" +dto);
        boolean save = service.onCommon(dto);
        if(save){
            return "Success";
        } else {
            return "SignUp";
        }
   }

    @PostMapping("/signIn")
    public String onDisplay(@RequestParam String email, @RequestParam String password, Model model) {
        log.info(email + " " +password);
        List<ModuleEntity> list =service.getAll(email,password);
        int resetStatus=0;
        String name =null;
        for(ModuleEntity data : list){
            resetStatus = data.getResetStatus();
            log.info("data.getCount()="+data.getResetStatus());
            name = data.getName();
        }


        log.info("valid=="+resetStatus);
        if(resetStatus == -1){
            model.addAttribute("msg", "Invalid name or password. Please try again.");
            return "resetPassword";
        } else {
            model.addAttribute("msg", "Login successful!");
            return "Success";
        }
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email,@RequestParam String oldPassword,@RequestParam String newPassword,@RequestParam String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return "resetPassword";
        }
        boolean isValid = service.resetPassword(email, oldPassword, newPassword);
        if (isValid) {
            return "SignIn";
        } else {
            return "resetPassword";
        }
    }


}


