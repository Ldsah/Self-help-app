package com.example.backend.controllers;


import com.example.backend.model.User;
import com.example.backend.pojo.RegistrationForm;
import com.example.backend.pojo.MessageResponse;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody RegistrationForm registrationForm){
        if(userRepository.existsByUsername(registrationForm.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already exist"));
        }
        if(userRepository.existsByEmail(registrationForm.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: This email is already in use"));
        }

        User user = new User(registrationForm.getUsername(),
                passwordEncoder.encode(registrationForm.getPassword()),
                registrationForm.getEmail(),
                registrationForm.getName(),
                registrationForm.getPhone(),
                registrationForm.getGender(),
                registrationForm.getAge());

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User created"));
    }





}