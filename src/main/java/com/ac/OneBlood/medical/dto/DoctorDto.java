package com.ac.OneBlood.medical.dto;

import com.ac.OneBlood.medical.entity.Appointment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
