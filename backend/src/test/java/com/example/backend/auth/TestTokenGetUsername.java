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
        System.out.println(jwtTokenProvider.getUsername("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXRyZW5hIiwicm9sZXMiOlsiUk9MRV9TUEVDSUFMSVNUIl0sImlhdCI6MTY3NDgzNDAzMCwiZXhwIjoxNjc0ODM3NjMwfQ.xY_uLJv0m0WgwzntPxbZuhHSzzHKw4reLfAwn7l-iPk"));
    }
}
