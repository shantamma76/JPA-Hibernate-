package com.xworkz.admin.service;

import com.xworkz.admin.dto.AdminDTO;
import org.springframework.stereotype.Service;

public interface AdminService {

    boolean save(AdminDTO adminDTO);
}
