package com.xworkz.course.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupDTO {

    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;
    private String phone;
}
