package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class BreadcrumbItem extends ListItem implements AfterNavigationObserver {

    private RouterLink link;

    public BreadcrumbItem(String text, Class<? extends Component> navigationTarget) {
        addClassNames(LumoUtility.Display.FLEX);

        this.link = new RouterLink(text, navigationTarget);
        add(this.link);
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
