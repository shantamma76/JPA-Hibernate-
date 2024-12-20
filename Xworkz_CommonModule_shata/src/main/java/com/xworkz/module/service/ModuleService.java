package com.xworkz.module.service;

import com.xworkz.module.dto.ModuleDTO;

public interface ModuleService {

    boolean onCommon(ModuleDTO moduleDTO);

    String getName(String name, String password);

    Long countName(String name);
    Long countByEmail(String email);
    Long countByAltEmail(String alterEmail);
    Long countByPhone(long phone);
    Long countByAltPhone(long alterPhone);
    Long countByLocation(String location);


}
