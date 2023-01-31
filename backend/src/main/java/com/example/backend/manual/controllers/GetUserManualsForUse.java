package com.example.backend.manual.controllers;

import com.example.backend.auth.model.User;
import com.example.backend.auth.service.UserDetailsImpl;
import com.example.backend.manual.model.Manual;
import com.example.backend.manual.pojo.ManualJSON;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manuals")
public class GetUserManualsForUse {
    @Autowired
    ManualRepository manualRepository;

    @GetMapping("/getMyManualsForUse")
    public List<ManualJSON> getMuManualsForUse(Authentication authentication){
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        var manualOpt = manualRepository.findAllByUser(user);
        var manuals = manualOpt.orElseThrow(IllegalArgumentException::new);
        List<ManualJSON> manualList = new ArrayList<>();
        for (Manual manual : manuals) {
            ManualJSON manualJSON = new ManualJSON(manual.getId(), manual.getManual(), manual.getDescription());
            manualList.add(manualJSON);
        }
        return manualList;
    }

}
