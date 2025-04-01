package com.example.application.view.component;

import com.example.application.component.AppBar;
import com.example.application.component.MaterialSymbol;
import com.example.application.component.TopNav;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;


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
        Button button = new Button("New event", MaterialSymbol.ADD.create());
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
        return MaterialSymbol.PETS.create(AlignItems.CENTER, Display.FLEX, IconSize.MEDIUM, JustifyContent.CENTER,
                TextColor.PRIMARY);
    }

    private SideNav createAppNav() {
        TopNav nav = new TopNav();
        nav.addClassNames(Overflow.AUTO);
        nav.addItem(new SideNavItem("App Bars", AppBarsView.class, MaterialSymbol.TOOLBAR.create()));
        nav.addItem(new SideNavItem("Checkboxes", CheckboxesView.class, MaterialSymbol.CHECK_BOX.create()));
        nav.addItem(new SideNavItem("Empty States", EmptyStatesView.class, MaterialSymbol.DOCUMENT_SEARCH.create()));
        nav.addItem(new SideNavItem("Headers", HeadersView.class, MaterialSymbol.TITLE.create()));
        return nav;
    }

    private TextField createTextField() {
        TextField textField = new TextField();
        textField.setAriaLabel("Search");
        textField.setPlaceholder("Search");
        textField.setPrefixComponent(MaterialSymbol.SEARCH.create());
        return textField;
    }

    private Button createButton() {
        Button button = new Button(MaterialSymbol.NOTIFICATIONS.create());
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        button.setAriaLabel("Notifications");
        button.setTooltipText("Notifications");
        return button;
    }

    private Avatar createAvatar() {
        Avatar avatar = new Avatar("Emily Johnson");
        avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");
        return avatar;
    }

}
