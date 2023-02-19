package com.example.backend.manual.controllers;


import com.example.backend.manual.model.Manual;
import com.example.backend.manual.pojo.ManualGet;
import com.example.backend.manual.pojo.ManualId;
import com.example.backend.manual.repository.ActionRepository;
import com.example.backend.manual.repository.ManualRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/manuals")
public class GetManual {
    @Autowired
    ManualRepository manualRepository;
    @Autowired
    ActionRepository actionRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/getManual")
    public ManualGet getManual(@RequestBody ManualId manualId) throws JsonProcessingException {
        var manualOpt = manualRepository.findById(Long.parseLong(manualId.getId()));
        Manual localManual = manualOpt.orElseThrow();
        return new ManualGet(localManual.getManual(), localManual.getDescription(), localManual.getActionsForManual(), localManual.getActionRelations());
    }
}
