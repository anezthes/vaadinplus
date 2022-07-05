package com.example.application.components;

import com.example.application.utilities.Gap;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Layout extends FlexLayout {

	private String colGap;
	private String rowGap;

	public Layout(Component... components) {
		super(components);
	}

	/**
	 * Sets the space between components.
	 */
	public void setGap(Gap gap) {
		setColumnGap(gap);
		setRowGap(gap);
	}

	public void setColumnGap(Gap gap) {
		String colGap;
		switch (gap) {
			case XSMALL:
				colGap = LumoUtility.Gap.Column.XSMALL;
				break;
			case SMALL:
				colGap = LumoUtility.Gap.Column.SMALL;
				break;
			case MEDIUM:
			default:
				colGap = LumoUtility.Gap.Column.MEDIUM;
				break;
			case LARGE:
				colGap = LumoUtility.Gap.Column.LARGE;
				break;
			case XLARGE:
				colGap = LumoUtility.Gap.Column.XLARGE;
				break;
		}
		removeColumnGap();
		this.addClassNames(colGap);
		this.colGap = colGap;
	}

	public void setRowGap(Gap gap) {
		String rowGap;
		switch (gap) {
			case XSMALL:
				rowGap = LumoUtility.Gap.Row.XSMALL;
				break;
			case SMALL:
				rowGap = LumoUtility.Gap.Row.SMALL;
				break;
			case MEDIUM:
			default:
				rowGap = LumoUtility.Gap.Row.MEDIUM;
				break;
			case LARGE:
				rowGap = LumoUtility.Gap.Row.LARGE;
				break;
			case XLARGE:
				rowGap = LumoUtility.Gap.Row.XLARGE;
				break;
		}
		removeRowGap();
		this.addClassNames(rowGap);
		this.rowGap = rowGap;
	}

	public void removeGap() {
		removeColumnGap();
		removeRowGap();
	}

	public void removeColumnGap() {
		if (this.colGap != null) {
			this.removeClassName(this.colGap);
		}
		this.colGap = null;
	}

	public void removeRowGap() {
		if (this.rowGap != null) {
			this.removeClassName(this.rowGap);
		}
		this.rowGap = null;
	}

}
