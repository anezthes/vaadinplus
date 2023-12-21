package com.example.application.components;

import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Breadcrumb extends Nav {

    private OrderedList list;

    public Breadcrumb() {
        addClassName("breadcrumb");
        setAriaLabel("Breadcrumb");

        this.list = new OrderedList();
        this.list.addClassNames(
                LumoUtility.Display.FLEX, LumoUtility.FontSize.SMALL, LumoUtility.ListStyleType.NONE,
                LumoUtility.Margin.NONE, LumoUtility.Padding.NONE
        );
        super.add(this.list);
    }

    public Breadcrumb(BreadcrumbItem... items) {
        this();
        this.list.add(items);
    }

    public void add(BreadcrumbItem... items) {
        this.list.add(items);
    }

    public void remove(BreadcrumbItem... items) {
        this.list.remove(items);
    }

}
