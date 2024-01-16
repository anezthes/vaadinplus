package com.example.application.components;

import com.example.application.utilities.BadgeVariant;
import com.example.application.utilities.IconSize;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Badge extends Span implements HasTheme {

    private Component icon;

    public Badge() {
        addThemeName("badge");
    }

    public Badge(String text) {
        this();
        add(new Span(text));
    }

    public Badge(String text, BadgeVariant... variants) {
        this(text);
        addThemeVariants(variants);
    }

    public void setIcon(LineAwesomeIcon icon) {
        if (this.icon != null) {
            remove(this.icon);
        }
        this.icon = icon.create();
        this.icon.getStyle().set("--_size", IconSize.SMALL);
        this.icon.addClassNames(LumoUtility.Margin.End.XSMALL, "-my-xs");
        addComponentAsFirst(this.icon);
    }

    public void addThemeVariants(BadgeVariant... variants) {
        getThemeNames().addAll(Stream.of(variants).map(BadgeVariant::getVariantName).collect(Collectors.toList()));
    }
}
