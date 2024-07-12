package com.example.application.components;

import com.example.application.themes.StepperTheme;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class Stepper extends Nav implements HasTheme {

    private Orientation orientation;
    private UnorderedList list;

    public Stepper(Step... steps) {
        addClassName("stepper");

        this.list = new UnorderedList(steps);
        this.list.addClassNames(Display.FLEX, FlexDirection.COLUMN, Gap.Column.LARGE, ListStyleType.NONE,
                Margin.Vertical.NONE, Padding.Start.NONE);
        add(this.list);

        setOrientation(Orientation.VERTICAL);
    }

    public void add(Step... steps) {
        this.list.add(steps);
    }

    public void setOrientation(Orientation orientation) {
        if (this.orientation != null) {
            removeThemeName(this.orientation.name().toLowerCase());
        }
        addThemeName(orientation.name().toLowerCase());
        this.orientation = orientation;

        if (orientation.equals(Orientation.HORIZONTAL)) {
            this.list.addClassNames("lg:items-center", FlexDirection.Breakpoint.Large.ROW);
        } else {
            this.list.removeClassNames("lg:items-center", FlexDirection.Breakpoint.Large.ROW);
        }

        this.list.getChildren().forEach(component -> ((Step) component).setOrientation(orientation));
    }

    public void setSmall(boolean small) {
        if (small) {
            addThemeName(StepperTheme.SMALL);
        } else {
            removeThemeName(StepperTheme.SMALL);
        }

        this.list.getChildren().forEach(component -> ((Step) component).setSmall(small));
    }

    public void setState(Step.State state, Step step) {
        step.setState(state);
    }

    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum Size {
        SMALL,
        MEDIUM
    }
}
