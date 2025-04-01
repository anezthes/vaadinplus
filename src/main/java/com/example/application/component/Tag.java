package com.example.application.component;

import com.example.application.utility.Color;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.theme.lumo.LumoUtility.*;


public class Tag extends Span {

    private final Layout prefix;
    private Color.Text color;

    public Tag(Component prefix, String text, Color.Text color) {
        addClassNames(AlignItems.CENTER, Display.FLEX, FontSize.SMALL, Gap.SMALL);
        setTextColor(color);

        this.prefix = new Layout();
        this.prefix.setVisible(false);
        setPrefix(prefix);

        add(this.prefix, new Text(text));
    }

    public Tag(Component prefix, String text) {
        this(prefix, text, Color.Text.SECONDARY);
    }

    public Tag(MaterialSymbol symbol, String text, Color.Text color) {
        this(createIcon(symbol), text, color);
    }

    public Tag(MaterialSymbol symbol, String text) {
        this(symbol, text, Color.Text.SECONDARY);
    }

    public Tag(String text) {
        this((Component) null, text, Color.Text.SECONDARY);
    }

    private static Component createIcon(MaterialSymbol symbol) {
        return symbol.create(IconSize.SMALL);
    }

    /**
     * Sets the prefix.
     */
    public void setPrefix(Component... components) {
        this.prefix.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    if (component instanceof Icon) {
                        component.addClassNames(IconSize.SMALL);
                    }
                    if (component instanceof Avatar) {
                        ((Avatar) component).addThemeVariants(AvatarVariant.LUMO_XSMALL);
                    }
                    this.prefix.add(component);
                }
            }
        }
        this.prefix.setVisible(this.prefix.getComponentCount() > 0);
    }

    /**
     * Sets the text color.
     */
    public void setTextColor(Color.Text color) {
        if (this.color != null) {
            removeClassNames(this.color.getClassName());
        }
        addClassNames(color.getClassName());
        this.color = color;
    }

}
