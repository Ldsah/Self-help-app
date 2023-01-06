package com.example.backend.manual.repository;

import com.example.backend.manual.model.Manual;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManualRepository extends CrudRepository<Manual, Long>{
    Optional<Manual> findById(Long id);
    Boolean existsByManual(String manual);

}
