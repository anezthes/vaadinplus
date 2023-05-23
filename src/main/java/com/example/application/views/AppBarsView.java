package com.example.application.views;

import com.example.application.components.AppBar;
import com.example.application.components.appnav.AppNav;
import com.example.application.components.appnav.AppNavItem;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("App Bars")
@Route(value = "app-bars", layout = MainLayout.class)
public class AppBarsView extends View {

    public AppBarsView() {
        addH2("Lorem ipsum");
        add(createAppBar());
    }

    private AppBar createAppBar() {
        AppNav nav = new AppNav();
        nav.addItem(new AppNavItem("App Bars", AppBarsView.class, LineAwesomeIcon.BARS_SOLID.create()));
        nav.addItem(new AppNavItem("Checkboxes", CheckboxesView.class, LineAwesomeIcon.CHECK_SQUARE.create()));
        nav.addItem(new AppNavItem("Empty States", EmptyStatesView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new AppNavItem("Headers", HeadersView.class, LineAwesomeIcon.HEADING_SOLID.create()));
        nav.getChildren().forEach(navItem -> navItem.addClassNames(LumoUtility.Display.INLINE_BLOCK));

        Component icon = LineAwesomeIcon.FEATHER_ALT_SOLID.create();
        icon.addClassNames(LumoUtility.TextColor.PRIMARY);
        ((HasSize) icon).setHeight("var(--lumo-size-l)");
        ((HasSize) icon).setWidth("var(--lumo-size-l)");

        Button notifications = new Button(VaadinIcon.BELL.create());
        notifications.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        notifications.getElement().setAttribute("aria-label", "Notifications");

        Avatar avatar = new Avatar("John Smith");
        avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

        AppBar appBar = new AppBar();
        appBar.addToStart(icon, nav);
        appBar.addToEnd(notifications, avatar);
        return appBar;
    }

}
