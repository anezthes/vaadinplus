package com.example.application.components;

import com.example.application.utilities.Font;
import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class Highlight extends Layout {

    // Style
    private Font.Size valueFontSize;

    // Components
    private Layout prefix;
    private Layout column;
    private Component heading;
    private Component value;
    private Layout details;
    private Layout suffix;

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

        this.column = new Layout(this.heading, this.value, this.details);
        this.column.addClassNames(Padding.Vertical.XSMALL);
        this.column.setFlexDirection(Layout.FlexDirection.COLUMN);
        this.column.setFlexGrow();

        this.suffix = new Layout();
        setSuffix(suffix);

        add(this.prefix, this.column, this.suffix);
    }

    /**
     * Sets the prefix.
     */
    public void setPrefix(Component... components) {
        this.prefix.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.prefix.add(component);
                }
            }
        }
        this.prefix.setVisible(this.prefix.getComponentCount() > 0);
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
        this.details.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.details.add(component);
                }
            }
        }
        this.details.setVisible(this.details.getComponentCount() > 0);
    }

    /**
     * Sets the suffix.
     */
    public void setSuffix(Component... components) {
        this.suffix.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.suffix.add(component);
                }
            }
        }
        this.suffix.setVisible(this.suffix.getComponentCount() > 0);
    }

}
