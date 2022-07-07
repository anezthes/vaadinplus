package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum FlexDirection {
	COLUMN(LumoUtility.FlexDirection.COLUMN),
	COLUMN_REVERSE(LumoUtility.FlexDirection.COLUMN_REVERSE),
	ROW(LumoUtility.FlexDirection.ROW),
	ROW_REVERSE(LumoUtility.FlexDirection.ROW_REVERSE);

	private final String className;

	private FlexDirection(String className) {
		this.className = className;
	}

	public String getClassName() {
		return this.className;
	}
}
