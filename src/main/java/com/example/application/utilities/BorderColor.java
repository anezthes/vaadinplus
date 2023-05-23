package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum BorderColor {
    CONTRAST(LumoUtility.BorderColor.CONTRAST),
    CONTRAST_90(LumoUtility.BorderColor.CONTRAST_90),
    CONTRAST_80(LumoUtility.BorderColor.CONTRAST_80),
    CONTRAST_70(LumoUtility.BorderColor.CONTRAST_70),
    CONTRAST_60(LumoUtility.BorderColor.CONTRAST_60),
    CONTRAST_50(LumoUtility.BorderColor.CONTRAST_50),
    CONTRAST_40(LumoUtility.BorderColor.CONTRAST_40),
    CONTRAST_30(LumoUtility.BorderColor.CONTRAST_30),
    CONTRAST_20(LumoUtility.BorderColor.CONTRAST_20),
    CONTRAST_10(LumoUtility.BorderColor.CONTRAST_10),
    CONTRAST_5(LumoUtility.BorderColor.CONTRAST_5),
    PRIMARY(LumoUtility.BorderColor.PRIMARY),
    PRIMARY_50(LumoUtility.BorderColor.PRIMARY_50),
    PRIMARY_10(LumoUtility.BorderColor.PRIMARY_10),
    ERROR(LumoUtility.BorderColor.ERROR),
    ERROR_50(LumoUtility.BorderColor.ERROR_50),
    ERROR_10(LumoUtility.BorderColor.ERROR_10),
    SUCCESS(LumoUtility.BorderColor.SUCCESS),
    SUCCESS_50(LumoUtility.BorderColor.SUCCESS_50),
    SUCCESS_10(LumoUtility.BorderColor.SUCCESS_10);

    private final String className;

    private BorderColor(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
