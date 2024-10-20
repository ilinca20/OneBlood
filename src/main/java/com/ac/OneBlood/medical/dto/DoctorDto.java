package com.ac.OneBlood.medical.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class DoctorDto extends AppUser {

    private Long doctorId;
    private String specialty;


}
