package com.example.backend.auth;

import com.example.backend.auth.jwt.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTokenGetUsername {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Test
    void jwtTokenGetUsername(){
        System.out.println(jwtTokenProvider.getUsername("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXRyZW5hIiwicm9sZXMiOlsiUk9MRV9TUEVDSUFMSVNUIl0sImlhdCI6MTY3NTE2MTYxOCwiZXhwIjoxNjc1MTY1MjE4fQ.Ov3q0G1l1jlvxpk3mmr50KiDr5T1R3atsr2kyIU4FTg"));
    }
}
