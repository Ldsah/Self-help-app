package com.example.backend.manual.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actionExecutor")

public class ActionExecutor {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    public ActionExecutor(){

    }

    public ActionExecutor(String name, String description){
        super();
        this.name = name;
        this.description = description;
    }

    @OneToMany(mappedBy = "actionExecutor",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    List<Action> actionsForExecutor = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
