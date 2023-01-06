package com.example.backend.manual.repository;

import com.example.backend.manual.model.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long> {
    Optional<Action> findById(Long id);
}
