package com.example.application.view.component;

import com.example.application.theme.MenuBarTheme;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Menu bars")
@Route(value = "menu-bars", layout = MainLayout.class)
public class MenuBarsView extends ComponentView {

    public MenuBarsView() {
        addH2("Theme: rounded");
        add(createMenuBar(MenuBarTheme.ROUNDED));

        addH2("Theme: rounded & gap (small)");
        add(createMenuBar(MenuBarTheme.ROUNDED, MenuBarTheme.GAP_SMALL));

        addH2("Theme: rounded & gap (medium)");
        add(createMenuBar(MenuBarTheme.ROUNDED, MenuBarTheme.GAP_MEDIUM));
    }

    private Component createMenuBar(String... themeNames) {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeNames(themeNames);

        menuBar.addItem("Menu item 1");
        menuBar.addItem("Menu item 2");
        menuBar.addItem("Menu item 3");

        return menuBar;
    }

}
