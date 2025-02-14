package com.example.application.component;

import com.example.application.utility.Font;
import com.example.application.utility.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class Highlight extends Layout {

    // Components
    private final Layout prefix;
    private final Component value;
    private final Layout details;
    private final Layout suffix;
    // Style
    private Font.Size valueFontSize;
    private Component heading;

    public Highlight(String heading, String value) {
        this(null, heading, value, null);
    }

    public Highlight(Component prefix, String heading, String value) {
        this(prefix, heading, value, null);
    }

    public Highlight(String heading, String value, Component suffix) {
        this(null, heading, value, suffix);
    }

    public Highlight(Component prefix, String heading, String value, Component suffix) {
        addClassNames(Background.BASE, Padding.Horizontal.MEDIUM, Padding.Vertical.SMALL);
        setAlignItems(Layout.AlignItems.CENTER);
        setGap(Layout.Gap.MEDIUM);
        setPosition(Position.RELATIVE);

        this.prefix = new Layout();
        setPrefix(prefix);

        this.heading = new H3(heading);
        this.heading.addClassNames(FontSize.SMALL, FontWeight.NORMAL, TextColor.SECONDARY);

        this.value = new Span(value);
        this.value.addClassNames(FontWeight.MEDIUM);
        setValueFontSize(Font.Size.XLARGE);

        this.details = new Layout();
        this.details.setFlexWrap(FlexWrap.WRAP);
        this.details.setGap(Layout.Gap.SMALL);
        setDetails(null);

        Layout column = new Layout(this.heading, this.value, this.details);
        column.addClassNames(Padding.Vertical.XSMALL);
        column.setFlexDirection(Layout.FlexDirection.COLUMN);
        column.setFlexGrow();

        this.suffix = new Layout();
        setSuffix(suffix);

        add(this.prefix, column, this.suffix);
    }

    /**
     * Sets the prefix.
     */
    public void setPrefix(Component... components) {
        set(this.prefix, components);
    }

    /**
     * Sets the label.
     */
    public void setHeading(String heading) {
        this.heading.getElement().setText(heading);
    }

    public void setHeadingLevel(HeadingLevel level) {
        Component heading = level.getComponent(this.heading.getElement().getText());
        if (this.heading != null) {
            replace(this.heading, heading);
        }
        this.heading = heading;
        this.heading.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
    }

    /**
     * Sets the value.
     */
    public void setValue(String value) {
        this.value.getElement().setText(value);
    }

    /**
     * Sets the value's font size.
     */
    public void setValueFontSize(Font.Size fontSize) {
        if (this.valueFontSize != null) {
            this.value.removeClassName(this.valueFontSize.getClassName());
        }
        this.value.addClassNames(fontSize.getClassName());
        this.valueFontSize = fontSize;
    }

    /**
     * Sets the details.
     */
    public void setDetails(Component... components) {
        set(this.details, components);
    }

    /**
     * Sets the suffix.
     */
    public void setSuffix(Component... components) {
        set(this.suffix, components);
    }

    private void set(Layout layout, Component... components) {
        layout.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    layout.add(component);
                }
            }
        }
        layout.setVisible(layout.getComponentCount() > 0);
    }

}
