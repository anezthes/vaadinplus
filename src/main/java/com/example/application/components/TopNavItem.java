package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.DomListenerRegistration;

public class TopNavItem extends SideNavItem {

    private DomListenerRegistration mouseover;
    private DomListenerRegistration mouseout;

    public TopNavItem(String label) {
        super(label);
        initMouseEventListeners();
    }

    public TopNavItem(String label, String path) {
        super(label, path);
        initMouseEventListeners();
    }

    public TopNavItem(String label, Class<? extends Component> view) {
        super(label, view);
        initMouseEventListeners();
    }

    public TopNavItem(String label, String path, Component prefixComponent) {
        super(label, path, prefixComponent);
        initMouseEventListeners();
    }

    public TopNavItem(String label, Class<? extends Component> view,
                      Component prefixComponent) {
        super(label, view, prefixComponent);
        initMouseEventListeners();
    }

    @Override
    protected void setupSideNavItem(SideNavItem item) {
        super.setupSideNavItem(item);
        initMouseEventListeners();
    }

    private void initMouseEventListeners() {
        if (getItems().size() > 0 && this.mouseover == null && this.mouseout == null) {
            this.mouseover = getElement().addEventListener("mouseover", e -> setExpanded(true));
            this.mouseout = getElement().addEventListener("mouseout", e -> setExpanded(false));
        }
    }

}
