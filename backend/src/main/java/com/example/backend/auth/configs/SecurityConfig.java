package com.example.backend.auth.configs;

import com.example.backend.auth.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
                                                       UserDetailsServiceImpl userDetailsService) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();

    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/signup", "/auth/signin" ).permitAll()
                .requestMatchers("/manuals/all", "/manuals/addManual").hasAnyRole("SPECIALIST", "USER")
                .requestMatchers("/profile/data").hasAnyRole("SPECIALIST", "USER")
                .requestMatchers("/createManual/saveManual").hasRole("SPECIALIST")
                .requestMatchers("/manuals/addedManuals").hasRole("SPECIALIST")
                .and()
                .formLogin().loginPage("/auth/signin").successForwardUrl("/profile").failureForwardUrl("/auth/signin")
                .and()
                .httpBasic();
        return http.build();
    }


}

