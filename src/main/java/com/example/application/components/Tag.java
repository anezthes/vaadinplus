package com.example.application.components;

import com.example.application.utilities.Color;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class Tag extends Span {

    private Color.Text color;
    private Layout prefix;
    private Text text;

    public Tag(Component prefix, String text, Color.Text color) {
        addClassNames(AlignItems.CENTER, Display.FLEX, FontSize.SMALL, Gap.SMALL);
        setTextColor(color);

        this.prefix = new Layout();
        this.prefix.setVisible(false);
        setPrefix(prefix);

        this.text = new Text(text);

        add(this.prefix, this.text);
    }

    public Tag(Component prefix, String text) {
        this(prefix, text, Color.Text.SECONDARY);
    }

    public Tag(LineAwesomeIcon icon, String text, Color.Text color) {
        this(createIcon(icon), text, color);
    }

    public Tag(LineAwesomeIcon icon, String text) {
        this(icon, text, Color.Text.SECONDARY);
    }

    public Tag(String text) {
        this((Component) null, text, Color.Text.SECONDARY);
    }

    private static Component createIcon(LineAwesomeIcon icon) {
        SvgIcon i = icon.create();
        i.addClassNames(IconSize.SMALL);
        return i;
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
