package com.example.application.views;

import com.example.application.components.Breadcrumb;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Breadcrumbs")
@Route(value = "breadcrumbs", layout = MainLayout.class)
public class BreadcrumbsView extends View {

    public BreadcrumbsView() {
        addH2("Basic");
        add(new Breadcrumb(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Breadcrumbs", BreadcrumbsView.class)
        ));
    }

}
