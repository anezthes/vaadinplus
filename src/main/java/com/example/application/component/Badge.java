package com.example.application.component;

import com.example.application.utility.BadgeVariant;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.IconSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

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

    public void setIcon(MaterialSymbol symbol) {
        if (this.icon != null) {
            remove(this.icon);
        }
        this.icon = symbol.create(IconSize.SMALL, Margin.End.XSMALL, Margin.Minus.Start.XSMALL,
                Margin.Minus.Vertical.XSMALL);
        addComponentAsFirst(this.icon);
    }

    public void addThemeVariants(BadgeVariant... variants) {
        getThemeNames().addAll(Stream.of(variants).map(BadgeVariant::getVariantName).toList());
    }
}
