package com.example.application.views;

import com.example.application.components.Notification;
import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Notifications | Vaadin+")
@Route(value = "notifications", layout = MainLayout.class)
public class NotificationsView extends Main {

	public static final String LOREM_IPSUM_PT1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
	public static final String LOREM_IPSUM_PT2 = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

	public NotificationsView() {
		addClassNames(
				LumoUtility.MinHeight.FULL, LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE
		);

		add(new H2("Info"));
		add(createNotification());

		add(new H2("Success"));
		add(createSuccessNotification());

		add(new H2("Error"));
		add(createErrorNotification());

		add(new H2("Theme: Border"));
		Notification notification = createNotification();
		notification.setBorder(true);
		add(notification);

		add(new H2("Theme: Start Border"));
		notification = createSuccessNotification();
		notification.setStartBorder(true);
		add(notification);

		add(new H2("Custom Text Color"));
		notification = createErrorNotification();
		notification.setTextColor(TextColor.ERROR);
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
		list.addClassNames(LumoUtility.Margin.NONE, LumoUtility.Padding.Start.MEDIUM);
		return new Notification("There are 2 errors:", list, Notification.Type.ERROR);
	}

}
