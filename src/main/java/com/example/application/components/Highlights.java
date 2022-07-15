package com.example.application.components;

import com.example.application.utilities.Breakpoint;
import com.example.application.utilities.FlexRowBreakpoint;
import com.example.application.utilities.Gap;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Highlights extends Layout implements HasTheme {

	public static final String DIVIDERS = "dividers";

	private FlexRowBreakpoint breakpoint;

	public Highlights(Highlight... highlights) {
		addClassNames("highlights", LumoUtility.FlexDirection.COLUMN, LumoUtility.Overflow.HIDDEN);
		add(highlights);
		setBreakpoint(Breakpoint.MEDIUM);
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

	public void setBreakpoint(Breakpoint breakpoint) {
		if (this.breakpoint != null) {
			removeClassNames(this.breakpoint.getClassName());
		}
		addClassNames(breakpoint.getFlexRowBreakpoint().getClassName());
		this.breakpoint = breakpoint.getFlexRowBreakpoint();
	}

	/**
	 * Simulates dividers between items.
	 */
	public void setDividers(boolean dividers) {
		if (dividers) {
			addThemeName(DIVIDERS);
		} else {
			removeThemeName(DIVIDERS);
		}
	}

	@Override
	public void setColumnGap(Gap gap) {
		super.setColumnGap(gap);
		removeClassNames(LumoUtility.Background.BASE);
	}

	@Override
	public void removeColumnGap() {
		super.removeColumnGap();
		addClassNames(LumoUtility.Background.BASE);
	}

	@Override
	public void setRowGap(Gap gap) {
		super.setRowGap(gap);
		removeClassNames(LumoUtility.Background.BASE);
	}

	@Override
	public void removeRowGap() {
		super.removeRowGap();
		addClassNames(LumoUtility.Background.BASE);
	}
}
