package com.example.application.views.pageexamples;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Page Examples")
@Route(value = "page-examples", layout = MainLayout.class)
public class PageExamplesView extends Main {

	public PageExamplesView() {

	}

}
