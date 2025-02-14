package com.example.application.component;

import com.example.application.utility.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class EmptyState extends Layout {

    private Component icon;
    private Component heading;

    public EmptyState(String title, String description, String cta) {
        this(title, HeadingLevel.H2, description, cta);
    }

    public EmptyState(String title, HeadingLevel level, String description, String cta) {
        addClassNames(Padding.XLARGE);
        setAlignItems(AlignItems.CENTER);
        setFlexDirection(FlexDirection.COLUMN);
        setJustifyContent(JustifyContent.CENTER);

        setHeading(title, level);

        Paragraph paragraph = new Paragraph(description);
        paragraph.addClassNames(FontSize.SMALL, TextColor.SECONDARY, Margin.Bottom.NONE);

        Button button = new Button(cta, LineAwesomeIcon.PLUS_SOLID.create());
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClassName(Margin.Top.LARGE);

        add(this.heading, paragraph, button);
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
