package com.example.backend.manual.service;

import com.example.backend.manual.model.Manual;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ManualService {
    Optional<Manual> save(Manual manual);



}
