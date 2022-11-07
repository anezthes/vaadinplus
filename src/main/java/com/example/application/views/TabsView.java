package com.example.application.views;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Tabs")
@Route(value = "tabs", layout = MainLayout.class)
public class TabsView extends Main {

	public TabsView() {
		addClassNames(
				LumoUtility.AlignItems.START, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
				LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE
		);

		// Different styles


	}

}
