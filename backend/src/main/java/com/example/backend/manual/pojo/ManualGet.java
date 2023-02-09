package com.example.backend.manual.pojo;

import com.example.backend.manual.model.Action;
import com.example.backend.manual.model.ActionRelation;

import java.util.List;

public class ManualGet {
    private String manual;
    private String description;
    private List<Action> actions;
    private List<ActionRelation> relation;
    public ManualGet(String manual, String description, List<Action> actions, List<ActionRelation> relation){
        this.manual = manual;
        this.description = description;
        this.actions = actions;
        this.relation = relation;
    }

    public String getManual() {
        return manual;
    }

    public void setManual(String manual) {
        this.manual = manual;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<ActionRelation> getRelation() {
        return relation;
    }

    public void setRelation(List<ActionRelation> relation) {
        this.relation = relation;
    }

}
