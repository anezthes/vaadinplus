package com.example.application.component;

import com.example.application.theme.SideNavTheme;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.sidenav.SideNav;

public class TopNav extends SideNav implements HasTheme {

    public TopNav() {
        addThemeName(SideNavTheme.TOP);
    }

    public TopNav(String label) {
        super(label);
        addThemeName(SideNavTheme.TOP);
    }

}
