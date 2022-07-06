package com.example.application.components;

import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Tag extends Span {

	private TextColor textColor;
	private Icon icon;
	private Text text;

	public Tag(VaadinIcon icon, String text, TextColor textColor) {
		addClassNames(
				LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.FontSize.SMALL,
				LumoUtility.Gap.SMALL
		);
		setTextColor(textColor);

		if (icon != null) {
			this.icon = icon.create();
			this.icon.addClassNames(LumoUtility.IconSize.SMALL);
			add(this.icon);
		}

		this.text = new Text(text);
		add(this.text);
	}

	public Tag(VaadinIcon icon, String text) {
		this(icon, text, TextColor.SECONDARY);
	}

	public Tag(String text, TextColor textColor) {
		this(null, text, textColor);
	}

	public Tag(String text) {
		this(null, text);
	}

	public void setTextColor(TextColor textColor) {
		if (this.textColor != null) {
			removeClassNames(this.textColor.getClassName());
		}
		addClassNames(textColor.getClassName());
		this.textColor = textColor;
	}

}
