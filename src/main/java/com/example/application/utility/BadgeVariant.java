package com.example.application.utility;

public enum BadgeVariant {
    CONTRAST("contrast"),
    ERROR("error"),
    PILL("pill"),
    PRIMARY("primary"),
    SMALL("small"),
    SUCCESS("success"),
    WARNING("warning");

    private final String variant;

    BadgeVariant(String variant) {
        this.variant = variant;
    }

    /**
     * Gets the variant name.
     *
     * @return variant name
     */
    public String getVariantName() {
        return variant;
    }
}
