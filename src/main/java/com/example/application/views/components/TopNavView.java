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
        addH2("Explicit Expand/Collapse");
        addPreview(createSideNav());
    }

    private TopNav createSideNav() {
        TopNav nav = new TopNav();

        TopNavItem homeLink = new TopNavItem("Home", HomeView.class, LineAwesomeIcon.HOME_SOLID.create());

        TopNavItem messagesLink = new TopNavItem("Messages", AppBarsView.class, LineAwesomeIcon.ENVELOPE.create());
        messagesLink.addItem(new TopNavItem("Inbox", BreadcrumbsView.class, LineAwesomeIcon.INBOX_SOLID.create()));
        messagesLink.addItem(new TopNavItem("Sent", CheckboxesView.class, LineAwesomeIcon.PAPER_PLANE.create()));
        messagesLink.addItem(new TopNavItem("Trash", DialogsView.class, LineAwesomeIcon.TRASH_SOLID.create()));

        TopNavItem adminSection = new TopNavItem("Admin");
        adminSection.setPrefixComponent(LineAwesomeIcon.COG_SOLID.create());
        adminSection.addItem(new TopNavItem("Users", EmptyStatesView.class, LineAwesomeIcon.USERS_SOLID.create()));
        adminSection.addItem(new TopNavItem("Permissions", GridsView.class, LineAwesomeIcon.KEY_SOLID.create()));

        nav.addItem(homeLink, messagesLink, adminSection);
        return nav;
    }

}
