package com.ac.OneBlood.medical.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private PatientStatus status;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    // Constructors, getters, setters
}
