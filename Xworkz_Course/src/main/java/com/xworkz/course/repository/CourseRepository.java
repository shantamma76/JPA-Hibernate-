package com.xworkz.course.repository;

import com.xworkz.course.entity.CourseEntity;

public interface CourseRepository {

    boolean valid(CourseEntity courseEntity);

    CourseEntity getNAme(String name);
}
