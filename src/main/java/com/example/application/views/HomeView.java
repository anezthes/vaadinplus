package com.example.application.views;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Home | Vaadin+")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

	public HomeView() {
		addClassNames(
				LumoUtility.MinHeight.FULL, LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE
		);

		add(new Paragraph("Welcome to Vaadin+!"));

	}

}
