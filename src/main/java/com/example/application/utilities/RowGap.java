package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum RowGap {
    XSMALL(LumoUtility.Gap.Row.XSMALL),
    SMALL(LumoUtility.Gap.Row.SMALL),
    MEDIUM(LumoUtility.Gap.Row.MEDIUM),
    LARGE(LumoUtility.Gap.Row.LARGE),
    XLARGE(LumoUtility.Gap.Row.XLARGE);

    private final String className;

    private RowGap(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
