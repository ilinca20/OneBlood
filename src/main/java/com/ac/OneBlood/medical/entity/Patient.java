package com.ac.OneBlood.medical.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    //default constructor for bulider
    public Patient(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private PatientStatus status;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    // Constructors, getters, setters
}
