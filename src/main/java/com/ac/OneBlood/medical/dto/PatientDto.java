package com.ac.OneBlood.medical.dto;

import com.ac.OneBlood.medical.entity.PatientStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
public class PatientDto extends AppUser{
    private Long patientId;
    private LocalDate dateOfBirth;
    private String gender;

    private PatientStatus status;
}
