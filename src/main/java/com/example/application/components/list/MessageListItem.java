package com.example.application.components.list;

import com.example.application.components.Layout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

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
        removeClassName(AlignItems.CENTER);

        this.avatar = new Avatar(name);
        this.avatar.addClassNames(Margin.Top.XSMALL);
        setPrefix(this.avatar);

        this.name = new Span(name);
        this.name.addClassNames(FontWeight.SEMIBOLD);

        this.time = new Span(formatTimeAgo(dateTime));
        this.time.addClassNames(TextColor.SECONDARY);

        setPrimary(this.name, this.time);
        this.primary.addClassNames(FontSize.SMALL);
        this.primary.setAlignItems(Layout.AlignItems.BASELINE);

        setSecondary(message);
        this.secondary.removeClassName(TextColor.SECONDARY);
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
