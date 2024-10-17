package com.ac.OneBlood.medical.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DoctorDto {
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
    private String phoneNumber;
    private String email;

}
