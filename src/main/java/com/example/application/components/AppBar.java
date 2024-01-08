package com.example.application.components;

import com.example.application.utilities.Gap;
import com.example.application.utilities.Overflow;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class AppBar extends Header implements HasTheme {

    private Layout start;
    private Layout middle;
    private Layout end;

    public AppBar(Component... components) {
        addClassNames(
                LumoUtility.Background.BASE, LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX,
                LumoUtility.Gap.LARGE, LumoUtility.Height.XLARGE, LumoUtility.Padding.Horizontal.MEDIUM
        );
        setWidthFull();

        this.start = new Layout();
        this.start.setAlignItems(FlexComponent.Alignment.CENTER);
        this.start.setGap(Gap.LARGE);
        this.start.setOverflow(Overflow.HIDDEN);

        this.middle = new Layout();
        this.middle.setAlignItems(FlexComponent.Alignment.CENTER);
        this.middle.setFlexGrow(1, this.middle);
        this.middle.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        this.end = new Layout();
        this.end.setAlignItems(FlexComponent.Alignment.CENTER);
        this.end.setGap(Gap.SMALL);

        add(this.start, this.middle, this.end);

        addToStart(components);
    }

    public void addToStart(Component... components) {
        this.start.add(components);
    }

    public void addToMiddle(Component... components) {
        this.middle.add(components);
    }

    public void addToEnd(Component... components) {
        this.end.add(components);
    }

    public void addToEnd(int index, Component component) {
        this.end.addComponentAtIndex(index, component);
    }

}
