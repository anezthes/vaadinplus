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
		this.prefix.setVisible(false);

		this.breadcrumb = new Breadcrumb();
		this.breadcrumb.setVisible(false);

		setHeading(text, level);
		setHeadingFontSize(FontSize.XLARGE);

		this.details = new Layout();
		this.details.setFlexWrap(FlexWrap.WRAP);
		this.details.setColumnGap(Gap.MEDIUM);
		this.details.setRowGap(Gap.SMALL);
		this.details.setVisible(false);

		this.column = new Layout(this.breadcrumb, this.heading, this.details);
		this.column.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
		this.column.setFlexGrow(1, this.column);
		this.column.setGap(Gap.SMALL);

		this.actions = new Layout();
		this.actions.setGap(Gap.SMALL);
		this.actions.setVisible(false);

		this.row = new Layout(this.prefix, this.column, this.actions);
		this.row.addClassNames(LumoUtility.Padding.MEDIUM);
		this.row.setAlignItems(FlexComponent.Alignment.CENTER);
		this.row.setFlexWrap(FlexWrap.WRAP);
		this.row.setGap(Gap.MEDIUM);

		this.tabs = new Tabs();
		this.tabs.setVisible(false);

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
		this.prefix.add(components);
		this.prefix.setVisible(components.length > 0);
	}

	/**
	 * Sets the content of the breadcrumb.
	 */
	public void setBreadcrumb(Component... components) {
		this.breadcrumb.removeAll();
		this.breadcrumb.setItems(components);
		this.breadcrumb.setVisible(components.length > 0);
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
		this.details.add(components);
		this.details.setVisible(components.length > 0);
	}

	/**
	 * Sets the tabs.
	 */
	public void setTabs(Tab... tabs) {
		this.tabs.removeAll();
		this.tabs.add(tabs);
		if (tabs.length > 0) {
			removeClassNames(LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10);
		}
		this.tabs.setVisible(tabs.length > 0);
	}

	/**
	 * Sets the actions.
	 */
	public void setActions(Component... components) {
		this.actions.removeAll();
		this.actions.add(components);
		this.actions.setVisible(components.length > 0);
	}

}
