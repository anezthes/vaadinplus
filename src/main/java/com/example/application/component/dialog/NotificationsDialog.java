package com.example.application.component.dialog;

import com.example.application.component.list.List;
import com.example.application.component.list.MessageLinkListItem;
import com.example.application.view.HomeView;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.popover.Popover;
import com.vaadin.flow.component.popover.PopoverVariant;

import java.time.LocalDateTime;

public class NotificationsDialog extends Popover {

    public NotificationsDialog() {
        addThemeVariants(PopoverVariant.ARROW);
        setAriaLabel("Notifications");

        // Links
        List list = new List(
                new MessageLinkListItem("Sam Rivers", "tagged you in Project Horizon",
                        LocalDateTime.now().minusHours(2), HomeView.class),
                new MessageLinkListItem("Marcus Peters", "commented on Eclipse Estimates Q1",
                        LocalDateTime.now().minusHours(4), HomeView.class)
        );
        list.setMaxWidth(25, Unit.REM);
        add(list);
    }

}
