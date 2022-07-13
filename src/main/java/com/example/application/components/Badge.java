package com.example.application.components;

import com.example.application.utilities.BadgeVariant;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Span;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Badge extends Span implements HasTheme {

	public Badge(String text) {
		super(text);
		addThemeName("badge");
	}

	public Badge(String text, BadgeVariant... variants) {
		this(text);
		addThemeVariants(variants);
	}

	public void addThemeVariants(BadgeVariant... variants) {
		getThemeNames().addAll(Stream.of(variants).map(BadgeVariant::getVariantName).collect(Collectors.toList()));
	}
}
