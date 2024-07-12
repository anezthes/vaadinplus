package com.example.application.views;

import com.example.application.views.components.ComponentView;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends ComponentView {

    public HomeView() {
        addClassNames(Padding.Top.LARGE);

        add(new Paragraph("Welcome to Vaadin+!"));
    }

}
