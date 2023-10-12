package com.example.application.components;

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
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class UserMenu extends NativeDialog {

    private String theme = "";
    private String density = "";

    public UserMenu() {
        setAriaLabel("User menu");
        setWidth(16, Unit.REM);

        // Position
        setRight(0.5f, Unit.REM);
        setTop(3.5f, Unit.REM);

        // Links
        UnorderedList list = new UnorderedList(
                createListItem("Manage account", LineAwesomeIcon.USER_CIRCLE, ProfileView.class),
                createListItem("Sign out", LineAwesomeIcon.SIGN_OUT_ALT_SOLID, ProfileView.class)
        );
        list.addClassNames(LumoUtility.ListStyleType.NONE, LumoUtility.Margin.NONE, LumoUtility.Padding.Horizontal.NONE,
                LumoUtility.Padding.Vertical.XSMALL);

        // Theme
        RadioButtonGroup<String> theme = new RadioButtonGroup<>();
        theme.addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.Padding.SMALL);
        theme.addThemeNames(RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.PRIMARY, RadioButtonTheme.TOGGLE);
        theme.addValueChangeListener(e -> setTheme(e.getValue().equals(Lumo.DARK)));

        theme.setAriaLabel("Appearance");
        theme.setItems(Lumo.DARK, Lumo.LIGHT);
        theme.setRenderer(new ComponentRenderer<>(item -> renderTheme(item)));
        theme.setValue(Lumo.LIGHT);
        theme.setWidthFull();

        theme.getChildren().forEach(component -> {
            component.getElement().getThemeList().add(RadioButtonTheme.PRIMARY);
            component.getElement().getThemeList().add(RadioButtonTheme.TOGGLE);
        });

        // Density
        RadioButtonGroup<String> density = new RadioButtonGroup<>();
        density.addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.Padding.SMALL);
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

        add(list, new Hr(), theme, density);
    }

    private ListItem createListItem(String text, LineAwesomeIcon icon, Class<? extends Component> navigationTarget) {
        Item item = new Item(text, icon);
        item.addClassNames(LumoUtility.LineHeight.XSMALL, LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.Padding.Vertical.SMALL);

        RouterLink link = new RouterLink(navigationTarget);
        link.addClassNames(LumoUtility.TextColor.BODY, "no-underline");
        link.add(item);

        return new ListItem(link);
    }

    private Component renderTheme(String theme) {
        String text = theme.substring(0, 1).toUpperCase() + theme.substring(1);
        LineAwesomeIcon icon = theme.equals(Lumo.DARK) ? LineAwesomeIcon.MOON : LineAwesomeIcon.SUN;

        Item item = new Item(text, icon);
        item.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
        return item;
    }

    private void setTheme(boolean dark) {
        this.theme = dark ? Lumo.DARK : Lumo.LIGHT;
        updateTheme();
    }

    private Component renderDensity(String density) {
        LineAwesomeIcon icon = density.equals("Default") ? LineAwesomeIcon.EXPAND_SOLID : LineAwesomeIcon.COMPRESS_SOLID;

        Item item = new Item(density, icon);
        item.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
        return item;
    }

    private void setDensity(boolean compact) {
        this.density = compact ? "compact" : "";
        updateTheme();
    }

    private void updateTheme() {
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, this.theme + " " + this.density);
    }

}
