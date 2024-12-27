package com.xworkz.module.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ModuleDTO {

    private int id;

    @Size(min=3,max=10,message="name length must be in range of 3-10")
    @Min(3)
    private String name;
    private String email;
    private long phone;
    private String alterEmail;
    private long alterPhone;
    private String location;

}
