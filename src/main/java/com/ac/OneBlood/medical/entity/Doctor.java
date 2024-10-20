package com.ac.OneBlood.medical.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    //for builder
    public Doctor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String specialty;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
