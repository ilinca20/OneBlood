package com.ac.OneBlood.medical.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    private String firstName;
    private String lastName;
    private String specialty;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    // Constructors, getters, setters
}
