package com.example.backend.manual.service;

import com.example.backend.manual.model.ActionRelation;
import com.example.backend.manual.repository.ActionRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActionRelationServiceImpl implements ActionRealtionService {
    ActionRelationRepository actionRelationRepository;
    @Autowired
    public ActionRelationServiceImpl(ActionRelationRepository actionRelationRepository) {
        this.actionRelationRepository = actionRelationRepository;
    }
    @Override
    public Optional<ActionRelation> save(ActionRelation actionRelation){
        return Optional.of(actionRelationRepository.save(actionRelation));
    }
}

