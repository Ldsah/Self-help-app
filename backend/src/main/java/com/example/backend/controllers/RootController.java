package com.example.backend.controllers;

import com.example.backend.pojo.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class RootController {

    @GetMapping
    public ResponseEntity<?> signUpUser(){
        return ResponseEntity.ok(new MessageResponse("Hello"));
    }





}
