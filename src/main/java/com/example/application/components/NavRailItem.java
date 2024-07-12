package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.DomListenerRegistration;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.theme.lumo.LumoUtility.Accessibility;

public class NavRailItem extends SideNavItem {

    private Span label;
    private DomListenerRegistration mouseover;
    private DomListenerRegistration mouseout;
    private DomListenerRegistration focus;
    private DomListenerRegistration blur;

    public NavRailItem(String label) {
        super(null);
        setLabel(label);
    }

    public NavRailItem(String label, String path) {
        this(label);
        setPath(path);
    }

    public NavRailItem(String label, Class<? extends Component> view) {
        this(label);
        setPath(view);
    }

    public NavRailItem(String label, String path, Component prefixComponent) {
        this(label);
        setPath(path);
        setPrefixComponent(prefixComponent);
    }

    public NavRailItem(String label, Class<? extends Component> view,
                       Component prefixComponent) {
        this(label);
        setPath(view);
        setPrefixComponent(prefixComponent);
    }

    public void addItem(NavRailItem... items) {
        super.addItem(items);
        for (NavRailItem item : items) {
            item.label.removeClassName(Accessibility.SCREEN_READER_ONLY);
        }
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(null);
        if (this.label == null) {
            this.label = new Span(label);
            this.label.addClassNames(Accessibility.SCREEN_READER_ONLY);
            getElement().appendChild(this.label.getElement());
        } else {
            this.label.setText(label);
        }
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

    public void setShowSubItemsOnFocus(boolean showSubItemsOnFocus) {
        if (showSubItemsOnFocus) {
            Element element = getElement();
            this.focus = element.addEventListener("focus", e -> setExpanded(true));
            this.blur = element.addEventListener("focusout", e ->
                    element.executeJs("return this.contains(this.getRootNode().activeElement)")
                            .then(result -> {
                                if (!result.asBoolean()) setExpanded(false);
                            })
            );
        } else {
            if (this.focus != null) this.focus.remove();
            if (this.blur != null) this.blur.remove();
        }
    }

}
