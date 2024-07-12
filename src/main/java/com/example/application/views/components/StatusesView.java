package com.example.application.views.components;

import com.example.application.components.Notification;
import com.example.application.utilities.Color;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Statuses")
@Route(value = "statuses", layout = MainLayout.class)
public class StatusesView extends ComponentView {

    public static final String LOREM_IPSUM_PT1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    public static final String LOREM_IPSUM_PT2 = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    public StatusesView() {
        addH2("Info");
        add(createNotification());

        addH2("Success");
        add(createSuccessNotification());

        addH2("Error");
        add(createErrorNotification());

        addH2("Theme: border");
        Notification notification = createNotification();
        notification.setBorder(true);
        add(notification);

        addH2("Theme: start border");
        notification = createSuccessNotification();
        notification.setAccentBorder(true);
        add(notification);

        addH2("Custom text color");
        notification = createErrorNotification();
        notification.setTextColor(Color.Text.ERROR);
        add(notification);
    }

    private Notification createNotification() {
        Notification notification = new Notification("Update available", LOREM_IPSUM_PT1, Notification.Type.INFO);
        notification.setActions(new Button("Update"));
        return notification;
    }

    private Notification createSuccessNotification() {
        Notification notification = new Notification(
                "Update successful", LOREM_IPSUM_PT2, Notification.Type.SUCCESS
        );
        notification.setActions(new Button("Details"));
        return notification;
    }

    private Notification createErrorNotification() {
        UnorderedList list = new UnorderedList(
                new ListItem(LOREM_IPSUM_PT1),
                new ListItem(LOREM_IPSUM_PT2)
        );
        list.addClassNames(Margin.Vertical.NONE, Padding.Start.MEDIUM);
        return new Notification("There are 2 errors:", list, Notification.Type.ERROR);
    }

}
