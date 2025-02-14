package com.example.application.view.component;

import com.example.application.theme.TabTheme;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tabs")
@Route(value = "tabs", layout = MainLayout.class)
public class TabsView extends ComponentView {

    public TabsView() {
        addH2("Theme: segmented");

        Tabs tabs = new Tabs(new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"));
        tabs.addThemeName(TabTheme.SEGMENTED);
        tabs.getChildren().forEach(component -> component.getElement().getThemeList().add(TabTheme.SEGMENTED));
        add(tabs);
    }

}
