package com.example.application.component.list;

import com.example.application.component.Layout;
import com.example.application.component.Span;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

import java.time.LocalDateTime;

public class MessageLinkListItem extends RouterLinkListItem {

    public MessageLinkListItem(String name, String message, LocalDateTime dateTime, Class<? extends Component> navigationTarget) {
        setPrefix(new Avatar(name));

        setPrimary(
                new Span(name, FontWeight.SEMIBOLD),
                new Span(formatTimeAgo(dateTime), TextColor.SECONDARY)
        );
        this.primary.addClassNames(FontSize.SMALL);
        this.primary.setAlignItems(Layout.AlignItems.BASELINE);

        setSecondary(message);
        this.secondary.removeClassName(TextColor.SECONDARY);
        this.secondary.setLineClamp(Layout.LineClamp.LINE_CLAMP_2);

        setRoute(navigationTarget);
    }

    public static String formatTimeAgo(LocalDateTime dateTime) {
        return MessageListItem.formatTimeAgo(dateTime);
    }
}
