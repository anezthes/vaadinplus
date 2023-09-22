package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.sidenav.SideNavItem;

public class TopNavItem extends SideNavItem {

    public TopNavItem(String label) {
        super(label);
    }

    public TopNavItem(String label, String path) {
        super(label, path);
    }

    public TopNavItem(String label, Class<? extends Component> view) {
        super(label, view);
    }

    public TopNavItem(String label, String path, Component prefixComponent) {
        super(label, path, prefixComponent);
    }

    public TopNavItem(String label, Class<? extends Component> view,
                      Component prefixComponent) {
        super(label, view, prefixComponent);
    }

}
