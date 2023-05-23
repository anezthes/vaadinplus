package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum AlignItems {
    BASELINE(LumoUtility.AlignItems.BASELINE),
    CENTER(LumoUtility.AlignItems.CENTER),
    END(LumoUtility.AlignItems.END),
    START(LumoUtility.AlignItems.START),
    STRETCH(LumoUtility.AlignItems.STRETCH);

    private final String className;

    private AlignItems(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
