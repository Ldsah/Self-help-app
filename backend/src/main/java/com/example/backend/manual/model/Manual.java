package com.example.backend.manual.model;

import com.example.backend.auth.model.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "manual")
public class Manual {
    @Id
    @GeneratedValue
    private Long id;
    private String manual;
    private String description;
    @OneToMany(
            mappedBy = "manual",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    protected List<Action> actionsForManual = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    protected User user;
    public Manual(){

    }
    public Manual(String name, String description){
        super();
        this.manual = name;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String name) {
        this.manual = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

