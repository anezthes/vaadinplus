package com.example.application.components;

import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class EmptyState extends Layout {

    private Component icon;
    private Component heading;
    private Paragraph description;
    private Button button;

    public EmptyState(String title, String description, String cta) {
        this(title, HeadingLevel.H2, description, cta);
    }

    public EmptyState(String title, HeadingLevel level, String description, String cta) {
        addClassNames(Padding.XLARGE);
        setAlignItems(AlignItems.CENTER);
        setFlexDirection(FlexDirection.COLUMN);
        setJustifyContent(JustifyContent.CENTER);

        setHeading(title, level);

        this.description = new Paragraph(description);
        this.description.addClassNames(FontSize.SMALL, TextColor.SECONDARY, Margin.Bottom.NONE);

        this.button = new Button(cta, LineAwesomeIcon.PLUS_SOLID.create());
        this.button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.button.addClassName(Margin.Top.LARGE);

        add(this.heading, this.description, this.button);
    }

    public void setHeading(String title, HeadingLevel level) {
        Component heading = level.getComponent(title);
        if (this.heading != null) {
            replace(this.heading, heading);
        }
        this.heading = heading;
        this.heading.addClassNames(FontSize.LARGE);
    }

    public void setIcon(Component icon) {
        if (this.icon != null) {
            replace(this.icon, icon);
        } else {
            icon.addClassNames(IconSize.LARGE, Margin.Bottom.MEDIUM, TextColor.SECONDARY);
            addComponentAsFirst(icon);
        }
        this.icon = icon;
    }

}
