package com.example.backend.auth.controllers;

import com.example.backend.auth.repository.UserRepository;
import com.example.backend.manual.model.Manual;
import com.example.backend.manual.pojo.ManualJSON;
import com.example.backend.manual.repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private UserRepository userRepository;
    @Autowired
    private ManualRepository manualRepository;


    @GetMapping("/addedManuals")
    @Transactional
    public List<ManualJSON> getListOfManualsToAuthor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        var userOpt = userRepository.findByUsername(currentUser);
        var user = userOpt.orElseThrow(()->new UsernameNotFoundException(currentUser));
        var manualOpt = manualRepository.findAllByUser(user);
        var manuals = manualOpt.orElseThrow(IllegalArgumentException::new);
        List <ManualJSON> manualList = new ArrayList<>();
        for (int i = 0; i < manuals.size(); i++) {
            ManualJSON manualJSON = new ManualJSON(manuals.get(i).getId(),manuals.get(i).getManual(), manuals.get(i).getDescription());
            manualList.add(manualJSON);
        }
        return manualList;
    }

}
