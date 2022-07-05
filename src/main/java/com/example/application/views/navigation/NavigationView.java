package com.example.application.views.navigation;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Navigation")
@Route(value = "navigation", layout = MainLayout.class)
public class NavigationView extends Main {

	public NavigationView() {

	}

}
