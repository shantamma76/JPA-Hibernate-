package com.xworkz.practice.repository;

import com.xworkz.practice.Entity.PracticeEntity;

public interface PracticeRepo {

    boolean save(PracticeEntity practiceEntity);

    boolean getNameByEmail(String email,String password);


}
