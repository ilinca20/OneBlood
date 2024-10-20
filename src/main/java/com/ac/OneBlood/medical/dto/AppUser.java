package com.ac.OneBlood.medical.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AppUser {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
