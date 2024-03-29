package com.example.application.components.list;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.time.Duration;
import java.time.LocalDateTime;

public class MessageListItem extends ListItem {

    private Avatar avatar;
    private Span name;
    private Span time;

    public MessageListItem(String src, String name, String message, LocalDateTime dateTime) {
        this(name, message, dateTime);
        this.avatar.setImage(src);
    }

    public MessageListItem(String name, String message, LocalDateTime dateTime) {
        removeClassName(LumoUtility.AlignItems.CENTER);

        this.avatar = new Avatar(name);
        this.avatar.addClassNames(LumoUtility.Margin.Top.XSMALL);
        setPrefix(this.avatar);

        this.name = new Span(name);
        this.name.addClassNames(LumoUtility.FontWeight.SEMIBOLD);

        this.time = new Span(formatTimeAgo(dateTime));
        this.time.addClassNames(LumoUtility.TextColor.SECONDARY);

        setPrimary(this.name, this.time);
        this.primary.addClassNames(LumoUtility.FontSize.SMALL);
        this.primary.setAlignItems(FlexComponent.Alignment.BASELINE);

        setSecondary(message);
        this.secondary.removeClassName(LumoUtility.TextColor.SECONDARY);
    }

    public static String formatTimeAgo(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(dateTime, now);

        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();

        if (days > 0) {
            return days + (days == 1 ? " day ago" : " days ago");
        } else if (hours > 0) {
            return hours + (hours == 1 ? " hour ago" : " hours ago");
        } else {
            return minutes + (minutes == 1 ? " minute ago" : " minutes ago");
        }
    }
}
