package com.xworkz.module.repository;

import com.xworkz.module.entity.ModuleEntity;

public interface ModuleRepository {

    boolean onModule(ModuleEntity moduleEntity);

    ModuleEntity getName(String name);

    Long countName(String name);
    Long countByEmail(String email);
    Long countByAltEmail(String alterEmail);
    Long countByPhone(long phone);
    Long countByAltPhone(long alterPhone);
    Long countByLocation(String location);




}
