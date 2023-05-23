package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum TextColor {
    HEADER(LumoUtility.TextColor.HEADER),
    BODY(LumoUtility.TextColor.BODY),
    SECONDARY(LumoUtility.TextColor.SECONDARY),
    TERTIARY(LumoUtility.TextColor.TERTIARY),
    DISABLED(LumoUtility.TextColor.DISABLED),
    PRIMARY(LumoUtility.TextColor.PRIMARY),
    PRIMARY_CONTRAST(LumoUtility.TextColor.PRIMARY_CONTRAST),
    ERROR(LumoUtility.TextColor.ERROR),
    ERROR_CONTRAST(LumoUtility.TextColor.ERROR_CONTRAST),
    SUCCESS(LumoUtility.TextColor.SUCCESS),
    SUCCESS_CONTRAST(LumoUtility.TextColor.SUCCESS_CONTRAST);

    private final String className;

    private TextColor(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
