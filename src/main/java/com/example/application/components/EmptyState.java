package com.example.application.components;

import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class EmptyState extends Layout {

    private Component heading;
    private Paragraph description;

    public EmptyState(String title, String description) {
        this(title, HeadingLevel.H2, description);
    }

    public EmptyState(String title, HeadingLevel level, String description) {
        setFlexDirection(FlexDirection.COLUMN);

        setHeading(title, level);

        this.description = new Paragraph(description);
        this.description.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY, LumoUtility.Margin.NONE);

        add(this.heading, this.description);
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
    }

}
