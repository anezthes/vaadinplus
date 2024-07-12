package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.DomListenerRegistration;
import com.vaadin.flow.dom.Element;

public class TopNavItem extends SideNavItem {

    private DomListenerRegistration mouseover;
    private DomListenerRegistration mouseout;

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

    @Override
    protected void setupSideNavItem(SideNavItem item) {
        super.setupSideNavItem(item);
        initMouseEventListeners();
    }

    private void initMouseEventListeners() {
        Element element = getElement();
        this.mouseover = element.addEventListener("mouseover", e -> setExpanded(true));
        this.mouseout = element.addEventListener("mouseout", e -> setExpanded(false));
    }

}
