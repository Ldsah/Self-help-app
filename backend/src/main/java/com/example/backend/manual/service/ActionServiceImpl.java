package com.example.backend.manual.service;

import com.example.backend.manual.model.Action;
import com.example.backend.manual.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService{
    ActionRepository actionRepository;

    @Autowired
    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }
    @Override
    public Optional<Action> save(Action action){
        return Optional.of(actionRepository.save(action));
    }
}
