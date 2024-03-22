package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;

public class BreadcrumbItem extends ListItem implements AfterNavigationObserver {

    private RouterLink link;

    public BreadcrumbItem(RouterLink link) {
        addClassNames(Display.FLEX);

        this.link = link;
        add(this.link);
    }

    public BreadcrumbItem(String text, Class<? extends Component> navigationTarget) {
        this(new RouterLink(text, navigationTarget));
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (this.link.getHref().equals(event.getLocation().getFirstSegment())) {
            this.link.getElement().setAttribute("aria-current", "page");
        } else {
            this.link.getElement().removeAttribute("aria-current");
        }
    }
}
