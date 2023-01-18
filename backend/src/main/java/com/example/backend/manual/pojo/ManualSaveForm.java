package com.example.backend.manual.pojo;

import java.util.List;

public class ManualSaveForm {
    private String manual;
    private String description;
    private List<ActionJson> actions;
    private List<ActionRelationJson> relation;

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

    public List<ActionJson> getActions() {
        return actions;
    }

    public void setActions(List<ActionJson> actions) {
        this.actions = actions;
    }

    public List<ActionRelationJson> getRelation() {
        return relation;
    }

    public void setRelation(List<ActionRelationJson> relation) {
        this.relation = relation;
    }
}
