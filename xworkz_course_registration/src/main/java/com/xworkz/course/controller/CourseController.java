package com.xworkz.course.controller;

import com.xworkz.course.dto.CourseDTO;
import com.xworkz.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    CourseController(){
        System.out.println("no-arg const in CourseController");
    }

    @PostMapping("/course")
    public String onSave(Model model, CourseDTO dto){
        System.out.println(dto.toString());

        String valid= courseService.save(dto);
        model.addAttribute("msg",valid);

        return "Course";

    }

    @PostMapping("/signIn")
    public String onSearch(@RequestParam String email, @RequestParam String password, Model model){

        String valid= courseService.getNameByEmailAndPassword(email,password);
        model.addAttribute("msg",valid);

        return "SignIn";
}
}
