package com.example.application.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends View {

    public HomeView() {
        addClassNames(LumoUtility.Padding.Top.LARGE);

        add(new Paragraph("Welcome to Vaadin+!"));
    }

}
