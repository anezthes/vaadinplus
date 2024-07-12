package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class AppBar extends Header implements HasTheme {

    private Layout start;
    private Layout middle;
    private Layout end;

    public AppBar(Component... components) {
        addClassNames(Background.BASE, BoxSizing.BORDER, Display.FLEX, Gap.LARGE, Height.XLARGE,
                Padding.Horizontal.MEDIUM);
        setWidthFull();

        this.start = new Layout();
        this.start.setAlignItems(Layout.AlignItems.CENTER);
        this.start.setGap(Layout.Gap.LARGE);
        this.start.setOverflow(Layout.Overflow.HIDDEN);

        this.middle = new Layout();
        this.middle.setAlignItems(Layout.AlignItems.CENTER);
        this.middle.setFlexGrow();
        this.middle.setJustifyContent(Layout.JustifyContent.CENTER);

        this.end = new Layout();
        this.end.setAlignItems(Layout.AlignItems.CENTER);
        this.end.setGap(Layout.Gap.SMALL);

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
