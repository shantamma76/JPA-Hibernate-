package com.xworkz.course.service;

import com.xworkz.course.dto.SignupDTO;


public interface CourseService {

    boolean validate(SignupDTO signupDTO);

    String getName(String name, String password);
}
