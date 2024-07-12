package com.example.application.components.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

public class NotificationListItem extends ListItem {

    private Span author;
    private Span activity;
    private RouterLink link;

    public NotificationListItem(
            String author,
            String activity,
            String linkText,
            Class<? extends Component> navigationTarget,
            String time
    ) {
        this.author = new Span(author);
        this.author.addClassNames(FontWeight.SEMIBOLD);

        this.activity = new Span(" " + activity + " ");
        this.activity.addClassNames(TextColor.SECONDARY);

        this.link = new RouterLink(linkText, navigationTarget);

        setPrefix(new Avatar(author));
        setPrimary(new Span(this.author, this.activity, this.link));
        setSecondary(time);
    }

}
