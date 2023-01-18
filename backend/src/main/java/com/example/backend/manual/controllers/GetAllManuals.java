package com.example.backend.manual.controllers;

import com.example.backend.manual.model.Manual;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manuals")
public class GetAllManuals {
    @Autowired
    ManualRepository manualRepository;
    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<Manual>> getAllManuals(){
        final List<Manual> manuals = (List<Manual>) manualRepository.findAll();
        return !manuals.isEmpty()
                ? new ResponseEntity<>(manuals, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
