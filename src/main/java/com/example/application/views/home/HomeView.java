package com.example.application.views.home;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home | Vaadin+")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

	public HomeView() {
		add(new Paragraph("Welcome to Vaadin+"));
	}

}
