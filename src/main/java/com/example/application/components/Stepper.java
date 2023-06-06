package com.example.application.components;

import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Stepper extends Nav {

    private UnorderedList list;

    public Stepper(Step... steps) {
        addClassName("stepper");

        this.list = new UnorderedList(steps);
        this.list.addClassNames(LumoUtility.ListStyleType.NONE, LumoUtility.Margin.NONE, LumoUtility.Padding.NONE);
        add(this.list);
    }

    public void add(Step... steps) {
        this.list.add(steps);
    }

    public void setState(Step.State state, Step step) {
        step.setState(state);
    }
}
