package com.example.backend.manual.pojo;

import com.example.backend.manual.model.ActionExecutor;
import com.example.backend.manual.model.ActionExecutorName;

public class ActionJson {
    private Long stepId;
    private String step;
    private ActionExecutorName actionExecutor;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }


    public ActionExecutorName getActionExecutor() {
        return actionExecutor;
    }

    public void setActionExecutor(ActionExecutorName actionExecutor) {
        this.actionExecutor = actionExecutor;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }
}
