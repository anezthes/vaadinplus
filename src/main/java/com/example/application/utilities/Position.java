package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum Position {
    ABSOLUTE(LumoUtility.Position.ABSOLUTE),
    FIXED(LumoUtility.Position.FIXED),
    RELATIVE(LumoUtility.Position.RELATIVE),
    STATIC(LumoUtility.Position.STATIC),
    STICKY(LumoUtility.Position.STICKY);

    private final String className;

    private Position(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
