package com.example.backend.manual.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actions")
public class Action {
    @Id
    private Long id;
    //дейтсвие или вопрос, на который пациент должен ответить
    private String step;
    //предыдущее действие или вопрос, через которое(ый) пациент перешел к текущему



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manual_id")
    private Manual manual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "actionExecutorId")
    private ActionExecutor actionExecutor;


    public Action() {

    }

    public Action(Long id, String step) {
        super();
        this.id = id;
        this.step = step;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;

    }


}
