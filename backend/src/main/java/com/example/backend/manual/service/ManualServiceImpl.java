package com.example.backend.manual.service;

import com.example.backend.manual.model.Manual;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManualServiceImpl implements ManualService {
    private final ManualRepository manualRepository;

    @Autowired
    public ManualServiceImpl(ManualRepository manualRepository) {
        this.manualRepository = manualRepository;
    }

    @Override
    public Optional<Manual> save(Manual manual) {
        return Optional.of(manualRepository.save(manual));
    }


}
