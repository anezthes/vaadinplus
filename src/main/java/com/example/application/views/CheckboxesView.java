package com.example.application.views;

import com.example.application.themes.CheckboxTheme;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.stream.Collectors;

@PageTitle("Checkboxes")
@Route(value = "checkboxes", layout = MainLayout.class)
public class CheckboxesView extends View {

    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
            "tempor.";

    public CheckboxesView() {
        addH2("Descriptions");
        add(createCheckboxGroupWithDescriptions());

        addH2("Theme: Dividers");
        add(createCheckboxGroup(CheckboxTheme.DIVIDERS));

        addH2("Theme: Dividers & Align-Right");
        add(createCheckboxGroup(CheckboxTheme.DIVIDERS, CheckboxTheme.ALIGN_RIGHT));

        addH2("Theme: Switch");
        add(createCheckboxGroup(CheckboxTheme.SWITCH));
    }

    private CheckboxGroup<String> createCheckboxGroupWithDescriptions() {
        CheckboxGroup<String> group = createCheckboxGroup();
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

    private CheckboxGroup<String> createCheckboxGroup(String... themeNames) {
        CheckboxGroup<String> group = new CheckboxGroup("Label");
        group.addThemeNames(themeNames);
        group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
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
