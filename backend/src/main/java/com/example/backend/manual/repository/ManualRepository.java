package com.example.backend.manual.repository;

import com.example.backend.manual.model.Manual;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualRepository extends CrudRepository<Manual, Long>{

}
