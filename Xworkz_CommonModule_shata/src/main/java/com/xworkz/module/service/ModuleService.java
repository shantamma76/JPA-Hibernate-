package com.xworkz.module.service;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;

public interface ModuleService {

    boolean onCommon(ModuleDTO moduleDTO);

    ModuleEntity getName(String email, String password);

    Long countName(String name);
    Long countByEmail(String email);
    Long countByAltEmail(String alterEmail);
    Long countByPhone(long phone);
    Long countByAltPhone(long alterPhone);
    Long countByLocation(String location);

    boolean resetPassword(String email, String oldPassword, String newPassword);

}
