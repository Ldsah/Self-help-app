package com.example.backend.auth;

import com.example.backend.auth.pojo.LoginForm;
import com.example.backend.auth.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class PasswordEncoderTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void passwordecodeSouldBeSimilar() throws Exception{
        String password = "1234";
        String encodePassword = passwordEncoder.encode(password);
        System.out.println(passwordEncoder.matches("1234", encodePassword));

        LoginForm testPassword = objectMapper.readValue("""
                {
                            "username": "matrena",
                            "password": "123"

                        }""", LoginForm.class);
        var userOptional = userRepository.findByUsername(testPassword.getUsername());
        var user = userOptional.orElseThrow(()-> new UsernameNotFoundException(testPassword.getUsername()));

        System.out.println(assertThat(passwordEncoder.matches(testPassword.getPassword(),user.getPassword())));
    }
}
