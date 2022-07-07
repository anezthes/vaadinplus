package com.example.application.components;

import com.example.application.utilities.FontSize;
import com.example.application.utilities.Gap;
import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Header extends Layout {

	// Style
	private FontSize headingFontSize;

	// Components
	private Layout row;
	private Layout prefix;
	private Layout column;
	private Breadcrumb breadcrumb;
	private Component heading;
	private Layout details;
	private Layout actions;
	private Tabs tabs;

	public Header(String text) {
		this(text, HeadingLevel.H2);
	}

	public Header(String text, HeadingLevel level) {
		addClassNames(LumoUtility.Background.BASE, LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10);
		setFlexDirection(FlexDirection.COLUMN);

		this.prefix = new Layout();
		setPrefix(null);

		this.breadcrumb = new Breadcrumb();
		setBreadcrumb(null);

		setHeading(text, level);
		setHeadingFontSize(FontSize.XLARGE);

		this.details = new Layout();
		this.details.setFlexWrap(FlexWrap.WRAP);
		this.details.setColumnGap(Gap.MEDIUM);
		this.details.setRowGap(Gap.SMALL);
		setDetails(null);

		this.column = new Layout(this.breadcrumb, this.heading, this.details);
		this.column.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
		this.column.setFlexGrow(1, this.column);
		this.column.setGap(Gap.SMALL);

		this.actions = new Layout();
		this.actions.setGap(Gap.SMALL);
		setActions(null);

		this.row = new Layout(this.prefix, this.column, this.actions);
		this.row.addClassNames(LumoUtility.Padding.MEDIUM);
		this.row.setAlignItems(FlexComponent.Alignment.CENTER);
		this.row.setFlexWrap(FlexWrap.WRAP);
		this.row.setGap(Gap.MEDIUM);

		this.tabs = new Tabs();
		setTabs(null);

		add(this.row, this.tabs);
	}

	/**
	 * Returns the row layout.
	 * TODO: Needs better abstraction/naming.
	 */
	public Layout getRowLayout() {
		return this.row;
	}

	/**
	 * Returns the column layout.
	 * TODO: Needs better abstraction/naming.
	 */
	public Layout getColumnLayout() {
		return this.column;
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
	 * Sets the content of the breadcrumb.
	 */
	public void setBreadcrumb(Component... components) {
		this.breadcrumb.removeAll();
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.breadcrumb.add(component);
				}
			}
		}
		this.breadcrumb.setVisible(this.breadcrumb.getComponentCount() > 0);
	}

	/**
	 * Sets the heading text & level.
	 */
	public void setHeading(String text, HeadingLevel level) {
		Component heading;
		switch (level) {
			case H1:
				heading = new H1(text);
				break;
			case H2:
			default:
				heading = new H2(text);
				break;
			case H3:
				heading = new H3(text);
				break;
			case H4:
				heading = new H4(text);
				break;
			case H5:
				heading = new H5(text);
				break;
			case H6:
				heading = new H6(text);
				break;
		}
		((HasStyle) heading).addClassNames(LumoUtility.Margin.NONE);
		if (this.heading != null) {
			this.column.replace(this.heading, heading);
		}
		this.heading = heading;
	}

	/**
	 * Sets the heading's font size.
	 */
	public void setHeadingFontSize(FontSize fontSize) {
		if (this.headingFontSize != null) {
			((HasStyle) this.heading).removeClassName(this.headingFontSize.getClassName());
		}
		((HasStyle) this.heading).addClassNames(fontSize.getClassName());
		this.headingFontSize = fontSize;
	}

	/**
	 * Returns the details layout.
	 */
	public Layout getDetails() {
		return this.details;
	}

	/**
	 * Sets the details.
	 */
	public void setDetails(Component... components) {
		this.details.removeAll();
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.details.add(component);
				}
			}
		}
		this.details.setVisible(this.details.getComponentCount() > 0);
	}

	/**
	 * Sets the tabs.
	 */
	public void setTabs(Tab... tabs) {
		this.tabs.removeAll();
		if (tabs != null) {
			for (Tab tab : tabs) {
				if (tab != null) {
					this.tabs.add(tab);
				}
			}
		}
		if (this.tabs.getComponentCount() > 0) {
			removeClassNames(LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10);
			this.tabs.setVisible(true);
		} else {
			addClassNames(LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10);
			this.tabs.setVisible(false);
		}
	}

	/**
	 * Sets the actions.
	 */
	public void setActions(Component... components) {
		this.actions.removeAll();
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.actions.add(component);
				}
			}
		}
		this.actions.setVisible(this.actions.getComponentCount() > 0);
	}

}
