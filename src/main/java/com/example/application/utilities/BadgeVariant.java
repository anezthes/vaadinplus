package com.example.application.utilities;

public enum BadgeVariant {
    SMALL("small"),
    PRIMARY("primary"),
    SUCCESS("success"),
    ERROR("error"),
    CONTRAST("contrast"),
    PILL("pill");

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
