package com.example.backend.auth.controllers;


import com.example.backend.auth.model.User;
import com.example.backend.auth.service.UserData;
import com.example.backend.auth.service.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/profile", produces = "application/json")
public class GetUserInformation {
    @GetMapping("/data")
    @Transactional
    public UserData getProfileData(Authentication authentication) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        return new UserData(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRoles(),
                user.getName(), user.getPhone(), user.getGender(), user.getAge());
    }
}
