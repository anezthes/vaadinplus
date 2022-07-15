package com.example.application.views;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Steppers | Vaadin+")
@Route(value = "steppers", layout = MainLayout.class)
public class SteppersView extends Main {

	public SteppersView() {
		addClassNames(
				LumoUtility.MinHeight.FULL, LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE
		);


	}

}
