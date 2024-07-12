package com.example.application.views.components;

import com.example.application.components.Layout;
import com.example.application.themes.RadioButtonTheme;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("Radio buttons")
@Route(value = "radio-buttons", layout = MainLayout.class)
public class RadioButtonsView extends ComponentView {

    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
            "tempor.";

    public RadioButtonsView() {
        addH2("Descriptions");
        add(createRadioButtonGroupWithDescriptions());

        addH2("Theme: dividers");
        add(createRadioButtonGroup(RadioButtonTheme.DIVIDERS));

        addH2("Theme: dividers & align-right");
        add(createRadioButtonGroup(RadioButtonTheme.DIVIDERS, RadioButtonTheme.ALIGN_RIGHT));

        addH2("Theme: border");
        add(createRadioButtonGroup(RadioButtonTheme.BORDER));

        addH2("Theme: toggle");
        add(createRadioButtonGroup(RadioButtonTheme.TOGGLE));

        addH2("Theme: toggle & tertiary");
        add(createRadioButtonGroup(RadioButtonTheme.TOGGLE, RadioButtonTheme.TERTIARY));

        addH2("Theme: toggle & primary");
        add(createRadioButtonGroup(RadioButtonTheme.TOGGLE, RadioButtonTheme.PRIMARY));

        addH2("Theme: segmented");
        RadioButtonGroup<String> radioButtonGroup = createRadioButtonGroup(RadioButtonTheme.SEGMENTED);
        radioButtonGroup.removeThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        add(radioButtonGroup);
    }

    private RadioButtonGroup<String> createRadioButtonGroupWithDescriptions() {
        RadioButtonGroup<String> group = createRadioButtonGroup();
        group.setRenderer(new ComponentRenderer<>(item -> renderLabelWithDescription(item)));
        return group;
    }

    private Component renderLabelWithDescription(String item) {
        Span primary = new Span(item);

        Span secondary = new Span(LOREM_IPSUM);
        secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Layout layout = new Layout(primary, secondary);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    private RadioButtonGroup<String> createRadioButtonGroup(String... themeNames) {
        RadioButtonGroup<String> group = new RadioButtonGroup("Label");
        group.addThemeNames(themeNames);
        group.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        group.setItems("Item 1", "Item 2", "Item 3");
        group.setWidth(320, Unit.PIXELS);

        group.getChildren().forEach(component -> {
            for (String themeName : themeNames) {
                component.getElement().getThemeList().add(themeName);
            }
        });

        return group;
    }

}
