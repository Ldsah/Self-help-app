package com.example.backend.manual.controllers;

import com.example.backend.auth.pojo.MessageResponse;
import com.example.backend.manual.model.Manual;
import com.example.backend.manual.repository.ManualRepository;
import com.example.backend.manual.service.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/createManual")
public class SaveManualController {
    @Autowired
    private final ManualService service;
    @Autowired
    private ManualRepository manualRepository;

    @Autowired
    public SaveManualController(ManualService service){
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Manual manual) {
        Manual manual1 = new Manual(manual.getManual(),
                manual.getDescription());
        manualRepository.save(manual1);
        return ResponseEntity.ok(new MessageResponse("Manual saved!"));
    }
}
