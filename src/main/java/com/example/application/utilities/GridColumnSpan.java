package com.example.application.utilities;

import com.vaadin.flow.theme.lumo.LumoUtility;

public enum GridColumnSpan {
	COLUMN_SPAN_1(LumoUtility.Grid.Column.COLUMN_SPAN_1),
	COLUMN_SPAN_2(LumoUtility.Grid.Column.COLUMN_SPAN_2),
	COLUMN_SPAN_3(LumoUtility.Grid.Column.COLUMN_SPAN_3),
	COLUMN_SPAN_4(LumoUtility.Grid.Column.COLUMN_SPAN_4),
	COLUMN_SPAN_5(LumoUtility.Grid.Column.COLUMN_SPAN_5),
	COLUMN_SPAN_6(LumoUtility.Grid.Column.COLUMN_SPAN_6),
	COLUMN_SPAN_7(LumoUtility.Grid.Column.COLUMN_SPAN_7),
	COLUMN_SPAN_8(LumoUtility.Grid.Column.COLUMN_SPAN_8),
	COLUMN_SPAN_9(LumoUtility.Grid.Column.COLUMN_SPAN_9),
	COLUMN_SPAN_10(LumoUtility.Grid.Column.COLUMN_SPAN_10),
	COLUMN_SPAN_11(LumoUtility.Grid.Column.COLUMN_SPAN_11),
	COLUMN_SPAN_12(LumoUtility.Grid.Column.COLUMN_SPAN_12);

	private final String className;

	private GridColumnSpan(String className) {
		this.className = className;
	}

	public String getClassName() {
		return this.className;
	}
}
