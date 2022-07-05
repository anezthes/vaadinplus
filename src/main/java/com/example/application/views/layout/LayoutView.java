package com.example.application.views.layout;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Layout")
@Route(value = "layout", layout = MainLayout.class)
public class LayoutView extends Main {

	public LayoutView() {

	}

}
