package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum FontWeight {
    THIN(LumoUtility.FontWeight.THIN),
    EXTRALIGHT(LumoUtility.FontWeight.EXTRALIGHT),
    LIGHT(LumoUtility.FontWeight.LIGHT),
    NORMAL(LumoUtility.FontWeight.NORMAL),
    MEDIUM(LumoUtility.FontWeight.MEDIUM),
    SEMIBOLD(LumoUtility.FontWeight.SEMIBOLD),
    BOLD(LumoUtility.FontWeight.BOLD),
    EXTRABOLD(LumoUtility.FontWeight.EXTRABOLD),
    BLACK(LumoUtility.FontWeight.BLACK);

    private final String className;

    private FontWeight(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
