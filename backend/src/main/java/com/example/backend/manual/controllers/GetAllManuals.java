package com.example.backend.manual.controllers;

import com.example.backend.manual.model.Manual;
import com.example.backend.manual.pojo.ManualJSON;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manuals")
public class GetAllManuals {
    @Autowired
    ManualRepository manualRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    @Transactional
    public List<ManualJSON> getAllManuals() {
        List<Manual> manualList = manualRepository.findAll();
        List<ManualJSON> allManuals = new ArrayList<>();
        for (Manual currentManual : manualList) {
            ManualJSON newManualJson = new ManualJSON(currentManual.getId(), currentManual.getManual(), currentManual.getDescription());
            allManuals.add(newManualJson);
        }
        return allManuals;
    }

}
