package com.xworkz.practice.Controller;

import com.xworkz.practice.DTO.PracticeDto;
import com.xworkz.practice.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PracticeController {

    @Autowired
    private PracticeService service;

    @PostMapping("/signup")
    public String onSaved(PracticeDto dto, Model model) {

        System.out.println("onsaved method in PracticeController");
        boolean valid =service.save(dto);
        if(valid){
            model.addAttribute("msg","signup successfully done");
            return "Success";
        }
        else{
            model.addAttribute("error", "signup failure");
            return "SignUp";
        }
    }

    @GetMapping("/signin")
    public String onSignIn(String email,String password, Model model){
        System.out.println("Running  onSignIn in PracticeController");
        boolean read = service.getNameByEmail(email,password);

        if (read){
            model.addAttribute("msg","login successfully");
            return "Success";
        }
        model.addAttribute("error", "Login failure");
        return "SignIn";
        }

}

