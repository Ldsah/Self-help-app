package com.example.backend.manual.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "actions")
public class Action {
    private String step;
    @Id
    @GeneratedValue
    private Long id;

    private Long stepId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manual_id")
    @JsonBackReference
    protected Manual manual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_executor_id")
    protected ActionExecutor actionExecutor;

    public Action() {

    }

    public Action(Long stepId, String step, ActionExecutor actionExecutor) {
        super();
        this.stepId = stepId;
        this.step = step;
        this.actionExecutor = actionExecutor;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manual getManual() {
        return manual;
    }

    public void setManual(Manual manual) {
        this.manual = manual;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

}
