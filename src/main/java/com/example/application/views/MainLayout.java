package com.example.application.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        Span appName = new Span("Vaadin+");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.FontWeight.SEMIBOLD);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(new Header(appName), scroller);
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("App Bars", AppBarsView.class, LineAwesomeIcon.BARS_SOLID.create()));
        nav.addItem(new SideNavItem("Checkboxes", CheckboxesView.class, LineAwesomeIcon.CHECK_SQUARE.create()));
        nav.addItem(new SideNavItem("Empty States", EmptyStatesView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("Headers", HeadersView.class, LineAwesomeIcon.HEADING_SOLID.create()));
        nav.addItem(new SideNavItem("Highlights", HighlightsView.class, LineAwesomeIcon.CHART_LINE_SOLID.create()));
        nav.addItem(new SideNavItem("Input Groups", InputGroupsView.class, LineAwesomeIcon.KEYBOARD.create()));
        nav.addItem(new SideNavItem("Key-Value Pairs", KeyValuePairsView.class, LineAwesomeIcon.KEY_SOLID.create()));
        nav.addItem(new SideNavItem("Lists", ListsView.class, LineAwesomeIcon.LIST_SOLID.create()));
        nav.addItem(new SideNavItem("Notifications", NotificationsView.class, LineAwesomeIcon.BELL.create()));
        nav.addItem(new SideNavItem("Radio Buttons", RadioButtonsView.class, LineAwesomeIcon.CHECK_CIRCLE_SOLID.create()));
        nav.addItem(new SideNavItem("Steppers", SteppersView.class, LineAwesomeIcon.STEP_FORWARD_SOLID.create()));
        return nav;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }

}
