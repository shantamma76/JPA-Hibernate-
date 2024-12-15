package com.xworkz.course.repository;

import com.xworkz.course.entity.CourseEntity;

public interface CourseRepository {

    boolean save(CourseEntity courseEntity);

    String getNameByEmailAndPassword(String email,String password);

}
