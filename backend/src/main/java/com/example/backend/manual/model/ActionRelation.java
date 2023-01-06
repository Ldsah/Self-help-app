package com.example.backend.manual.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "action_relation")
@Entity
public class ActionRelation {
    @Id
    @GeneratedValue
    private Long id;

    private Long parentId;
    private Long childId;

    public ActionRelation(){

    }
    public ActionRelation(Long parentId, Long childId){
        super();
        this.parentId = parentId;
        this.childId = childId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }
}
