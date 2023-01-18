package com.example.backend.auth.controllers;

import com.example.backend.auth.repository.UserRepository;
import com.example.backend.auth.service.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/profile",  produces="application/json")
public class GetUserInformation {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/data")
    @Transactional
    public UserData getProfileData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        var userOptional = userRepository.findByUsername(currentPrincipalName);
        var user = userOptional.orElseThrow(()->new UsernameNotFoundException(currentPrincipalName));
        return new UserData(user.getId(),user.getUsername(),user.getEmail(),user.getPassword(), user.getRoles(),
                user.getName(), user.getPhone(), user.getGender(), user.getAge());
    }
}
