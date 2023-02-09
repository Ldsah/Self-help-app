package com.example.backend.manual.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table(name = "action_relation")
@Entity
public class ActionRelation {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manual_id")
    @JsonBackReference
    protected Manual manual;

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

    public Manual getManual() {
        return manual;
    }

    public void setManual(Manual manual) {
        this.manual = manual;
    }
}
