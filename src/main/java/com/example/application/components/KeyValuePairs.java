package com.example.application.components;

import com.example.application.utilities.*;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.DescriptionList;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.HashMap;

public class KeyValuePairs extends DescriptionList implements HasTheme {

	public static final String BORDER = "border";
	public static final String STRIPES = "stripes";
	private Display display;
	private GridColumns gridColumns;
	private HashMap<HasStyle, GridColumnSpan> gridColumnSpans;
	private KeyValuePair[] pairs;

	public KeyValuePairs(KeyValuePair... pairs) {
		addClassNames("key-value-pairs", LumoUtility.Background.BASE, LumoUtility.Margin.NONE);
		this.gridColumnSpans = new HashMap<>();

		add(pairs);
		this.pairs = pairs;
	}

	/**
	 * Sets a bottom border on each KeyValuePair if true.
	 */
	public void setBorder(boolean border) {
		if (border) {
			addThemeName(BORDER);
		} else {
			removeThemeName(BORDER);
		}
	}

	/**
	 * Sets the breakpoint.
	 */
	public void setBreakpoint(FlexRowBreakpoint breakpoint) {
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
	 * Sets the display property.
	 */
	public void setDisplay(Display display) {
		if (this.display != null) {
			removeClassNames(this.display.getClassName());
		}
		addClassNames(display.getClassName());
		this.display = display;
	}

	/**
	 * Sets the label position of each KeyValuePair.
	 */
	public void setLabelPosition(LabelPosition position) {
		for (KeyValuePair pair : this.pairs) {
			pair.setFlexDirection(position.equals(LabelPosition.SIDE) ? FlexDirection.ROW : FlexDirection.COLUMN);
		}
	}

	/**
	 * Sets the number of grid columns.
	 * Only works if display is set to grid.
	 */
	public void setGridColumns(GridColumns gridColumns) {
		if (this.gridColumns != null) {
			removeClassNames(this.gridColumns.getClassName());
		}
		addClassNames(gridColumns.getClassName());
		this.gridColumns = gridColumns;
	}

	/**
	 * Sets the grid column span for the given components.
	 */
	public void setGridColumnSpan(GridColumnSpan gridColumnSpan, HasStyle... components) {
		for (HasStyle component : components) {
			if (this.gridColumnSpans.get(component) != null) {
				component.removeClassName(this.gridColumnSpans.get(component).getClassName());
			}
			component.addClassNames(gridColumnSpan.getClassName());
			this.gridColumnSpans.put(component, gridColumnSpan);
		}
	}

	/**
	 * Sets the key width for each KeyValuePair.
	 *
	 * @param width
	 * @param unit
	 */
	public void setKeyWidth(float width, Unit unit) {
		for (KeyValuePair pair : this.pairs) {
			pair.setKeyWidth(width, unit);
		}
	}

	/**
	 * Sets a light gray background color on every other KeyValuePair if true.
	 */
	public void setStripes(boolean stripes) {
		if (stripes) {
			addThemeName(STRIPES);
		} else {
			removeThemeName(STRIPES);
		}
	}

	public enum LabelPosition {
		SIDE, TOP
	}

}
