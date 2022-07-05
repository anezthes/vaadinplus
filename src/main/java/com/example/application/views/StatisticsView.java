package com.example.application.views;

import com.example.application.components.Highlight;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Statistics | Vaadin+")
@Route(value = "statistics", layout = MainLayout.class)
public class StatisticsView extends Main {

	public StatisticsView() {
		addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.MinHeight.FULL, LumoUtility.Padding.LARGE);

		add(new H2("Basic"));
		Highlight highlight = new Highlight("Sales", "€427,609.37");
		add(highlight);
	}

}
