package com.example.application.view.component;

import com.example.application.component.NavRail;
import com.example.application.component.NavRailItem;
import com.example.application.view.MainLayout;
import com.example.application.view.template.ProfileView;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Navigation rail")
@Route(value = "nav-rail", layout = MainLayout.class)
public class NavRailView extends ComponentView {

    public NavRailView() {
        addH2("Show sub-items on focus");
        add(createRailNav(true));

        addH2("Don't show sub-items on focus");
        add(createRailNav(false));
    }

    private NavRail createRailNav(boolean showSubItemsOnFocus) {
        NavRail nav = new NavRail();
        nav.setShowSubItemsOnFocus(showSubItemsOnFocus);

        NavRailItem home = new NavRailItem("Home", AppBarsView.class, LineAwesomeIcon.HOME_SOLID.create());

        NavRailItem messages = new NavRailItem("Messages", BreadcrumbsView.class, LineAwesomeIcon.ENVELOPE.create());
        messages.addItem(new NavRailItem("Inbox", CheckboxesView.class, LineAwesomeIcon.INBOX_SOLID.create()));
        messages.addItem(new NavRailItem("Sent", DialogsView.class, LineAwesomeIcon.PAPER_PLANE.create()));
        messages.addItem(new NavRailItem("Trash", EmptyStatesView.class, LineAwesomeIcon.TRASH_SOLID.create()));

        NavRailItem settings = new NavRailItem("Settings", ProfileView.class, LineAwesomeIcon.COG_SOLID.create());
        settings.addItem(new NavRailItem("Users", GridsView.class, LineAwesomeIcon.USERS_SOLID.create()));
        settings.addItem(new NavRailItem("Permissions", HeadersView.class, LineAwesomeIcon.KEY_SOLID.create()));

        nav.addItem(home, messages, settings);
        return nav;
    }

}
