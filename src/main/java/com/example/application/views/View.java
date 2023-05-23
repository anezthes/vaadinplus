package com.example.application.views;

import com.example.application.components.Breadcrumb;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class View extends Main {

	public View() {
		addClassNames(
				LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN, LumoUtility.Padding.Bottom.LARGE,
				LumoUtility.Padding.Horizontal.LARGE
		);
	}

	public void addH2(String text) {
		H2 h2 = new H2(text);
		h2.addClassNames(LumoUtility.Margin.Bottom.MEDIUM, LumoUtility.Margin.Top.LARGE);
		add(h2);
	}

}
