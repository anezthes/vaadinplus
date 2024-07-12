package com.example.application.views.components;

import com.example.application.components.TopNav;
import com.example.application.components.TopNavItem;
import com.example.application.views.MainLayout;
import com.example.application.views.templates.ProfileView;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Top navigation")
@Route(value = "top-nav", layout = MainLayout.class)
public class TopNavView extends ComponentView {

    public TopNavView() {
        addClassNames(Padding.Top.LARGE);
        addPreview(createSideNav());
    }

    private TopNav createSideNav() {
        TopNav nav = new TopNav();

        TopNavItem home = new TopNavItem("Home", AppBarsView.class, LineAwesomeIcon.HOME_SOLID.create());

        TopNavItem messages = new TopNavItem("Messages", BreadcrumbsView.class, LineAwesomeIcon.ENVELOPE.create());
        messages.addItem(new TopNavItem("Inbox", CheckboxesView.class, LineAwesomeIcon.INBOX_SOLID.create()));
        messages.addItem(new TopNavItem("Sent", DialogsView.class, LineAwesomeIcon.PAPER_PLANE.create()));
        messages.addItem(new TopNavItem("Trash", EmptyStatesView.class, LineAwesomeIcon.TRASH_SOLID.create()));

        TopNavItem settings = new TopNavItem("Settings", ProfileView.class, LineAwesomeIcon.COG_SOLID.create());
        settings.addItem(new TopNavItem("Users", GridsView.class, LineAwesomeIcon.USERS_SOLID.create()));
        settings.addItem(new TopNavItem("Permissions", HeadersView.class, LineAwesomeIcon.KEY_SOLID.create()));

        nav.addItem(home, messages, settings);
        return nav;
    }

}
