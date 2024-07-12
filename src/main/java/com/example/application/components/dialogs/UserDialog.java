package com.example.application.components.dialogs;

import com.example.application.components.Item;
import com.example.application.themes.RadioButtonTheme;
import com.example.application.views.templates.ProfileView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class UserDialog extends NativeDialog {

    private String colorScheme = "";
    private String density = "";
    private String theme = "";

    public UserDialog() {
        setAriaLabel("User menu");
        setWidth(16, Unit.REM);

        // TODO: Mobile positioning
        // Position
        setRight(0.5f, Unit.REM);
        setTop(3.5f, Unit.REM);

        // Links
        UnorderedList list = new UnorderedList(
                createListItem("Manage account", LineAwesomeIcon.USER_CIRCLE, ProfileView.class),
                createListItem("Sign out", LineAwesomeIcon.SIGN_OUT_ALT_SOLID, ProfileView.class)
        );
        list.addClassNames(ListStyleType.NONE, Margin.Vertical.NONE, Padding.XSMALL);

        // Divider
        Hr hr = new Hr();
        hr.addClassNames(Margin.Vertical.XSMALL);

        // Theme
        RadioButtonGroup<String> colorScheme = new RadioButtonGroup<>();
        colorScheme.addClassNames(BoxSizing.BORDER, Padding.XSMALL);
        colorScheme.addThemeNames(RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.PRIMARY, RadioButtonTheme.TOGGLE);
        colorScheme.addValueChangeListener(e -> setColorScheme(e.getValue().equals(Lumo.DARK)));

        colorScheme.setAriaLabel("Color scheme");
        colorScheme.setItems(Lumo.LIGHT, Lumo.DARK);
        colorScheme.setRenderer(new ComponentRenderer<>(item -> renderColorScheme(item)));
        colorScheme.setValue(Lumo.LIGHT);
        colorScheme.setWidthFull();

        colorScheme.getChildren().forEach(component -> {
            component.getElement().getThemeList().add(RadioButtonTheme.PRIMARY);
            component.getElement().getThemeList().add(RadioButtonTheme.TOGGLE);
        });

        // Density
        RadioButtonGroup<String> density = new RadioButtonGroup<>();
        density.addClassNames(BoxSizing.BORDER, Padding.XSMALL);
        density.addThemeNames(RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.PRIMARY, RadioButtonTheme.TOGGLE);
        density.addValueChangeListener(e -> setDensity(e.getValue().equals("Compact")));

        density.setAriaLabel("Density");
        density.setItems("Default", "Compact");
        density.setRenderer(new ComponentRenderer<>(item -> renderDensity(item)));
        density.setValue("Default");
        density.setWidthFull();

        density.getChildren().forEach(component -> {
            component.getElement().getThemeList().add(RadioButtonTheme.PRIMARY);
            component.getElement().getThemeList().add(RadioButtonTheme.TOGGLE);
        });

        // Theme
        RadioButtonGroup<String> theme = new RadioButtonGroup<>();
        theme.addClassNames(BoxSizing.BORDER, Padding.XSMALL);
        theme.addThemeNames(RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.PRIMARY, RadioButtonTheme.TOGGLE);
        theme.addValueChangeListener(e -> setTheme(e.getValue().equals("Lumo")));

        theme.setAriaLabel("Theme");
        theme.setItems("Lumo", "StarPass");
        theme.setRenderer(new ComponentRenderer<>(item -> renderTheme(item)));
        theme.setValue("Lumo");
        theme.setWidthFull();

        theme.getChildren().forEach(component -> {
            component.getElement().getThemeList().add(RadioButtonTheme.PRIMARY);
            component.getElement().getThemeList().add(RadioButtonTheme.TOGGLE);
        });

        add(list, hr, colorScheme, density, theme);
    }

    private ListItem createListItem(String text, LineAwesomeIcon icon, Class<? extends Component> navigationTarget) {
        Item item = new Item(text, icon);
        item.addClassNames(BorderRadius.MEDIUM, LineHeight.XSMALL, Padding.SMALL, "hover:bg-contrast-5");

        RouterLink link = new RouterLink(navigationTarget);
        link.addClassNames(TextColor.BODY, "no-underline");
        link.add(item);

        return new ListItem(link);
    }

    private Component renderColorScheme(String theme) {
        String text = theme.substring(0, 1).toUpperCase() + theme.substring(1);
        LineAwesomeIcon icon = theme.equals(Lumo.DARK) ? LineAwesomeIcon.MOON : LineAwesomeIcon.SUN;

        Item item = new Item(text, icon);
        item.addClassNames(Margin.Horizontal.AUTO);
        return item;
    }

    private void setColorScheme(boolean dark) {
        this.colorScheme = dark ? Lumo.DARK : Lumo.LIGHT;
        updateTheme();
    }

    private Component renderDensity(String density) {
        LineAwesomeIcon icon = density.equals("Default") ? LineAwesomeIcon.EXPAND_SOLID : LineAwesomeIcon.COMPRESS_SOLID;

        Item item = new Item(density, icon);
        item.addClassNames(Margin.Horizontal.AUTO);
        return item;
    }

    private void setDensity(boolean compact) {
        this.density = compact ? "compact" : "";
        updateTheme();
    }

    private Component renderTheme(String theme) {
        LineAwesomeIcon icon = theme.equals("Lumo") ? LineAwesomeIcon.VAADIN : LineAwesomeIcon.ADJUST_SOLID;

        Item item = new Item(theme, icon);
        item.addClassNames(Margin.Horizontal.AUTO);
        return item;
    }

    private void setTheme(boolean lumo) {
        this.theme = lumo ? "" : "starpass";
        updateTheme();
    }

    private void updateTheme() {
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, this.colorScheme + " " + this.density + " " + this.theme);
    }

}
