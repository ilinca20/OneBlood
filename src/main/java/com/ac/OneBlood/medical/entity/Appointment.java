package com.ac.OneBlood.medical.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Entity
@Getter
@Table(name = "appointments")
public class Appointment {
    //default constructor for builder
    public Appointment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime appointmentDateAndHour;

    private String county;
    private String city;
    private String status;
    private String notes;

    // Constructors, getters, setters
}

