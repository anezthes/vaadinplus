package com.example.application.views;


import com.example.application.components.appnav.AppNav;
import com.example.application.components.appnav.AppNavItem;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
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
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

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

    private AppNav createNavigation() {
        AppNav nav = new AppNav();
        nav.addItem(new AppNavItem("App Bars", AppBarsView.class, LineAwesomeIcon.BARS_SOLID.create()));
        nav.addItem(new AppNavItem("Checkboxes", CheckboxesView.class, LineAwesomeIcon.CHECK_SQUARE.create()));
        nav.addItem(new AppNavItem("Empty States", EmptyStatesView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new AppNavItem("Headers", HeadersView.class, LineAwesomeIcon.HEADING_SOLID.create()));
        nav.addItem(new AppNavItem("Highlights", HighlightsView.class, LineAwesomeIcon.CHART_LINE_SOLID.create()));
        nav.addItem(new AppNavItem("Input Groups", InputGroupsView.class, LineAwesomeIcon.KEYBOARD.create()));
        nav.addItem(new AppNavItem("Key-Value Pairs", KeyValuePairsView.class, LineAwesomeIcon.KEY_SOLID.create()));
        nav.addItem(new AppNavItem("Lists", ListsView.class, LineAwesomeIcon.LIST_SOLID.create()));
        nav.addItem(new AppNavItem("Notifications", NotificationsView.class, LineAwesomeIcon.BELL.create()));
        nav.addItem(new AppNavItem("Radio Buttons", RadioButtonsView.class, LineAwesomeIcon.CHECK_CIRCLE_SOLID.create()));
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
