package com.xworkz.module.controller;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleService service;

    ModuleController() {
        System.out.println("running no-arg const in ModuleController");
    }

    @PostMapping("/signup")
    public String onPrinted(ModuleDTO dto) {
        System.out.println("Sign up DTO :" + dto);
        boolean save = service.onCommon(dto);
        if (save) {
            return "Success";
        } else {
            return "SignUp";
        }
    }

    @PostMapping("/signIn")
    public String onDisplay(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println(email + " " +password);
        ModuleEntity user = service.getEmail(email,password);

        if (user != null) {
            int count = user.getResetStatus();
            System.out.println(count);

            if (count == -1) {
                String name = user.getName();
                model.addAttribute("userName", name);
                return "resetPassword";
            } else {
                return "Success";
            }
        } return "SignIn";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email,@RequestParam String oldPassword,
                                @RequestParam String newPassword,@RequestParam String confirmPassword) {

        log.info("email is==" + email);
        log.info("email is==" + oldPassword);
        log.info("new password==" + newPassword);
        log.info("confirmPassword==" + confirmPassword);

        String msg = service.resetPassword(email, oldPassword, newPassword, confirmPassword);

        if ("password updated successsfully".equals(msg)) {
            return "Success";
        } else {
            return "SignIn";
        }
    }
    }






