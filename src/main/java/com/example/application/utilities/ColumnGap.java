package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum ColumnGap {
    XSMALL(LumoUtility.Gap.Column.XSMALL),
    SMALL(LumoUtility.Gap.Column.SMALL),
    MEDIUM(LumoUtility.Gap.Column.MEDIUM),
    LARGE(LumoUtility.Gap.Column.LARGE),
    XLARGE(LumoUtility.Gap.Column.XLARGE);

    private final String className;

    private ColumnGap(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
