package com.example.application.views.components;

import com.example.application.components.AppBar;
import com.example.application.components.TopNav;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("App bars")
@Route(value = "app-bars", layout = MainLayout.class)
public class AppBarsView extends ComponentView {

    public AppBarsView() {
        addClassNames(Padding.Top.LARGE);
        add(new Paragraph("No official support for horizontal navigation. Yet."));

        addH2("Simple");
        addPreview(createAppBar());

        addH2("Primary button");
        addPreview(createAppBarWithPrimaryButton());

        addH2("Search");
        addPreview(createAppBarWithSearch());

        addH2("Search II");
        addPreview(createAppBarWithSearchAlt());
    }

    private AppBar createAppBar() {
        AppBar appBar = new AppBar();
        appBar.addToStart(createIcon(), createAppNav());
        appBar.addToEnd(createButton(), createAvatar());
        return appBar;
    }

    private AppBar createAppBarWithPrimaryButton() {
        Button button = new Button("New event", LineAwesomeIcon.PLUS_SOLID.create());
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        AppBar appBar = createAppBar();
        appBar.addToEnd(0, button);
        return appBar;
    }

    private AppBar createAppBarWithSearch() {
        AppBar appBar = createAppBar();
        appBar.addToEnd(0, createTextField());
        return appBar;
    }

    private AppBar createAppBarWithSearchAlt() {
        TextField textField = createTextField();
        textField.addClassNames(Flex.GROW);
        textField.setMaxWidth(420, Unit.PIXELS);

        AppBar appBar = new AppBar();
        appBar.addToStart(createIcon());
        appBar.addToMiddle(textField);
        appBar.addToEnd(createButton(), createAvatar());
        return appBar;
    }

    private Component createIcon() {
        SvgIcon icon = LineAwesomeIcon.FEATHER_ALT_SOLID.create();
        icon.addClassNames(IconSize.MEDIUM, TextColor.PRIMARY);
        return icon;
    }

    private SideNav createAppNav() {
        TopNav nav = new TopNav();
        nav.addClassNames(Overflow.AUTO);
        nav.addItem(new SideNavItem("App Bars", AppBarsView.class, LineAwesomeIcon.BARS_SOLID.create()));
        nav.addItem(new SideNavItem("Checkboxes", CheckboxesView.class, LineAwesomeIcon.CHECK_SQUARE.create()));
        nav.addItem(new SideNavItem("Empty States", EmptyStatesView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("Headers", HeadersView.class, LineAwesomeIcon.HEADING_SOLID.create()));
        return nav;
    }

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.setAriaLabel("Search");
        textField.setPlaceholder("Search");
        textField.setPrefixComponent(LumoIcon.SEARCH.create());
        return textField;
    }

    private Button createButton() {
        Button button = new Button(LumoIcon.BELL.create());
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        button.setAriaLabel("Notifications");
        return button;
    }

    private Avatar createAvatar() {
        Avatar avatar = new Avatar("Emily Johnson");
        avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");
        return avatar;
    }

}
