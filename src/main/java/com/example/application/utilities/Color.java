package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public class Color {
    public enum Background {
        BASE(LumoUtility.Background.BASE),
        TRANSPARENT(LumoUtility.Background.TRANSPARENT),
        CONTRAST(LumoUtility.Background.CONTRAST),
        CONTRAST_90(LumoUtility.Background.CONTRAST_90),
        CONTRAST_80(LumoUtility.Background.CONTRAST_80),
        CONTRAST_70(LumoUtility.Background.CONTRAST_70),
        CONTRAST_60(LumoUtility.Background.CONTRAST_60),
        CONTRAST_50(LumoUtility.Background.CONTRAST_50),
        CONTRAST_40(LumoUtility.Background.CONTRAST_40),
        CONTRAST_30(LumoUtility.Background.CONTRAST_30),
        CONTRAST_20(LumoUtility.Background.CONTRAST_20),
        CONTRAST_10(LumoUtility.Background.CONTRAST_10),
        CONTRAST_5(LumoUtility.Background.CONTRAST_5),
        PRIMARY(LumoUtility.Background.PRIMARY),
        PRIMARY_50(LumoUtility.Background.PRIMARY_50),
        PRIMARY_10(LumoUtility.Background.PRIMARY_10),
        ERROR(LumoUtility.Background.ERROR),
        ERROR_50(LumoUtility.Background.ERROR_50),
        ERROR_10(LumoUtility.Background.ERROR_10),
        SUCCESS(LumoUtility.Background.SUCCESS),
        SUCCESS_50(LumoUtility.Background.SUCCESS_50),
        SUCCESS_10(LumoUtility.Background.SUCCESS_10);

        private final String className;

        private Background(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum Text {
        HEADER(LumoUtility.TextColor.HEADER),
        BODY(LumoUtility.TextColor.BODY),
        SECONDARY(LumoUtility.TextColor.SECONDARY),
        TERTIARY(LumoUtility.TextColor.TERTIARY),
        DISABLED(LumoUtility.TextColor.DISABLED),
        PRIMARY(LumoUtility.TextColor.PRIMARY),
        PRIMARY_CONTRAST(LumoUtility.TextColor.PRIMARY_CONTRAST),
        ERROR(LumoUtility.TextColor.ERROR),
        ERROR_CONTRAST(LumoUtility.TextColor.ERROR_CONTRAST),
        SUCCESS(LumoUtility.TextColor.SUCCESS),
        SUCCESS_CONTRAST(LumoUtility.TextColor.SUCCESS_CONTRAST);

        private final String className;

        private Text(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

}
