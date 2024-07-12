package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public class Font {

    public enum LineHeight {
        NONE(LumoUtility.LineHeight.NONE),
        XSMALL(LumoUtility.LineHeight.XSMALL),
        SMALL(LumoUtility.LineHeight.SMALL),
        MEDIUM(LumoUtility.LineHeight.MEDIUM);

        private final String className;

        private LineHeight(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum Size {
        XXSMALL(LumoUtility.FontSize.XXSMALL),
        XSMALL(LumoUtility.FontSize.XSMALL),
        SMALL(LumoUtility.FontSize.SMALL),
        MEDIUM(LumoUtility.FontSize.MEDIUM),
        LARGE(LumoUtility.FontSize.LARGE),
        XLARGE(LumoUtility.FontSize.XLARGE),
        XXLARGE(LumoUtility.FontSize.XXLARGE),
        XXXLARGE(LumoUtility.FontSize.XXXLARGE);

        private final String className;

        private Size(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum Weight {
        THIN(LumoUtility.FontWeight.THIN),
        EXTRALIGHT(LumoUtility.FontWeight.EXTRALIGHT),
        LIGHT(LumoUtility.FontWeight.LIGHT),
        NORMAL(LumoUtility.FontWeight.NORMAL),
        MEDIUM(LumoUtility.FontWeight.MEDIUM),
        SEMIBOLD(LumoUtility.FontWeight.SEMIBOLD),
        BOLD(LumoUtility.FontWeight.BOLD),
        EXTRABOLD(LumoUtility.FontWeight.EXTRABOLD),
        BLACK(LumoUtility.FontWeight.BLACK);

        private final String className;

        private Weight(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

}
