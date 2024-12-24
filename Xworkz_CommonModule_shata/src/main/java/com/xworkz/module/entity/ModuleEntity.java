package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="module_table")

@NamedQuery(name="getNameByPassword", query = "SELECT c FROM ModuleEntity c WHERE c.name= :name")

@NamedQuery(name="countName" , query ="select count(*) from ModuleEntity e where e.name =:SetName")
@NamedQuery(name = "countByEmail", query = "select count(e) from ModuleEntity e where e.email = :SetEmail")
@NamedQuery(name = "countByAltEmail", query = "select count(e) from ModuleEntity e where e.alterEmail = :SetAlterEmail")
@NamedQuery(name = "countByPhone", query = "select count(e) from ModuleEntity e where e.phone = :SetPhone")
@NamedQuery(name = "countByAltPhone", query = "select count(e) from ModuleEntity e where e.alterPhone = :SetAlterPhone")
@NamedQuery(name = "countByLocation", query = "select count(e) from ModuleEntity e where e.location =:SetLocation")

@NamedQuery(name="findbyemail",query = "Select em from ModuleEntity em where em.email=:emailid ")

@NamedQuery(name="getAll", query="select ls from ModuleEntity ls where ls.email = :setEmail and ls.password = :setPassword")

@NamedQuery(name= "getByEmail", query = "select ls from ModuleEntity ls where ls.email =: setEmail")
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

    @Column(name="reset_status")
    private int resetStatus;

}


