package com.xworkz.course.controller;
import com.xworkz.course.dto.SignupDTO;
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

    public CourseController() {
        System.out.println("no-arg const in CourseController");
    }

    @PostMapping("/signup")
    public String onSaved(Model model, SignupDTO signupDTO) {
        System.out.println(signupDTO.toString());
        boolean valid = courseService.validate(signupDTO);
        model.addAttribute("msg", valid);
        if(valid){
             System.out.println("SuccessFull:"+valid);
        } else{
            System.out.println("Faluire:"+valid);
        }
        return "SignUp";
    }

    @PostMapping("/signIn")
    public String solution(@RequestParam String email, @RequestParam String password, Model model) {
        String valid=courseService.getName(email,password);
        model.addAttribute("msg","password Matched");
        return "SignIn";
    }
}



