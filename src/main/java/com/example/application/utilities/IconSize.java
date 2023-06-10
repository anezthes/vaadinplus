package com.example.application.utilities;

public enum IconSize {
    SMALL("var(--lumo-icon-size-s)"),
    MEDIUM("var(--lumo-icon-size-m)"),
    LARGE("var(--lumo-icon-size-l)");

    private final String cssVariable;

    private IconSize(String cssVariable) {
        this.cssVariable = cssVariable;
    }

    public String getCSSVariable() {
        return this.cssVariable;
    }
}
