package com.example.backend.manual.controllers;

import com.example.backend.auth.model.User;
import com.example.backend.auth.repository.UserRepository;
import com.example.backend.auth.service.UserDetailsImpl;
import com.example.backend.manual.pojo.AddManualForUser;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manuals")
public class AddManualForUse {
    @Autowired
    ManualRepository manualRepository;
    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addManual")
    @Transactional
    public HttpStatus addManualForUse(@RequestBody AddManualForUser addManualForUser, Authentication authentication){
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        var userManualsForUse = user.getManualsForUse();
        var manualOpt =manualRepository.findById(addManualForUser.getId());
        var manual = manualOpt.orElseThrow(IllegalArgumentException::new);
        userManualsForUse.add(manual);
        user.setManualsForUse(userManualsForUse);
        userRepository.save(user);
        return HttpStatus.OK;
    }


}
