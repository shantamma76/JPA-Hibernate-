package com.xworkz.course.service;
import com.xworkz.course.dto.CourseDTO;


public interface CourseService {
    String  save(CourseDTO courseDTO);
    String getNameByEmailAndPassword(String email,String password);

}
