package com.example.backend.auth.controllers;

import com.example.backend.auth.jwt.JwtTokenProvider;
import com.example.backend.auth.model.User;
import com.example.backend.auth.repository.UserRepository;
import com.example.backend.auth.service.UserData;
import com.example.backend.auth.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/profile", produces = "application/json")
public class GetUserInformation {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @GetMapping("/test")
    @Transactional
    public HttpStatus getTest(Authentication authentication) {
        System.out.println(authentication.getName());
        return HttpStatus.OK;
    }

    @GetMapping("/data")
    @Transactional
    public UserData getProfileData(Authentication authentication) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        return new UserData(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRoles(),
                user.getName(), user.getPhone(), user.getGender(), user.getAge());
    }
}
