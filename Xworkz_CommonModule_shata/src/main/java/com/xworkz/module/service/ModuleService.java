package com.xworkz.module.service;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;

import java.util.List;

public interface ModuleService {

    boolean onCommon(ModuleDTO moduleDTO);

    ModuleEntity getName(String email, String password);

    List<ModuleEntity> getAll(String email, String password);

    Long countName(String name);

    Long countByEmail(String email);

    Long countByAltEmail(String alterEmail);

    Long countByPhone(long phone);

    Long countByAltPhone(long alterPhone);

    Long countByLocation(String location);

    String resetPassword(String email, String oldPassword, String newPassword,String confirmPassword);
    ModuleEntity getEmail(String email, String password);

    boolean saveEmail(String email, String password);  //for email sending




}