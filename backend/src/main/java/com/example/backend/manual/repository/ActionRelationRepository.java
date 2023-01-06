package com.example.backend.manual.repository;

import com.example.backend.manual.model.ActionRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionRelationRepository extends CrudRepository<ActionRelation, Long> {
    Optional<ActionRelation> findById(Long id);
}
