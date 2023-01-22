package com.example.backend.auth;

import com.example.backend.auth.pojo.LoginForm;
import com.example.backend.auth.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@SpringBootTest
public class UserServiceTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    UserRepository userRepository;
    @Test
    void setUserRepository() throws Exception{
        LoginForm testPassword = objectMapper.readValue("""
                {
                            "username": "matrena",
                            "password": "123"

                        }""", LoginForm.class);
        var userOptional = userRepository.findByUsername(testPassword.getUsername());
        var user = userOptional.orElseThrow(()-> new UsernameNotFoundException(testPassword.getUsername()));
        System.out.println(user);

    }
}

