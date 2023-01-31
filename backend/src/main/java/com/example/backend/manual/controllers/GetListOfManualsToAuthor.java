package com.example.backend.manual.controllers;

import com.example.backend.auth.model.User;
import com.example.backend.auth.service.UserDetailsImpl;
import com.example.backend.manual.pojo.ManualJSON;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manuals")
public class GetListOfManualsToAuthor {

    @Autowired
    private ManualRepository manualRepository;

    @GetMapping("/addedManuals")
    @Transactional
    public List<ManualJSON> getListOfManualsToAuthor(Authentication authentication) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        var manualOpt = manualRepository.findAllByUser(user);
        var manuals = manualOpt.orElseThrow(IllegalArgumentException::new);
        List<ManualJSON> manualList = new ArrayList<>();
        for (int i = 0; i < manuals.size(); i++) {
            ManualJSON manualJSON = new ManualJSON(manuals.get(i).getId(), manuals.get(i).getManual(), manuals.get(i).getDescription());
            manualList.add(manualJSON);
        }
        return manualList;
    }

}
