package com.example.application.utility;

public enum Breakpoint {
    SMALL("sm"),
    MEDIUM("md"),
    LARGE("lg"),
    XLARGE("xl"),
    XXLARGE("2xl");

    private final String prefix;

    Breakpoint(String prefix) {
        this.prefix = prefix;
    }

    public FlexRowBreakpoint getFlexRowBreakpoint() {
        return FlexRowBreakpoint.valueOf(this.name());
    }

    public String getPrefix() {
        return prefix;
    }
}
