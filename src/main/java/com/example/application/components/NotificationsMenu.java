package com.example.application.components;

import com.example.application.components.list.List;
import com.example.application.components.list.ListItem;
import com.example.application.views.components.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;

public class NotificationsMenu extends NativeDialog {

    public NotificationsMenu() {
        setAriaLabel("Notifications");

        // Position
        setRight(0.5f, Unit.REM);
        setTop(3.5f, Unit.REM);

        // Links
        List list = new List(
                createNotification("Sam Rivers", "tagged you in", "Project Horizon", "2 hours ago", HomeView.class),
                createNotification("Marcus Peters", "commented on", "Eclipse Estimates Q1", "4 hours ago", HomeView.class)
        );
        add(list);
    }

    private ListItem createNotification(String who, String what, String where, String when,
                                        Class<? extends Component> navigationTarget) {


        ListItem item = new ListItem();
        item.addClassNames("hover:bg-contrast-5");
        item.setPrefix(new Avatar(who));
        item.setPrimary(who);
        item.setRoute(HomeView.class);
        return item;
    }

}
