package com.example.backend.manual.controllers;

import com.example.backend.auth.pojo.MessageResponse;
import com.example.backend.auth.repository.UserRepository;
import com.example.backend.manual.model.Action;
import com.example.backend.manual.model.ActionRelation;
import com.example.backend.manual.model.Manual;
import com.example.backend.manual.pojo.ActionJson;
import com.example.backend.manual.pojo.ActionRelationJson;
import com.example.backend.manual.pojo.ManualSaveForm;
import com.example.backend.manual.repository.ActionExecutorRepository;
import com.example.backend.manual.repository.ActionRelationRepository;
import com.example.backend.manual.repository.ActionRepository;
import com.example.backend.manual.repository.ManualRepository;
import com.example.backend.manual.service.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/createManual")
public class SaveManualController {
    @Autowired
    private final ManualService service;
    @Autowired
    private ManualRepository manualRepository;
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ActionExecutorRepository actionExecutorRepository;
    @Autowired
    private ActionRelationRepository actionRelationRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public SaveManualController(ManualService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/saveManual")
    @Transactional
    public ResponseEntity<?> save(@RequestBody ManualSaveForm manualSaveForm) {
        Manual manual = new Manual(manualSaveForm.getManual(), manualSaveForm.getDescription());
        manualRepository.save(manual);
        List<ActionJson> listOfActions = manualSaveForm.getActions();
        for (ActionJson action : listOfActions) {
            var actionExecutorOpt = actionExecutorRepository.findByName(action.getActionExecutor());
            var actionExecutor = actionExecutorOpt.orElseThrow(() -> new IllegalArgumentException("Action executor not found"));
            Action action1 = new Action(action.getStepId(), action.getStep(), actionExecutor);
            action1.setManual(manual);
            actionRepository.save(action1);
        }
        List<ActionRelationJson> actionRelationJsons = manualSaveForm.getRelation();
        for(ActionRelationJson actionRelationJson: actionRelationJsons){
            ActionRelation actionRelation = new ActionRelation(actionRelationJson.getParentId(), actionRelationJson.getChildId());
            actionRelation.setManual(manual);
            actionRelationRepository.save(actionRelation);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        var userOptional = userRepository.findByUsername(currentPrincipalName);
        var user = userOptional.orElseThrow(()->new UsernameNotFoundException(currentPrincipalName));
        manual.setUser(user);

        return ResponseEntity.ok(new MessageResponse(("Manual saved")));
    }


}
