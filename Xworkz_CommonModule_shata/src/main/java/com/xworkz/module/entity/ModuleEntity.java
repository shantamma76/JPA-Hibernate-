package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="module_table")

@NamedQuery(name="getNameByPassword", query = "SELECT c FROM ModuleEntity c WHERE c.name= :name")
//@NamedQuery(name="getNameByEmailAndPassword" ,query="select e.name from UserEntity e where e.email= :byemail and e.password = :bypassword")

@NamedQuery(name="countName" , query ="select count(*) from ModuleEntity e where e.name =:SetName")
@NamedQuery(name = "countEmail", query = "select count(e) from ModuleEntity e where e.email = :SetEmail")
@NamedQuery(name = "countAltEmail", query = "select count(e) from ModuleEntity e where e.alterEmail = :SetAlterEmail")
@NamedQuery(name = "countPhone", query = "select count(e) from ModuleEntity e where e.phone = :SetPhone")
@NamedQuery(name = "countAltPhone", query = "select count(e) from ModuleEntity e where e.alterPhone = :SetAlterPhone")
@NamedQuery(name = "countLocation", query = "select count(e) from ModuleEntity e where e.location =:SetLocation")

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


