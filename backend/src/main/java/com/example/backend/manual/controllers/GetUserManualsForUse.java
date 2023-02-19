package com.example.backend.manual.controllers;

import com.example.backend.auth.model.User;
import com.example.backend.auth.service.UserDetailsImpl;
import com.example.backend.manual.model.Manual;
import com.example.backend.manual.pojo.ManualJSON;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manuals")
public class GetUserManualsForUse {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getMyManualsForUse")
    @Transactional
    public List<ManualJSON> getMyManualsForUse(Authentication authentication){
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        var manualsForUse = user.getManualsForUse();
        List<ManualJSON> manualList = new ArrayList<>();
        for (Manual manual : manualsForUse) {
            ManualJSON manualJSON = new ManualJSON(manual.getId(), manual.getManual(), manual.getDescription());
            manualList.add(manualJSON);
        }
        return manualList;
    }

}
