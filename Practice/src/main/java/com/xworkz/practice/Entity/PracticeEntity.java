package com.xworkz.practice.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="practice_table")

@NamedQuery(name="getNameByEmail", query="select p.name from PracticeEntity p where p.email = :byEmail AND p.password = :byPassword")

public class PracticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;
    private long phone;

}




