package com.example.application.components;

import com.vaadin.flow.theme.lumo.LumoUtility;

public class UnorderedList extends com.vaadin.flow.component.html.UnorderedList {

	public UnorderedList(ListItem... items) {
		add(items);
		addClassNames(
				LumoUtility.Background.BASE, LumoUtility.ListStyleType.NONE, LumoUtility.Margin.NONE,
				LumoUtility.Padding.NONE
		);
	}

}
