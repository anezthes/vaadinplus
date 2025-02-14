package com.example.application.utility;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum FlexRowBreakpoint {
    SMALL(LumoUtility.FlexDirection.Breakpoint.Small.ROW),
    MEDIUM(LumoUtility.FlexDirection.Breakpoint.Medium.ROW),
    LARGE(LumoUtility.FlexDirection.Breakpoint.Large.ROW),
    XLARGE(LumoUtility.FlexDirection.Breakpoint.XLarge.ROW),
    XXLARGE(LumoUtility.FlexDirection.Breakpoint.XXLarge.ROW);

    private final String className;

    FlexRowBreakpoint(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}
