package com.example.application.components;

import com.example.application.utilities.*;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.DescriptionList;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class KeyValuePairs extends DescriptionList implements HasTheme {

	public static final String BORDER = "border";
	public static final String STRIPES = "stripes";
	private Display display;
	private GridColumns gridColumns;
	private KeyValuePair[] pairs;

	public KeyValuePairs(KeyValuePair... pairs) {
		addClassNames(LumoUtility.Background.BASE, LumoUtility.Margin.NONE);
		add(pairs);
		this.pairs = pairs;
	}

	public void setBorder(boolean border) {
		if (border) {
			addThemeName(BORDER);
		} else {
			removeThemeName(BORDER);
		}
	}

	public void setBreakpoint(FlexRowBreakpoint breakpoint) {
		for (KeyValuePair pair : this.pairs) {
			pair.setBreakpoint(breakpoint);
		}
	}

	public void removeBreakpoint() {
		for (KeyValuePair pair : this.pairs) {
			pair.removeBreakpoint();
		}
	}

	public void setDisplay(Display display) {
		if (this.display != null) {
			removeClassNames(this.display.getClassName());
		}
		addClassNames(display.getClassName());
		this.display = display;
	}

	public void setFlexDirection(FlexDirection direction) {
		for (KeyValuePair pair : this.pairs) {
			pair.setFlexDirection(direction);
		}
	}

	public void setGridColumns(GridColumns gridColumns) {
		if (this.gridColumns != null) {
			removeClassNames(this.gridColumns.getClassName());
		}
		addClassNames(gridColumns.getClassName());
		this.gridColumns = gridColumns;
	}

	public void setGridColumnSpan(GridColumnSpan columnSpan, HasStyle... components) {
		for (HasStyle component : components) {
			component.addClassNames(columnSpan.getClassName());
		}
	}

	public void setKeyWidth(float width, Unit unit) {
		for (KeyValuePair pair : this.pairs) {
			pair.setKeyWidth(width, unit);
		}
	}

	public void setStripes(boolean stripes) {
		if (stripes) {
			addThemeName(STRIPES);
		} else {
			removeThemeName(STRIPES);
		}
	}

	public enum DisplayMode {
		GRID, LIST
	}

}
