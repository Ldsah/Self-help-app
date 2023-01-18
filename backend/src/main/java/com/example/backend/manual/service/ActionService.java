package com.example.backend.manual.service;

import com.example.backend.manual.model.Action;

import java.util.Optional;

public interface ActionService{
     Optional<Action> save(Action action);
}
