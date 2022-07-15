package com.example.application.components;

import com.example.application.utilities.Breakpoint;
import com.example.application.utilities.GridColumnSpan;
import com.example.application.utilities.GridColumns;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.DescriptionList;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.HashMap;

public class KeyValuePairs extends DescriptionList implements HasTheme {

	public static final String DIVIDERS = "dividers";
	public static final String STRIPES = "stripes";

	private GridColumns columns;
	private HashMap<HasStyle, GridColumnSpan> columnSpans;
	private KeyValuePair[] pairs;

	public KeyValuePairs(KeyValuePair... pairs) {
		addClassNames(
				"key-value-pairs", LumoUtility.Background.BASE, LumoUtility.Display.GRID, LumoUtility.Margin.NONE
		);
		this.columnSpans = new HashMap<>();
		this.pairs = pairs;
		add(this.pairs);
	}

	/**
	 * Sets the breakpoint for when keys are positioned on top.
	 * Only works with KeyPosition.SIDE. Otherwise, keys are always on top.
	 */
	public void setBreakpoint(Breakpoint breakpoint) {
		for (KeyValuePair pair : this.pairs) {
			pair.setBreakpoint(breakpoint);
		}
	}

	/**
	 * Removes the breakpoint.
	 */
	public void removeBreakpoint() {
		for (KeyValuePair pair : this.pairs) {
			pair.removeBreakpoint();
		}
	}

	/**
	 * Sets the number of columns.
	 */
	public void setColumns(GridColumns columns) {
		if (this.columns != null) {
			removeClassNames(this.columns.getClassName());
		}
		addClassNames(columns.getClassName());
		this.columns = columns;
	}

	/**
	 * Sets the column span for the given components.
	 */
	public void setColumnSpan(GridColumnSpan columnSpan, HasStyle... components) {
		for (HasStyle component : components) {
			if (this.columnSpans.get(component) != null) {
				component.removeClassName(this.columnSpans.get(component).getClassName());
			}
			component.addClassNames(columnSpan.getClassName());
			this.columnSpans.put(component, columnSpan);
		}
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

	/**
	 * Sets the key position of each KeyValuePair.
	 */
	public void setKeyPosition(KeyValuePair.KeyPosition keyPosition) {
		for (KeyValuePair pair : this.pairs) {
			pair.setKeyPosition(keyPosition);
		}
	}

	/**
	 * Sets the key width for each KeyValuePair.
	 */
	public void setKeyWidth(float width, Unit unit) {
		for (KeyValuePair pair : this.pairs) {
			pair.setKeyWidth(width, unit);
		}
	}

	/**
	 * Sets a background color on every other KeyValuePair if true.
	 */
	public void setStripes(boolean stripes) {
		if (stripes) {
			addThemeName(STRIPES);
		} else {
			removeThemeName(STRIPES);
		}
	}

}
