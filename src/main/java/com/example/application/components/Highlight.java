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
		this(null, label, value, null);
	}

	public Highlight(Component prefix, String label, String value) {
		this(prefix, label, value, null);
	}

	public Highlight(String label, String value, Component suffix) {
		this(null, label, value, suffix);
	}

	public Highlight(Component prefix, String label, String value, Component suffix) {
		addClassNames(LumoUtility.Background.BASE, LumoUtility.BorderRadius.MEDIUM, LumoUtility.Padding.MEDIUM);
		setAlignItems(FlexComponent.Alignment.CENTER);
		setGap(Gap.MEDIUM);

		this.prefix = new Layout();
		setPrefix(prefix);

		this.label = new Span(label);
		((HasStyle) this.label).addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

		this.value = new Span(value);
		((HasStyle) this.value).addClassNames(LumoUtility.FontWeight.MEDIUM);
		setValueFontSize(FontSize.XLARGE);

		this.details = new Layout();
		this.details.setFlexWrap(FlexWrap.WRAP);
		this.details.setGap(Gap.SMALL);
		setDetails(null);

		this.column = new Layout(this.label, this.value, this.details);
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
		if (components != null) {
			for (Component component : components) {
				if (component != null) {
					this.suffix.add(component);
				}
			}
		}
		this.suffix.setVisible(this.suffix.getComponentCount() > 0);
	}

}
