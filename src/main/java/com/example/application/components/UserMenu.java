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

        // Appearance
        RadioButtonGroup<String> appearance = new RadioButtonGroup<>();
        appearance.addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.Padding.Bottom.SMALL,
                LumoUtility.Padding.Horizontal.SMALL);
        appearance.addThemeNames(RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.PRIMARY, RadioButtonTheme.TOGGLE);
        appearance.addValueChangeListener(e -> setTheme(e.getValue().equals(Lumo.DARK)));

        appearance.setAriaLabel("Appearance");
        appearance.setItems(Lumo.DARK, Lumo.LIGHT);
        appearance.setRenderer(new ComponentRenderer<>(theme -> renderTheme(theme)));
        appearance.setValue(Lumo.LIGHT);
        appearance.setWidthFull();

        appearance.getChildren().forEach(component -> {
            component.getElement().getThemeList().add(RadioButtonTheme.PRIMARY);
            component.getElement().getThemeList().add(RadioButtonTheme.TOGGLE);
        });

        add(list, new Hr(), appearance);
    }

    private Component renderTheme(String theme) {
        String text = theme.substring(0, 1).toUpperCase() + theme.substring(1);
        LineAwesomeIcon icon = theme.equals(Lumo.DARK) ? LineAwesomeIcon.MOON : LineAwesomeIcon.SUN;

        Item item = new Item(text, icon);
        item.addClassNames(LumoUtility.Margin.Horizontal.AUTO);
        return item;
    }

    private void setTheme(boolean dark) {
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, dark ? Lumo.DARK : Lumo.LIGHT);
    }

    private ListItem createListItem(String text, LineAwesomeIcon icon, Class<? extends Component> navigationTarget) {
        Item item = new Item(text, icon);
        item.addClassNames(LumoUtility.LineHeight.XSMALL, LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.Padding.Vertical.SMALL);

        RouterLink link = new RouterLink(navigationTarget);
        link.add(item);

        return new ListItem(link);
    }

}
