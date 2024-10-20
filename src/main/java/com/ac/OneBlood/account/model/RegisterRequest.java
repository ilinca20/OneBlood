package com.ac.OneBlood.account.model;

import com.ac.OneBlood.medical.dto.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private AppUser appUser;

    private String password;
}

