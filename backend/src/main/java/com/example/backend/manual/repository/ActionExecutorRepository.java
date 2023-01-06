package com.example.backend.manual.repository;

import com.example.backend.manual.model.ActionExecutor;
import com.example.backend.manual.model.ActionExecutorName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionExecutorRepository extends CrudRepository<ActionExecutor, Long> {
    Optional<ActionExecutor> findByName(ActionExecutorName name);
}
