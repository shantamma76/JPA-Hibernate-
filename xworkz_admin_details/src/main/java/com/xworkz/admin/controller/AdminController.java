package com.xworkz.admin.controller;

import com.xworkz.admin.dto.AdminDTO;
import com.xworkz.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    AdminController(){

    }
    @PostMapping("/submitForm")
    public String onSave(AdminDTO dto){
        System.out.println(dto.toString());
        boolean saved = adminService.save(dto);
        if(saved){
            return "Success.jsp";
        }
        return "Admin.jsp";
    }
}

