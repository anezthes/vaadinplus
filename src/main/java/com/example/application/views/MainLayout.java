package com.example.application.views;

import com.example.application.components.Layout;
import com.example.application.components.UserMenu;
import com.example.application.utilities.Gap;
import com.example.application.views.components.*;
import com.example.application.views.templates.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
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

        UserMenu menu = new UserMenu();

        Avatar avatar = new Avatar("John Smith");
        avatar.addClassNames(LumoUtility.Margin.End.SMALL, LumoUtility.Margin.Start.AUTO);
        avatar.getElement().addEventListener("click", e -> menu.showModal());

        addToNavbar(true, toggle, viewTitle, avatar, menu);
    }

    private void addDrawerContent() {
        Span appName = new Span("Vaadin+");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.FontWeight.SEMIBOLD);

        Layout nav = new Layout(createComponentNavigation(), createTemplatesNavigation());
        nav.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        nav.setGap(Gap.MEDIUM);

        Scroller scroller = new Scroller(nav);

        addToDrawer(new Header(appName), scroller);
    }

    private SideNav createComponentNavigation() {
        SideNav nav = new SideNav("Components");
        nav.addItem(new SideNavItem("App bars", AppBarsView.class, LineAwesomeIcon.BARS_SOLID.create()));
        nav.addItem(new SideNavItem("Breadcrumbs", BreadcrumbsView.class, LineAwesomeIcon.BREAD_SLICE_SOLID.create()));
        nav.addItem(new SideNavItem("Checkboxes", CheckboxesView.class, LineAwesomeIcon.CHECK_SQUARE.create()));
        nav.addItem(new SideNavItem("Dialogs", DialogsView.class, LineAwesomeIcon.WINDOWS.create()));
        nav.addItem(new SideNavItem("Empty states", EmptyStatesView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("Grids", GridsView.class, LineAwesomeIcon.LIST_SOLID.create()));
        nav.addItem(new SideNavItem("Headers", HeadersView.class, LineAwesomeIcon.HEADING_SOLID.create()));
        nav.addItem(new SideNavItem("Highlights", HighlightsView.class, LineAwesomeIcon.CHART_LINE_SOLID.create()));
        nav.addItem(new SideNavItem("Input groups", InputGroupsView.class, LineAwesomeIcon.KEYBOARD.create()));
        nav.addItem(new SideNavItem("Key-value pairs", KeyValuePairsView.class, LineAwesomeIcon.KEY_SOLID.create()));
        nav.addItem(new SideNavItem("Lists", ListsView.class, LineAwesomeIcon.LIST_SOLID.create()));
        nav.addItem(new SideNavItem("Menu bars", MenuBarsView.class, LineAwesomeIcon.ELLIPSIS_V_SOLID.create()));
        nav.addItem(new SideNavItem("Notifications", NotificationsView.class, LineAwesomeIcon.BELL.create()));
        nav.addItem(new SideNavItem("Radio buttons", RadioButtonsView.class, LineAwesomeIcon.CHECK_CIRCLE_SOLID.create()));
        nav.addItem(new SideNavItem("Search dialogs", SearchDialogsView.class, LineAwesomeIcon.SEARCH_SOLID.create()));
        nav.addItem(new SideNavItem("Sidebar", SidebarsView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new SideNavItem("Statuses", StatusesView.class, LineAwesomeIcon.INFO_CIRCLE_SOLID.create()));
        nav.addItem(new SideNavItem("Steppers", SteppersView.class, LineAwesomeIcon.WALKING_SOLID.create()));
        nav.addItem(new SideNavItem("Tabs", TabsView.class, LineAwesomeIcon.EXCHANGE_ALT_SOLID.create()));
        nav.addItem(new SideNavItem("Top Nav", TopNavView.class, LineAwesomeIcon.BARS_SOLID.create()));
        return nav;
    }

    private SideNav createTemplatesNavigation() {
        SideNav nav = new SideNav("Templates");
        nav.addItem(new SideNavItem("Checkout", CheckoutView.class, LineAwesomeIcon.CREDIT_CARD.create()));
        nav.addItem(new SideNavItem("Product details", ProductDetailsView.class, LineAwesomeIcon.PRODUCT_HUNT.create()));
        nav.addItem(new SideNavItem("Product list", ProductListView.class, LineAwesomeIcon.TH_LARGE_SOLID.create()));
        nav.addItem(new SideNavItem("Profile", ProfileView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Shopping cart", ShoppingCartView.class, LineAwesomeIcon.SHOPPING_CART_SOLID.create()));
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
