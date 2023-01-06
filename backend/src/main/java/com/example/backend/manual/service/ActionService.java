package com.example.backend.manual.service;

import com.example.backend.manual.model.Action;
import com.example.backend.manual.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ActionService{
     Optional<Action> save(Action action);
}
