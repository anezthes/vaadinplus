package com.example.application.views;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Sidebar")
@Route(value = "sidebar", layout = MainLayout.class)
public class SidebarView extends View {

    public SidebarView() {
        addClassNames(LumoUtility.AlignItems.START, LumoUtility.Padding.Top.LARGE);


    }

}
