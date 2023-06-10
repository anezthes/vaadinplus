package com.example.application.views;

import com.example.application.components.Layout;
import com.example.application.utilities.Gap;
import com.example.application.utilities.IconSize;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Notifications II")
@Route(value = "notifications-ii", layout = MainLayout.class)
public class NotificationsIIView extends View {

    public NotificationsIIView() {
        addClassNames(LumoUtility.AlignItems.START, LumoUtility.Padding.Top.LARGE);

        add(
                new Button("Simple", e -> createNotificationWithIcon().open()),
                new Button("Icon & Description", e -> createNotificationWithLink().open())
        );
    }

    private Notification createNotificationWithIcon() {
        Component icon = LineAwesomeIcon.CHECK_CIRCLE_SOLID.create();
        icon.addClassNames(LumoUtility.TextColor.SUCCESS);
        ((HasSize) icon).setHeight(IconSize.SMALL.getCSSVariable());
        ((HasSize) icon).setWidth(IconSize.SMALL.getCSSVariable());

        Span title = new Span("Lorem ipsum");
        title.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.FontWeight.SEMIBOLD);

        Span message = new Span("Excepteur sint occaecat cupidatat non proident");
        message.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        Layout text = new Layout(title, message);
        text.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        text.setGap(Gap.XSMALL);

        Layout layout = new Layout(icon, text);
        layout.addClassNames(LumoUtility.AlignSelf.START, LumoUtility.Padding.MEDIUM);
        layout.setGap(Gap.SMALL);

        Button close = new Button(LineAwesomeIcon.TIMES_SOLID.create());
        close.addClassNames(LumoUtility.Margin.NONE, LumoUtility.TextColor.SECONDARY);
        close.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close");

        Layout buttons = new Layout(close);
        buttons.addClassNames(LumoUtility.AlignSelf.START, LumoUtility.Padding.SMALL);

        Notification notification = new Notification(layout, buttons);
        notification.addThemeName("no-padding");
        notification.setPosition(Notification.Position.TOP_END);
        return notification;
    }

    private Notification createNotificationWithLink() {
        Span title = new Span("Lorem ipsum");
        title.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.FontWeight.SEMIBOLD, LumoUtility.Padding.MEDIUM);

        Button button = new Button("Button");
        button.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);

        Button close = new Button(LineAwesomeIcon.TIMES_SOLID.create());
        close.addClassNames(LumoUtility.TextColor.SECONDARY);
        close.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close");

        Layout buttons = new Layout(button, close);
        buttons.addClassNames(LumoUtility.Padding.SMALL);
        buttons.setGap(Gap.SMALL);

        Notification notification = new Notification(title, buttons);
        notification.addThemeName("no-padding");
        notification.setPosition(Notification.Position.TOP_END);
        return notification;
    }

}
