package com.example.backend.auth.controllers;


import com.example.backend.auth.jwt.JwtTokenProvider;
import com.example.backend.auth.model.Role;
import com.example.backend.auth.model.User;
import com.example.backend.auth.pojo.LiginResponse;
import com.example.backend.auth.pojo.LoginForm;
import com.example.backend.auth.pojo.RegistrationForm;
import com.example.backend.auth.pojo.MessageResponse;
import com.example.backend.auth.repository.RoleRepository;
import com.example.backend.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    Set<Role> roles = new HashSet<>();

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<?> signUpUser(@RequestBody RegistrationForm registrationForm) {
        if (userRepository.existsByUsername(registrationForm.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already exist"));
        }
        if (userRepository.existsByEmail(registrationForm.getEmail())) {
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

        Optional<Role> role = roleRepository.findByName(registrationForm.getRole());
        var userRole = role.orElseThrow(() -> new IllegalArgumentException("Role not found"));
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User created"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signin")
    @Transactional
    public ResponseEntity login(@RequestBody LoginForm loginForm) {
        try {
            String username = loginForm.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginForm.getPassword()));

            var userOpt = userRepository.findByUsername(username);
            var user = userOpt.orElseThrow(() -> new UsernameNotFoundException(username));

            String token = jwtTokenProvider.createToken(username, user.getRoles());
            var roles = user.getRoles().stream().map((role)->role.getName()).toArray(String[]::new);
            var resp = new LiginResponse();
            resp.username = username;
            resp.token = token;
            resp.roles = roles;

            return ResponseEntity.ok(resp);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }

    }
}