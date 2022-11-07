package com.example.application.views;

import com.example.application.themes.RadioButtonTheme;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.stream.Collectors;

@PageTitle("Radio Buttons")
@Route(value = "radio-buttons", layout = MainLayout.class)
public class RadioButtonsView extends Main {

	public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
			"tempor.";

	public RadioButtonsView() {
		addClassNames(
				LumoUtility.AlignItems.START, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
				LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE
		);

		add(new H2("Descriptions"));
		add(createRadioButtonGroupWithDescriptions());

		add(new H2("Theme: Dividers"));
		add(createRadioButtonGroup(RadioButtonTheme.DIVIDERS));

		add(new H2("Theme: Dividers & Align-Right"));
		add(createRadioButtonGroup(RadioButtonTheme.DIVIDERS, RadioButtonTheme.ALIGN_RIGHT));

		add(new H2("Theme: Border"));
		add(createRadioButtonGroup(RadioButtonTheme.BORDER));

		add(new H2("Theme: Border-Only"));
		add(createRadioButtonGroup(RadioButtonTheme.BORDER_ONLY));

		add(new H2("Theme: Border-Only & Primary"));
		add(createRadioButtonGroup(RadioButtonTheme.BORDER_ONLY, RadioButtonTheme.PRIMARY));
	}

	private RadioButtonGroup<String> createRadioButtonGroupWithDescriptions() {
		RadioButtonGroup<String> group = createRadioButtonGroup();
		group.setRenderer(new ComponentRenderer<>(item -> renderLabelWithDescription(item)));
		return group;
	}

	private Component renderLabelWithDescription(String item) {
		Span primary = new Span(item);

		Span secondary = new Span(LOREM_IPSUM);
		secondary.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

		FlexLayout layout = new FlexLayout(primary, secondary);
		layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
		return layout;
	}

	private RadioButtonGroup<String> createRadioButtonGroup(String... themeNames) {
		RadioButtonGroup<String> group = new RadioButtonGroup("Label");
		group.addThemeNames(themeNames);
		group.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		group.setItems("Item 1", "Item 2", "Item 3");
		group.setWidth(320, Unit.PIXELS);

		for (Component component : group.getChildren().collect(Collectors.toList())) {
			for (String themeName : themeNames) {
				component.getElement().getThemeList().add(themeName);
			}
		}

		return group;
	}

}
