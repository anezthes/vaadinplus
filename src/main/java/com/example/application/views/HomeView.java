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
		addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.MinHeight.FULL, LumoUtility.Padding.LARGE);

		add(new Paragraph("Welcome to Vaadin+!"));

	}

}
