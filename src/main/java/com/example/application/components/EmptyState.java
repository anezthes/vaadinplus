package com.example.application.components;

import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class EmptyState extends Layout {

    private Component icon;
    private Component heading;
    private Paragraph description;
    private Button button;

    public EmptyState(String title, String description, String cta) {
        this(title, HeadingLevel.H2, description, cta);
    }

    public EmptyState(String title, HeadingLevel level, String description, String cta) {
        addClassNames(LumoUtility.Padding.XLARGE);
        setAlignItems(Alignment.CENTER);
        setFlexDirection(FlexDirection.COLUMN);
        setJustifyContentMode(JustifyContentMode.CENTER);

        setHeading(title, level);

        this.description = new Paragraph(description);
        this.description.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY, LumoUtility.Margin.Bottom.NONE);

        this.button = new Button(cta, VaadinIcon.PLUS.create());
        this.button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.button.addClassName(LumoUtility.Margin.Top.LARGE);

        add(this.heading, this.description, this.button);
    }

    public void setHeading(String title, HeadingLevel level) {
        Component heading;
        switch (level) {
            case H1:
                heading = new H1(title);
                break;
            case H2:
            default:
                heading = new H2(title);
                break;
            case H3:
                heading = new H3(title);
                break;
            case H4:
                heading = new H4(title);
                break;
            case H5:
                heading = new H5(title);
                break;
            case H6:
                heading = new H6(title);
                break;
        }
        if (this.heading != null) {
            replace(this.heading, heading);
        }
        this.heading = heading;
        this.heading.addClassNames(LumoUtility.FontSize.LARGE);
    }

    public void setIcon(Component icon) {
        if (this.icon != null) {
            replace(this.icon, icon);
        } else {
            icon.addClassNames(LumoUtility.Margin.Bottom.MEDIUM, LumoUtility.TextColor.SECONDARY);
            ((HasSize) icon).setHeight("var(--lumo-size-l)");
            ((HasSize) icon).setWidth("var(--lumo-size-l)");
            addComponentAsFirst(icon);
        }
        this.icon = icon;
    }

}
