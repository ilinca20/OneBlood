package com.ac.OneBlood.account.service;

import com.ac.OneBlood.account.model.*;
import com.ac.OneBlood.account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    Logger logger = Logger.getLogger(AuthenticationService.class.getName());
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .email(registerRequest.getAppUser().getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.PATIENT)
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest registerRequest) {
        logger.info("authenticate" + authenticationManager.getClass());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword()));
        }
        catch(Exception e){
            logger.info("Exception class " + e.getClass());
            throw e;
        }
        var user = repository
                .findByEmail(registerRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("email not found"));
        logger.info(user.toString());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
