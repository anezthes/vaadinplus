package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum FontSize {
	XXSMALL(LumoUtility.FontSize.XXSMALL),
	XSMALL(LumoUtility.FontSize.XSMALL),
	SMALL(LumoUtility.FontSize.SMALL),
	MEDIUM(LumoUtility.FontSize.MEDIUM),
	LARGE(LumoUtility.FontSize.LARGE),
	XLARGE(LumoUtility.FontSize.XLARGE),
	XXLARGE(LumoUtility.FontSize.XXLARGE),
	XXXLARGE(LumoUtility.FontSize.XXXLARGE),
	;

	private final String className;

	private FontSize(String className) {
		this.className = className;
	}

	public String getClassName() {
		return this.className;
	}
}
