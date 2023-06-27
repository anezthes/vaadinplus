package com.example.application.views.components;

import com.example.application.components.Breadcrumb;
import com.example.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Breadcrumbs")
@Route(value = "breadcrumbs", layout = MainLayout.class)
public class BreadcrumbsView extends ComponentView {

    public BreadcrumbsView() {
        addClassNames(LumoUtility.Padding.Top.LARGE);

        add(new Breadcrumb(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Breadcrumbs", BreadcrumbsView.class)
        ));
    }

}
