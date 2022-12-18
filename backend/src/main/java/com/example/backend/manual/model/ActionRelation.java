package com.example.backend.manual.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class ActionRelation {
    @Id
    @GeneratedValue
    private Long id;

    private Long parentActionId;
    private Long childActionId;

    public ActionRelation(){

    }
    public ActionRelation(Long parentActionId, Long childActionId){
        super();
        this.parentActionId = parentActionId;
        this.childActionId = childActionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentActionId() {
        return parentActionId;
    }

    public void setParentActionId(Long parentActionId) {
        this.parentActionId = parentActionId;
    }

    public Long getChildActionId() {
        return childActionId;
    }

    public void setChildActionId(Long childActionId) {
        this.childActionId = childActionId;
    }
}
