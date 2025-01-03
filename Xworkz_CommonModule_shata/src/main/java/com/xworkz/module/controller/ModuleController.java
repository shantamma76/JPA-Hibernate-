package com.xworkz.module.controller;

import com.xworkz.module.constant.LocationEnum;
import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import com.xworkz.module.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
@Slf4j
public class ModuleController {

    @Autowired
    private ModuleService service;

    private List<LocationEnum> listoflocation = new ArrayList<>(Arrays.asList(LocationEnum.values()));

    ModuleController() {
        System.out.println("Running no-arg constructor in ModuleController");
    }

    @GetMapping("/sup")
    public String onSignup(Model model) {
        listoflocation.forEach(n -> System.out.println(n));
        model.addAttribute("listoflocation", listoflocation);
        return "SignUp";
    }

    @GetMapping("/update")
    public String onUpdate(@RequestParam(required = false) String name, Model model) {
        listoflocation.forEach(n -> System.out.println(n));
        model.addAttribute("listoflocation", listoflocation);
        model.addAttribute("userName", name);
        return "NewSignup";
    }

    @PostMapping("/signup")
    public String onPrinted(ModuleDTO dto, Model model) {
        System.out.println("Running onPrinted in controller");
        System.out.println(dto);

        Set<ConstraintViolation<ModuleDTO>> constraintViolations = service.onCommon(dto);
        if (constraintViolations.isEmpty()) {
            model.addAttribute("msg", "SignUp Success");
            return "Success";
        } else {
            model.addAttribute("error", constraintViolations);
            return "SignUp";
        }
    }

    @PostMapping("/signIn")
    public String onDisplay(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println(email + " " + password);
        ModuleEntity entity = service.getEmail(email, password);

        if (entity != null) {
            int loginCount = entity.getResetStatus();
            String userName = entity.getName();

            if (loginCount == -1) {
                model.addAttribute("userName", userName);
                return "resetPassword";
            } else {
                model.addAttribute("userName", userName);
                return "Success";
            }
        }
        return "SignIn";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email, @RequestParam String oldPassword,
                                @RequestParam String newPassword, @RequestParam String confirmPassword) {
        log.info("Email is: " + email);
        log.info("Old password: " + oldPassword);
        log.info("New password: " + newPassword);
        log.info("Confirm password: " + confirmPassword);

        String msg = service.resetPassword(email, oldPassword, newPassword, confirmPassword);

        if ("password updated successfully".equals(msg)) {
            return "Success";
        } else {
            return "SignIn";
        }
    }

    @PostMapping("/newSignup")
    public String newUpdated(@RequestParam String name, ModuleDTO dto, Model model) {
        //System.out.println(name);
        Set<ConstraintViolation<ModuleDTO>> set = service.updateDetails(name, dto);
         set.forEach((n)-> System.out.println(n));
        if (set.isEmpty()) {
            model.addAttribute("userName",name);
            return "Success";
        }
        return "NewSignup";
    }
}
