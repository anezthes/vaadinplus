package com.example.application.view;

import com.example.application.component.Badge;
import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.component.dialog.MessagesDialog;
import com.example.application.component.dialog.NotificationsDialog;
import com.example.application.component.dialog.UserDialog;
import com.example.application.utility.BadgeVariant;
import com.example.application.view.component.*;
import com.example.application.view.template.*;
import com.example.application.view.template.wizard.Step1View;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Position;


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
        viewTitle.addClassNames(FontSize.LARGE);

        Badge messageBadge = new Badge();
        messageBadge.addClassNames(Position.ABSOLUTE, Position.End.XSMALL, Position.Top.XSMALL);
        messageBadge.addThemeVariants(BadgeVariant.SUCCESS, BadgeVariant.PILL, BadgeVariant.PRIMARY, BadgeVariant.SMALL);

        Button messageButton = new Button(MaterialSymbol.MESSAGE.create());
        messageButton.addClassNames(Margin.Start.AUTO);
        messageButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        messageButton.setAriaLabel("View messages (4)");
        messageButton.setSuffixComponent(messageBadge);
        messageButton.setTooltipText("View messages (4)");

        MessagesDialog messagesDialog = new MessagesDialog();
        messagesDialog.setTarget(messageButton);

        Badge notificationsBadge = new Badge();
        notificationsBadge.addClassNames(Position.ABSOLUTE, Position.End.XSMALL, Position.Top.XSMALL);
        notificationsBadge.addThemeVariants(BadgeVariant.ERROR, BadgeVariant.PILL, BadgeVariant.PRIMARY, BadgeVariant.SMALL);

        Button notificationsButton = new Button(MaterialSymbol.NOTIFICATIONS.create());
        notificationsButton.addClassNames(Margin.Start.XSMALL);
        notificationsButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        notificationsButton.setAriaLabel("View notifications (2)");
        notificationsButton.setSuffixComponent(notificationsBadge);
        notificationsButton.setTooltipText("View notifications (2)");

        NotificationsDialog notificationsDialog = new NotificationsDialog();
        notificationsDialog.setTarget(notificationsButton);

        Avatar avatar = new Avatar("John Smith");
        avatar.addClassNames(Margin.Horizontal.SMALL);
        avatar.setTooltipEnabled(true);

        UserDialog userDialog = new UserDialog();
        userDialog.setTarget(avatar);

        addToNavbar(true, toggle, viewTitle, messageButton, messagesDialog, notificationsButton,
                notificationsDialog, avatar);
    }

    private void addDrawerContent() {
        Span appName = new Span("Vaadin+");
        appName.addClassNames(FontSize.LARGE, FontWeight.SEMIBOLD);

        Layout nav = new Layout(createComponentNavigation(), createTemplatesNavigation());
        nav.setFlexDirection(Layout.FlexDirection.COLUMN);
        nav.setGap(Layout.Gap.MEDIUM);

        Scroller scroller = new Scroller(nav);

        addToDrawer(new Header(appName), scroller);
    }

    private SideNav createComponentNavigation() {
        SideNav nav = new SideNav("Components");
        nav.addItem(new SideNavItem("App bars", AppBarsView.class, MaterialSymbol.TOOLBAR.create()));
        nav.addItem(new SideNavItem("Breadcrumbs", BreadcrumbsView.class, MaterialSymbol.MORE_HORIZ.create()));
        nav.addItem(new SideNavItem("Checkboxes", CheckboxesView.class, MaterialSymbol.CHECK_BOX.create()));
        nav.addItem(new SideNavItem("Dialogs", DialogsView.class, MaterialSymbol.WEB_ASSET.create()));
        nav.addItem(new SideNavItem("Empty states", EmptyStatesView.class, MaterialSymbol.DOCUMENT_SEARCH.create()));
        nav.addItem(new SideNavItem("Grids", GridsView.class, MaterialSymbol.TABLE.create()));
        nav.addItem(new SideNavItem("Headers", HeadersView.class, MaterialSymbol.TITLE.create()));
        nav.addItem(new SideNavItem("Highlights", HighlightsView.class, MaterialSymbol.TRENDING_UP.create()));
        nav.addItem(new SideNavItem("Input groups", InputGroupsView.class, MaterialSymbol.INPUT.create()));
        nav.addItem(new SideNavItem("Key-value pairs", KeyValuePairsView.class, MaterialSymbol.KEY.create()));
        nav.addItem(new SideNavItem("Lists", ListsView.class, MaterialSymbol.LIST.create()));
        nav.addItem(new SideNavItem("Menu bars", MenuBarsView.class, MaterialSymbol.MORE_VERT.create()));
        nav.addItem(new SideNavItem("Navigation rail", NavRailView.class, MaterialSymbol.DOCK_TO_RIGHT.create()));
        nav.addItem(new SideNavItem("Notifications", NotificationsView.class, MaterialSymbol.NOTIFICATIONS.create()));
        nav.addItem(new SideNavItem("Radio buttons", RadioButtonsView.class, MaterialSymbol.RADIO_BUTTON_CHECKED.create()));
        nav.addItem(new SideNavItem("Search dialogs", SearchDialogsView.class, MaterialSymbol.SEARCH.create()));
        nav.addItem(new SideNavItem("Sidebar", SidebarsView.class, MaterialSymbol.VIEW_SIDEBAR.create()));
        nav.addItem(new SideNavItem("Statuses", StatusesView.class, MaterialSymbol.INFO.create()));
        nav.addItem(new SideNavItem("Steppers", SteppersView.class, MaterialSymbol.STEPPERS.create()));
        nav.addItem(new SideNavItem("Tabs", TabsView.class, MaterialSymbol.TAB.create()));
        nav.addItem(new SideNavItem("Top nav", TopNavView.class, MaterialSymbol.TABS.create()));
        return nav;
    }

    private SideNav createTemplatesNavigation() {
        SideNav nav = new SideNav("Templates");
        nav.addItem(new SideNavItem("Checkout", CheckoutView.class, MaterialSymbol.CREDIT_CARD.create()));
        nav.addItem(new SideNavItem("Customers", CustomersView.class, MaterialSymbol.FAVORITE.create()));
        nav.addItem(new SideNavItem("Dashboard º1", DashboardView1.class, MaterialSymbol.DASHBOARD.create()));
        nav.addItem(new SideNavItem("Dashboard º2", DashboardView2.class, MaterialSymbol.DASHBOARD_2.create()));
        nav.addItem(new SideNavItem("Files", FilesView.class, MaterialSymbol.DOCS.create()));
        nav.addItem(new SideNavItem("Hotels", HotelsView.class, MaterialSymbol.HOTEL.create()));
        nav.addItem(new SideNavItem("Product details", ProductDetailsView.class, MaterialSymbol.INFO.create()));
        nav.addItem(new SideNavItem("Product list", ProductListView.class, MaterialSymbol.CALENDAR_VIEW_MONTH.create()));
        nav.addItem(new SideNavItem("Profile", ProfileView.class, MaterialSymbol.ACCOUNT_CIRCLE.create()));
        nav.addItem(new SideNavItem("Shopping cart", ShoppingCartView.class, MaterialSymbol.SHOPPING_CART.create()));
        nav.addItem(new SideNavItem("Validation form", ValidationView.class, MaterialSymbol.CHECKLIST.create()));
        nav.addItem(new SideNavItem("Wizard (WIP)", Step1View.class, MaterialSymbol.STEPPERS.create()));
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
