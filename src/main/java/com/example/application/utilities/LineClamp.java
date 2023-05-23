package com.example.application.utilities;

public enum LineClamp {
    LINE_CLAMP_1("line-clamp-1"),
    LINE_CLAMP_2("line-clamp-2"),
    LINE_CLAMP_3("line-clamp-3"),
    LINE_CLAMP_4("line-clamp-4");

    private final String className;

    private LineClamp(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }
}