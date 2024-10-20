package com.ac.OneBlood.account.config;

import com.ac.OneBlood.account.filter.JwtAuthenticationFilter;
import com.ac.OneBlood.account.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console(), antMatcher(HttpMethod.POST, "/v1/auth/authenticate"), antMatcher("/v1/medical/patient/**"))
                        .disable())
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests(authorize ->
                    authorize.requestMatchers(toH2Console(), antMatcher(HttpMethod.POST, "/v1/auth/authenticate")).permitAll()
                            .requestMatchers(antMatcher(HttpMethod.POST, "/v1/medical/patient")).hasAuthority(String.valueOf(Role.ADMIN))
                            .requestMatchers(antMatcher(HttpMethod.POST,"/v1/medical/doctor"), antMatcher("/v1/medical/doctor")).hasAuthority(String.valueOf(Role.ADMIN))
                            .requestMatchers(antMatcher("/v1/medical/appointment/**"), antMatcher("/v1/medical/appointment")).hasAnyAuthority(String.valueOf(Role.DOCTOR), String.valueOf(Role.PATIENT), String.valueOf(Role.ADMIN))
                            .anyRequest().authenticated()
                )
                .sessionManagement((sessionManagement) ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

 /*   @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/ignore1", "/ignore2");
    }*/
}

