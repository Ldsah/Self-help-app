package com.example.backend.manual.model;

import jakarta.persistence.*;

@Entity
@Table(name = "action_executor")
public class ActionExecutor {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, name = "name")
    private ActionExecutorName name;

    private String description;

    public ActionExecutor() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActionExecutorName getName() {
        return name;
    }

    public void setName(ActionExecutorName name) {
        this.name = name;
    }
}
