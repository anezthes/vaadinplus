package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum Overflow {
    AUTO(LumoUtility.Overflow.AUTO),
    HIDDEN(LumoUtility.Overflow.HIDDEN);

    private final String className;

    private Overflow(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
