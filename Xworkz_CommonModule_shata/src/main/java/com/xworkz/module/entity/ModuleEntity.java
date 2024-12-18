package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="module_table")
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private long phone;
    private String alterEmail;
    private long alterPhone;
    private String location;
    private String password;

}
