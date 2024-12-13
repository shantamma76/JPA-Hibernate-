package com.xworkz.admin.repository;

import com.xworkz.admin.entity.AdminEntity;
import org.springframework.stereotype.Repository;

public interface AdminRepository {
    boolean save(AdminEntity adminEntity);
}
