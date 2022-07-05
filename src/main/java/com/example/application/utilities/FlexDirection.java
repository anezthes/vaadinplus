package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum FlexDirection {
	COLUMN(LumoUtility.FlexDirection.COLUMN),
	ROW(LumoUtility.FlexDirection.ROW);

	private final String className;

	private FlexDirection(String className) {
		this.className = className;
	}

	public String getClassName() {
		return this.className;
	}
}
