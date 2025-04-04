package com.example.application.view.component;

import com.example.application.component.MaterialSymbol;
import com.example.application.component.nav.TopNav;
import com.example.application.component.nav.TopNavItem;
import com.example.application.view.MainLayout;
import com.example.application.view.template.ProfileView;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;


@PageTitle("Top navigation")
@Route(value = "top-nav", layout = MainLayout.class)
public class TopNavView extends ComponentView {

    public TopNavView() {
        addClassNames(Padding.Top.LARGE);
        addPreview(createSideNav());
    }

    private TopNav createSideNav() {
        TopNav nav = new TopNav();

        TopNavItem home = new TopNavItem("Home", AppBarsView.class, MaterialSymbol.HOME.create());

        TopNavItem messages = new TopNavItem("Messages", BreadcrumbsView.class, MaterialSymbol.MESSAGE.create());
        messages.addItem(new TopNavItem("Inbox", CheckboxesView.class, MaterialSymbol.INBOX.create()));
        messages.addItem(new TopNavItem("Sent", DialogsView.class, MaterialSymbol.SEND.create()));
        messages.addItem(new TopNavItem("Trash", EmptyStatesView.class, MaterialSymbol.DELETE.create()));

        TopNavItem settings = new TopNavItem("Settings", ProfileView.class, MaterialSymbol.SETTINGS.create());
        settings.addItem(new TopNavItem("Users", GridsView.class, MaterialSymbol.PEOPLE.create()));
        settings.addItem(new TopNavItem("Permissions", HeadersView.class, MaterialSymbol.ADMIN_PANEL_SETTINGS.create()));

        nav.addItem(home, messages, settings);
        return nav;
    }

}
