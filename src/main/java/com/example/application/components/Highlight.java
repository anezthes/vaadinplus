package com.example.application.components;

import com.example.application.utilities.FontSize;
import com.example.application.utilities.Gap;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Highlight extends Layout {

	// Style
	private FontSize valueFontSize;

	// Components
	private Layout prefix;
	private Layout column;
	private Component label;
	private Component value;
	private Layout details;
	private Layout suffix;

	public Highlight(String label, String value) {
		addClassNames(LumoUtility.Padding.MEDIUM);
		setAlignItems(FlexComponent.Alignment.CENTER);
		setGap(Gap.MEDIUM);

		this.prefix = new Layout();
		this.prefix.setVisible(false);

		this.label = new Span(label);
		((HasStyle) this.label).addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

		this.value = new Span(value);
		((HasStyle) this.value).addClassNames(LumoUtility.FontWeight.MEDIUM);
		setValueFontSize(FontSize.XLARGE);

		this.details = new Layout();
		this.details.setFlexWrap(FlexWrap.WRAP);
		this.details.setColumnGap(Gap.MEDIUM);
		this.details.setVisible(false);

		this.column = new Layout(this.label, this.value, this.details);
		this.column.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
		this.column.setFlexGrow(1, this.column);

		this.suffix = new Layout();
		this.suffix.setVisible(false);

		add(this.prefix, this.column, this.suffix);
	}

	/**
	 * Sets the prefix.
	 */
	public void setPrefix(Component... components) {
		this.prefix.removeAll();
		this.prefix.add(components);
		this.prefix.setVisible(components != null);
	}

	/**
	 * Sets the value's font size.
	 */
	public void setValueFontSize(FontSize fontSize) {
		if (this.valueFontSize != null) {
			((HasStyle) this.value).removeClassName(this.valueFontSize.getClassName());
		}
		((HasStyle) this.value).addClassNames(fontSize.getClassName());
		this.valueFontSize = fontSize;
	}

	/**
	 * Sets the details.
	 */
	public void setDetails(Component... components) {
		this.details.removeAll();
		this.details.add(components);
		this.details.setVisible(components != null);
	}

	/**
	 * Returns the details layout.
	 */
	public Layout getDetailsLayout() {
		return this.details;
	}

	/**
	 * Sets the suffix.
	 */
	public void setSuffix(Component... components) {
		this.suffix.removeAll();
		this.suffix.add(components);
		this.suffix.setVisible(components != null);
	}

}
