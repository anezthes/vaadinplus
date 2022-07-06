package com.example.application.components;

import com.example.application.utilities.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import java.util.HashMap;

public class Layout extends FlexLayout {

	private Display display;
	private GridColumns gridColumns;
	private HashMap<HasStyle, GridColumnSpan> gridColumnSpans;

	private ColumnGap colGap;
	private RowGap rowGap;

	public Layout(Component... components) {
		super(components);

		// Say "no" to inline styles! :)
		getStyle().remove("display");

		setDisplay(Display.FLEX);
		this.gridColumnSpans = new HashMap<>();
	}

	public void setDisplay(Display display) {
		if (this.display != null) {
			removeClassNames(this.display.getClassName());
		}
		addClassNames(display.getClassName());
		this.display = display;
	}

	public void setGridColumns(GridColumns gridColumns) {
		if (this.gridColumns != null) {
			removeClassNames(this.gridColumns.getClassName());
		}
		addClassNames(gridColumns.getClassName());
		this.gridColumns = gridColumns;
	}

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
