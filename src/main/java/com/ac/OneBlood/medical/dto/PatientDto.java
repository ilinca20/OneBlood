package com.ac.OneBlood.medical.dto;

import com.ac.OneBlood.medical.entity.PatientStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class PatientDto {
    private Long patientId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;

    private PatientStatus status;
}
