package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum Display {
    FLEX(LumoUtility.Display.FLEX),
    GRID(LumoUtility.Display.GRID);

    private final String className;

    private Display(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
