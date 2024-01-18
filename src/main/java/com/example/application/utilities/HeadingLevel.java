package com.example.application.utilities;

import com.vaadin.flow.component.Component;

import java.util.function.Supplier;

public enum HeadingLevel {

    H1(com.vaadin.flow.component.html.H1::new),
    H2(com.vaadin.flow.component.html.H2::new),
    H3(com.vaadin.flow.component.html.H3::new),
    H4(com.vaadin.flow.component.html.H4::new),
    H5(com.vaadin.flow.component.html.H5::new),
    H6(com.vaadin.flow.component.html.H6::new),
    NONE(com.vaadin.flow.component.html.Span::new);

    private final Supplier<Component> supplier;

    HeadingLevel(Supplier<Component> supplier) {
        this.supplier = supplier;
    }

    public Component getComponent(String text) {
        Component component = this.supplier.get();
        component.getElement().setText(text);
        return component;
    }

}
