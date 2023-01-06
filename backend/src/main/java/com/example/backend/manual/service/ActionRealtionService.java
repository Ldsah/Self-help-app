package com.example.backend.manual.service;

import com.example.backend.manual.model.ActionRelation;

import java.util.Optional;

public interface ActionRealtionService {
    Optional<ActionRelation> save(ActionRelation actionRelation);
}
