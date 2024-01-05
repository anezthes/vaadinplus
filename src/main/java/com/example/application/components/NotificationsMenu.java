package com.example.application.components;

import com.example.application.components.list.List;
import com.example.application.components.list.ListItem;
import com.example.application.views.components.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class NotificationsMenu extends NativeDialog {

    public NotificationsMenu() {
        setAriaLabel("Notifications");

        // Position
        setRight(0.5f, Unit.REM);
        setTop(3.5f, Unit.REM);

        // Links
        List list = new List(
                createNotification("Sam Rivers", "tagged you in Project Horizon", "2 hours ago", HomeView.class),
                createNotification("Marcus Peters", "commented on Eclipse Estimates Q1", "4 hours ago", HomeView.class)
        );
        add(list);
    }

    private ListItem createNotification(String person, String comment, String time,
                                        Class<? extends Component> navigationTarget) {
        Span personSpan = new Span(person);
        personSpan.addClassNames(FontWeight.SEMIBOLD);

        Span timeSpan = new Span(time);
        timeSpan.addClassNames(FontSize.XSMALL, TextColor.SECONDARY);

        Span primary = new Span(personSpan, timeSpan);
        primary.addClassNames(AlignItems.BASELINE, Display.FLEX, FontSize.SMALL, Gap.SMALL);

        Span secondary = new Span(comment);
        secondary.addClassNames(FontSize.XSMALL, TextColor.BODY);

        ListItem item = new ListItem();
        item.addClassNames("hover:bg-contrast-5");
        item.setPrefix(new Avatar(person));
        item.setPrimary(primary);
        item.setSecondary(secondary);
        item.setRoute(navigationTarget);
        return item;
    }

}
