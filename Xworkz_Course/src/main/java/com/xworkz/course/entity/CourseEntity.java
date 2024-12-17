package com.xworkz.course.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="register_table")

//@NamedQuery(name = "getNameByPassword", query = "select ce from CourseEntity ce where ce.password =: password")
@NamedQuery(name = "getNameByPassword", query = "SELECT c FROM CourseEntity c WHERE c.name = :name")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;
    private String phone;
}

