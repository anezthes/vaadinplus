package com.example.application.views.components;

import com.example.application.components.Layout;
import com.example.application.utilities.Gap;
import com.example.application.utilities.IconSize;
import com.example.application.utilities.LineClamp;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Notifications")
@Route(value = "notifications", layout = MainLayout.class)
public class NotificationsView extends ComponentView {

    public NotificationsView() {
        addClassNames(AlignItems.START, Padding.Top.LARGE);

        add(
                new Button("Simple", e -> createSimpleNotification().open()),
                new Button("Icon & description", e -> createNotificationWithIconDescription().open()),
                new Button("Icon, description & actions", e -> createNotificationWithIconDescriptionActions().open()),
                new Button("Stacked actions", e -> createNotificationWithStackedActions().open())
        );
    }

    private Notification createSimpleNotification() {
        Span title = new Span("Lorem ipsum");
        title.addClassNames(AlignSelf.BASELINE, FontSize.SMALL, FontWeight.SEMIBOLD, Padding.MEDIUM);

        Button button = new Button("Button");
        button.addClassNames(Margin.NONE);
        button.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);

        Button close = new Button(LineAwesomeIcon.TIMES_SOLID.create());
        close.addClassNames(Margin.NONE, TextColor.SECONDARY);
        close.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close");

        Layout buttons = new Layout(button, close);
        buttons.addClassNames(AlignSelf.BASELINE, Padding.SMALL);
        buttons.setGap(Gap.SMALL);

        Notification notification = new Notification(title, buttons);
        notification.addThemeName("no-padding");
        notification.setPosition(Notification.Position.TOP_END);
        return notification;
    }

    private Notification createNotificationWithIconDescription() {
        Component icon = LineAwesomeIcon.CHECK_CIRCLE_SOLID.create();
        icon.addClassNames(TextColor.SUCCESS);
        icon.getStyle().set("--_size", IconSize.SMALL.getCSSVariable());

        Span title = new Span("Lorem ipsum");
        title.addClassNames(FontSize.SMALL, FontWeight.SEMIBOLD);

        Span message = new Span("Excepteur sint occaecat cupidatat non proident");
        message.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Layout text = new Layout(title, message);
        text.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        text.setGap(Gap.XSMALL);

        Layout layout = new Layout(icon, text);
        layout.addClassNames(AlignSelf.START, Padding.MEDIUM);
        layout.setGap(Gap.SMALL);

        Button close = new Button(LineAwesomeIcon.TIMES_SOLID.create());
        close.addClassNames(Margin.NONE, TextColor.SECONDARY);
        close.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close");

        Layout buttons = new Layout(close);
        buttons.addClassNames(AlignSelf.START, Padding.SMALL);

        Notification notification = new Notification(layout, buttons);
        notification.addThemeName("no-padding");
        notification.setPosition(Notification.Position.TOP_END);
        return notification;
    }

    private Notification createNotificationWithIconDescriptionActions() {
        Component icon = LineAwesomeIcon.CHECK_CIRCLE_SOLID.create();
        icon.addClassNames(TextColor.SUCCESS);
        icon.getStyle().set("--_size", IconSize.SMALL.getCSSVariable());

        Span title = new Span("Lorem ipsum");
        title.addClassNames(FontSize.SMALL, FontWeight.SEMIBOLD);

        Span message = new Span("Excepteur sint occaecat cupidatat non proident");
        message.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Button action1 = new Button("Action 1");
        action1.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);

        Button action2 = new Button("Action 2");
        action2.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);

        Layout actions = new Layout(action1, action2);
        actions.getStyle().set("margin-inline-start", "calc(var(--lumo-button-size, var(--lumo-size-s)) / -6)");
        actions.setGap(Gap.SMALL);

        Layout text = new Layout(title, message, actions);
        text.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        text.setGap(Gap.XSMALL);

        Layout layout = new Layout(icon, text);
        layout.addClassNames(AlignSelf.START, Padding.Bottom.XSMALL, Padding.Horizontal.MEDIUM, Padding.Top.MEDIUM);
        layout.setGap(Gap.SMALL);

        Button close = new Button(LineAwesomeIcon.TIMES_SOLID.create());
        close.addClassNames(Margin.NONE, TextColor.SECONDARY);
        close.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close");

        Layout buttons = new Layout(close);
        buttons.addClassNames(AlignSelf.START, Padding.SMALL);

        Notification notification = new Notification(layout, buttons);
        notification.addThemeName("no-padding");
        notification.setPosition(Notification.Position.TOP_END);
        return notification;
    }

    private Notification createNotificationWithStackedActions() {
        Avatar avatar = new Avatar("Emily Johnson");
        avatar.setImage("https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

        Span name = new Span("John Smith");
        name.addClassNames(FontSize.SMALL, FontWeight.SEMIBOLD);

        Span message = new Span("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        message.addClassNames(FontSize.SMALL, LineClamp.LINE_CLAMP_2.getClassName(), TextColor.SECONDARY);

        Layout text = new Layout(name, message);
        text.addClassNames(Margin.Start.XSMALL);
        text.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        text.setGap(Gap.XSMALL);

        Layout layout = new Layout(avatar, text);
        layout.addClassNames(AlignSelf.STRETCH, Border.RIGHT, BorderColor.CONTRAST_10, Padding.MEDIUM);
        layout.setGap(Gap.SMALL);

        Button action1 = new Button("Action 1");
        action1.addClassNames(Border.BOTTOM, BorderColor.CONTRAST_10, BorderRadius.NONE, Margin.NONE);
        action1.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        action1.setHeight(50, Unit.PERCENTAGE);

        Button action2 = new Button("Action 2");
        action2.addClassNames(BorderRadius.NONE, Margin.NONE);
        action2.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);
        action2.setHeight(50, Unit.PERCENTAGE);

        Layout actions = new Layout(action1, action2);
        actions.addClassNames(AlignSelf.STRETCH, Flex.SHRINK_NONE);
        actions.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        actions.setWidth(6, Unit.REM);

        Notification notification = new Notification(layout, actions);
        notification.addThemeName("no-padding");
        notification.setPosition(Notification.Position.TOP_END);
        return notification;
    }
}
