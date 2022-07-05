package com.example.application.views.components;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Components")
@Route(value = "components", layout = MainLayout.class)
public class ComponentsView extends Main {

	public ComponentsView() {

	}

}
