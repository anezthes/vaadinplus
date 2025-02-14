package com.example.application.view.template;

import com.example.application.view.MainLayout;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Communications")
@Route(value = "communications", layout = MainLayout.class)
public class CommunicationsView extends Main {

    public CommunicationsView() {
        // Sidebar
        // - Title
        // - Search
        // - List
        // Content
        // - Header
        // - Different types of messages
    }

}
