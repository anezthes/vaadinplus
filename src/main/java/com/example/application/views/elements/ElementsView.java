package com.example.application.views.elements;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Elements")
@Route(value = "elements", layout = MainLayout.class)
public class ElementsView extends Main {

	public ElementsView() {

	}

}
