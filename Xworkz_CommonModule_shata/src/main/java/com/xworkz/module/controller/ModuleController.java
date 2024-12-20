package com.xworkz.module.controller;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ModuleController {

    @Autowired
    private ModuleService service;

    ModuleController(){
        System.out.println("running no-arg const in ModuleController");
    }

    @PostMapping("/signup")
    public String onPrinted(ModuleDTO dto, Model model) {
        System.out.println("Running onPrinted in ModuleController");
        System.out.println(dto);
        boolean ref=service.onCommon(dto);
        model.addAttribute("name","signup successfully");
        return "SignUp";
    }

    @PostMapping("/signIn")
    public String onDisplay(@RequestParam String email, @RequestParam String password, Model model) {
    String valid= service.getName(email,password);
    model.addAttribute("msg", "password is matched");
    return "SignIn";
    }

}


