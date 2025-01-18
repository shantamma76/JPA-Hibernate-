package com.xworkz.practice.DTO;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PracticeDto {

    private String name;
    private String email;
    private String password;
    private long phone;

}
