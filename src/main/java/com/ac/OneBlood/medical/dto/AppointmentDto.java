package com.ac.OneBlood.medical.dto;

import com.ac.OneBlood.medical.entity.Doctor;
import com.ac.OneBlood.medical.entity.Patient;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AppointmentDto {
    private Long appointmentId;

    private DoctorDto doctor;

    private PatientDto patient;

    private LocalDateTime appointmentDateAndHour;

    private String county;
    private String city;
    private String status;
    private String notes;
}
