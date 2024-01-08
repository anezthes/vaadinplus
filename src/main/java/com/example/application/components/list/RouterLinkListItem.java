package com.example.application.components.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class RouterLinkListItem extends ListItem {

    protected RouterLink link;

    public RouterLinkListItem() {
        // Remove the class names added by ListItem
        getClassNames().clear();

        // Move the content and class names to the link
        this.link = new RouterLink();
        this.link.add(this.prefix, this.column, this.suffix);
        this.link.addClassNames(AlignItems.CENTER, Background.BASE, "hover:bg-contrast-5", Display.FLEX, Gap.MEDIUM,
                Padding.Horizontal.MEDIUM, Padding.Vertical.SMALL, Position.RELATIVE, TextColor.BODY, "no-underline");
        add(this.link);
    }

    public void setRoute(Class<? extends Component> navigationTarget) {
        this.link.setRoute(navigationTarget);
    }

}
