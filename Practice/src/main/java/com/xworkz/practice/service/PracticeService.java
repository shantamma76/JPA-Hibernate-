package com.xworkz.practice.service;

import com.xworkz.practice.DTO.PracticeDto;
import com.xworkz.practice.Entity.PracticeEntity;

public interface PracticeService {

    boolean save(PracticeDto practiceDto);

    boolean getNameByEmail(String email,String password);
}
