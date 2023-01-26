package com.example.backend.manual.controllers;

import com.example.backend.auth.repository.UserRepository;
import com.example.backend.manual.model.Manual;
import com.example.backend.manual.pojo.AddManualForUser;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manuals")
public class AddManualForUse {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ManualRepository manualRepository;

    @PostMapping("/addManual")
    @Transactional
    public HttpStatus addManualForUse(@RequestBody AddManualForUser addManualForUser){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        var userOpt = userRepository.findByUsername(currentUser);
        var user = userOpt.orElseThrow(()->new UsernameNotFoundException(currentUser));
        var manuals = user.getManuals();//написать get для методичек прикрепленных к юзеру, посм, что возвращает
        var manualOpt =manualRepository.findById(addManualForUser.getId());
        var manual = manualOpt.orElseThrow(IllegalArgumentException::new);
        manuals.add(manual);
        return HttpStatus.OK;
    }
}
