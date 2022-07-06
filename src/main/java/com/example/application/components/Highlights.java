package com.example.application.components;

import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Highlights extends Layout implements HasTheme {

	public static final String BORDER = "border";

	public Highlights(Highlight... highlights) {
		addClassNames(
				"highlights", LumoUtility.Background.BASE, LumoUtility.BorderRadius.MEDIUM,
				LumoUtility.FlexDirection.COLUMN, LumoUtility.FlexDirection.Breakpoint.Small.ROW,
				LumoUtility.Overflow.HIDDEN
		);
		add(highlights);
		setFlexWrap(FlexWrap.WRAP);
		setWidthFull();
	}

	public void add(Highlight... highlights) {
		for (Highlight highlight : highlights) {
			setFlexBasis("0", highlight);
			setFlexGrow(1, highlight);
		}
		super.add(highlights);
	}

}
