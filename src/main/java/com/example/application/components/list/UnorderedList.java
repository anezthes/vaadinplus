package com.example.application.components.list;

import com.example.application.utilities.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class UnorderedList extends com.vaadin.flow.component.html.UnorderedList implements HasTheme {

	public static final String BORDER = "border";

	// Style
	private BackgroundColor backgroundColor;
	private Display display;
	private ColumnGap colGap;
	private RowGap rowGap;

	public UnorderedList(Component... components) {
		add(components);
		addClassNames(LumoUtility.ListStyleType.NONE, LumoUtility.Margin.NONE, LumoUtility.Padding.NONE);
		setDisplay(Display.GRID);
	}

	/**
	 * Sets auto-sizing for grid columns with a minimum width for each column.
	 */
	public void setAutoFill(float width, Unit unit) {
		getStyle().set("grid-template-columns", "repeat(auto-fill, minmax(" + width + unit.toString() + ", 1fr))");
	}

	/**
	 * Sets the background color.
	 */
	public void setBackgroundColor(BackgroundColor backgroundColor) {
		removeBackgroundColor();
		addClassNames(backgroundColor.getClassName());
		this.backgroundColor = backgroundColor;
	}

	/**
	 * Removes the background color.
	 */
	public void removeBackgroundColor() {
		if (this.backgroundColor != null) {
			this.removeClassName(this.backgroundColor.getClassName());
		}
		this.backgroundColor = null;
	}

	/**
	 * Sets a bottom border on each ListItem if true.
	 */
	public void setBorder(boolean border) {
		if (border) {
			addThemeName(BORDER);
		} else {
			removeThemeName(BORDER);
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
	 * Sets both the column (horizontal) and row (vertical) gap between components.
	 */
	public void setGap(Gap gap) {
		setColumnGap(gap);
		setRowGap(gap);
	}

	/**
	 * Sets the column (horizontal) gap between components.
	 */
	public void setColumnGap(Gap gap) {
		removeColumnGap();
		this.addClassNames(gap.getColumnGap().getClassName());
		this.colGap = gap.getColumnGap();
	}

	/**
	 * Sets the row (vertical) gap between components.
	 */
	public void setRowGap(Gap gap) {
		removeRowGap();
		this.addClassNames(gap.getRowGap().getClassName());
		this.rowGap = gap.getRowGap();
	}

	/**
	 * Removes both the column (horizontal) and row (vertical) gap between components.
	 */
	public void removeGap() {
		removeColumnGap();
		removeRowGap();
	}

	/**
	 * Removes the column (horizontal) gap between components.
	 */
	public void removeColumnGap() {
		if (this.colGap != null) {
			this.removeClassName(this.colGap.getClassName());
		}
		this.colGap = null;
	}

	/**
	 * Removes the row (vertical) gap between components.
	 */
	public void removeRowGap() {
		if (this.rowGap != null) {
			this.removeClassName(this.rowGap.getClassName());
		}
		this.rowGap = null;
	}

}
