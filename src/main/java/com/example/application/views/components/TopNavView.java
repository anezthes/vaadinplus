package com.example.application.views.components;

import com.example.application.components.TopNav;
import com.example.application.components.TopNavItem;
import com.example.application.views.MainLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Top Navigation")
@Route(value = "top-nav", layout = MainLayout.class)
public class TopNavView extends ComponentView {

    public TopNavView() {
        addClassNames(LumoUtility.Padding.Top.LARGE);
        addPreview(createSideNav());
    }

    private TopNav createSideNav() {
        TopNav nav = new TopNav();

        TopNavItem homeLink = new TopNavItem("Home", AppBarsView.class, LineAwesomeIcon.HOME_SOLID.create());

        TopNavItem messagesLink = new TopNavItem("Messages", BreadcrumbsView.class, LineAwesomeIcon.ENVELOPE.create());
        messagesLink.addItem(new TopNavItem("Inbox", CheckboxesView.class, LineAwesomeIcon.INBOX_SOLID.create()));
        messagesLink.addItem(new TopNavItem("Sent", DialogsView.class, LineAwesomeIcon.PAPER_PLANE.create()));
        messagesLink.addItem(new TopNavItem("Trash", EmptyStatesView.class, LineAwesomeIcon.TRASH_SOLID.create()));

        TopNavItem adminSection = new TopNavItem("Admin");
        adminSection.setPrefixComponent(LineAwesomeIcon.COG_SOLID.create());
        adminSection.addItem(new TopNavItem("Users", GridsView.class, LineAwesomeIcon.USERS_SOLID.create()));
        adminSection.addItem(new TopNavItem("Permissions", HeadersView.class, LineAwesomeIcon.KEY_SOLID.create()));

        nav.addItem(homeLink, messagesLink, adminSection);
        return nav;
    }

}
