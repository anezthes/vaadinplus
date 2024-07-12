package com.example.application.views.components;

import com.example.application.components.Preview;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ComponentView extends Main {

    public ComponentView() {
        addClassNames(Display.FLEX, FlexDirection.COLUMN, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);
    }

    public void addH2(String text) {
        H2 h2 = new H2(text);
        h2.addClassNames(FontSize.LARGE, Margin.Bottom.MEDIUM, Margin.Top.LARGE);
        add(h2);
    }

    public void addPreview(Component... components) {
        add(new Preview(components));
    }

}
