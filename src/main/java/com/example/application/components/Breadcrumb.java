package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Breadcrumb extends Nav {

    private UnorderedList list;

    public Breadcrumb() {
        addClassName("breadcrumb");
        setAriaLabel("Breadcrumb");

        this.list = new UnorderedList();
        this.list.addClassNames(
                LumoUtility.Display.FLEX, LumoUtility.FontSize.SMALL, LumoUtility.ListStyleType.NONE,
                LumoUtility.Margin.NONE, LumoUtility.Padding.NONE
        );
        super.add(this.list);
    }

    public Breadcrumb(RouterLink... links) {
        this();
        add(links);
    }

    public Breadcrumb(Anchor... anchors) {
        this();
        add(anchors);
    }

    @Override
    public void add(Component... components) {
        for (Component component : components) {
            ListItem listItem = new ListItem(component);
            listItem.addClassNames(LumoUtility.Display.FLEX);
            this.list.add(listItem);
        }
    }

    @Override
    public int getComponentCount() {
        return Math.toIntExact(this.list.getChildren().count());
    }

    @Override
    public void remove(Component... components) {
        this.list.remove(components);
    }

    @Override
    public void removeAll() {
        this.list.removeAll();
    }
}
