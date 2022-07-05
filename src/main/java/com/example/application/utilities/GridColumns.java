package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum GridColumns {
	COLUMNS_1(LumoUtility.Grid.Column.COLUMNS_1),
	COLUMNS_2(LumoUtility.Grid.Column.COLUMNS_2),
	COLUMNS_3(LumoUtility.Grid.Column.COLUMNS_3),
	COLUMNS_4(LumoUtility.Grid.Column.COLUMNS_4),
	COLUMNS_5(LumoUtility.Grid.Column.COLUMNS_5),
	COLUMNS_6(LumoUtility.Grid.Column.COLUMNS_6),
	COLUMNS_7(LumoUtility.Grid.Column.COLUMNS_7),
	COLUMNS_8(LumoUtility.Grid.Column.COLUMNS_8),
	COLUMNS_9(LumoUtility.Grid.Column.COLUMNS_9),
	COLUMNS_10(LumoUtility.Grid.Column.COLUMNS_10),
	COLUMNS_11(LumoUtility.Grid.Column.COLUMNS_11),
	COLUMNS_12(LumoUtility.Grid.Column.COLUMNS_12);

	private final String className;

	private GridColumns(String className) {
		this.className = className;
	}

	public String getClassName() {
		return this.className;
	}
}
