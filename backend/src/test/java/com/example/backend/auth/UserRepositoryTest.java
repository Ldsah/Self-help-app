package com.example.backend.auth;

import com.example.backend.auth.pojo.LoginForm;
import com.example.backend.auth.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    UserRepository userRepository;
    @Test
    void getUserFromUserRepository() throws Exception{
        LoginForm testUsername = objectMapper.readValue("""
                {
                            "username": "matrena",
                            "password": "123"

                        }""", LoginForm.class);
        var userOptional = userRepository.findByUsername(testUsername.getUsername());
        var user = userOptional.orElseThrow(()-> new UsernameNotFoundException(testUsername.getUsername()));
        System.out.println(user);

    }
}
