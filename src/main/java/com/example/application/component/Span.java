package com.example.application.component;

import com.vaadin.flow.component.Component;

public class Span extends com.vaadin.flow.component.html.Span {

    public Span(String text, String... classNames) {
        super(text);
        addClassNames(classNames);
    }

    public Span(Component... components) {
        super(components);
    }

}
