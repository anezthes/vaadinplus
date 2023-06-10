package com.example.application.utilities;

public enum Size {
    XSMALL("var(--lumo-size-xs)"),
    SMALL("var(--lumo-size-s)"),
    MEDIUM("var(--lumo-size-m)"),
    LARGE("var(--lumo-size-l)"),
    XLARGE("var(--lumo-size-xl)");

    private final String cssVariable;

    private Size(String cssVariable) {
        this.cssVariable = cssVariable;
    }

    public String getCSSVariable() {
        return this.cssVariable;
    }
}
