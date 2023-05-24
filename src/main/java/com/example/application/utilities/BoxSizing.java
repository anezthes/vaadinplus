package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum BoxSizing {
    BORDER(LumoUtility.BoxSizing.BORDER),
    CONTENT(LumoUtility.BoxSizing.CONTENT);

    private final String className;

    private BoxSizing(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
