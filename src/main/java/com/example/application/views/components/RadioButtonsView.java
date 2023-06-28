package com.example.application.views.components;

import com.example.application.themes.RadioButtonTheme;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
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
public class RadioButtonsView extends ComponentView {

    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
            "tempor.";

    public RadioButtonsView() {
        addH2("Descriptions");
        add(createRadioButtonGroupWithDescriptions());

        addH2("Theme: Dividers");
        add(createRadioButtonGroup(RadioButtonTheme.DIVIDERS));

        addH2("Theme: Dividers & Align-Right");
        add(createRadioButtonGroup(RadioButtonTheme.DIVIDERS, RadioButtonTheme.ALIGN_RIGHT));

        addH2("Theme: Border");
        add(createRadioButtonGroup(RadioButtonTheme.BORDER));

        addH2("Theme: Border & Gap");
        add(createRadioButtonGroup(RadioButtonTheme.BORDER, RadioButtonTheme.GAP));

        addH2("Theme: Border-Only");
        add(createRadioButtonGroup(RadioButtonTheme.BORDER_ONLY));

        addH2("Theme: Border-Only & Gap");
        add(createRadioButtonGroup(RadioButtonTheme.BORDER_ONLY, RadioButtonTheme.GAP));

        addH2("Theme: Border-Only & Primary");
        add(createRadioButtonGroup(RadioButtonTheme.BORDER_ONLY, RadioButtonTheme.PRIMARY));

        addH2("Theme: Border-Only, Gap & Primary");
        add(createRadioButtonGroup(RadioButtonTheme.BORDER_ONLY, RadioButtonTheme.GAP, RadioButtonTheme.PRIMARY));
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
