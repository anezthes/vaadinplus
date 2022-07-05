package com.example.application.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Tag extends Span {

	public Tag(VaadinIcon vaadinIcon, String text) {
		addClassNames(
				LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.FontSize.SMALL,
				LumoUtility.Gap.SMALL, LumoUtility.TextColor.SECONDARY
		);

		Icon icon = vaadinIcon.create();
		icon.addClassNames(LumoUtility.IconSize.SMALL);

		add(icon, new Text(text));
	}

}
