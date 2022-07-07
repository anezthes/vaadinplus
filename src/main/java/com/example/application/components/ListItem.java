package com.example.application.components;

import com.example.application.utilities.ColumnGap;
import com.example.application.utilities.Gap;
import com.example.application.utilities.RowGap;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ListItem extends com.vaadin.flow.component.html.ListItem {

	// Style
	private ColumnGap colGap;
	private RowGap rowGap;

	// Components
	private Layout prefix;
	private Layout column;
	private Layout primary;
	private Layout secondary;
	private Layout suffix;

	public ListItem(String primary, String secondary) {
		this(null, new Text(primary), new Text(secondary), null);
	}

	public ListItem(Component primary, Component secondary) {
		this(null, primary, secondary, null);
	}

	public ListItem(Component prefix, String primary, String secondary) {
		this(prefix, new Text(primary), new Text(secondary), null);
	}

	public ListItem(String primary, String secondary, Component suffix) {
		this(null, new Text(primary), new Text(secondary), suffix);
	}

	public ListItem(Component prefix, String primary, String secondary, Component suffix) {
		this(prefix, new Text(primary), new Text(secondary), suffix);
	}

	public ListItem(Component prefix, Component primary, Component secondary, Component suffix) {
		addClassNames(
				LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.Gap.MEDIUM,
				LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Padding.Vertical.SMALL
		);

		this.prefix = new Layout();
		setPrefix(prefix);

		this.primary = new Layout();
		setPrimary(primary);

		this.secondary = new Layout();
		this.secondary.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);
		setSecondary(secondary);

		this.column = new Layout(this.primary, this.secondary);
		this.column.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
		this.column.setFlexGrow(1, this.column);

		this.suffix = new Layout();
		setSuffix(suffix);

		add(this.prefix, this.column, this.suffix);
	}

	/**
	 * Sets the prefix.
	 */
	public void setPrefix(Component... components) {
		this.prefix.removeAll();
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.prefix.add(component);
				}
			}
		}
		this.prefix.setVisible(this.prefix.getComponentCount() > 0);
	}

	/**
	 * Sets the primary content.
	 */
	public void setPrimary(Component... components) {
		this.primary.removeAll();
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.primary.add(component);
				}
			}
		}
		this.primary.setVisible(this.primary.getComponentCount() > 0);
	}

	/**
	 * Sets the secondary content.
	 */
	public void setSecondary(Component... components) {
		this.secondary.removeAll();
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.secondary.add(component);
				}
			}
		}
		this.secondary.setVisible(this.secondary.getComponentCount() > 0);
	}

	/**
	 * Sets the suffix.
	 */
	public void setSuffix(Component... components) {
		this.suffix.removeAll();
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.suffix.add(component);
				}
			}
		}
		this.suffix.setVisible(this.suffix.getComponentCount() > 0);
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
