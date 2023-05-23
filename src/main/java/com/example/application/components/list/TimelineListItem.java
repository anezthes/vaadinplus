package com.example.application.components.list;

import com.example.application.utilities.BackgroundColor;
import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class TimelineListItem extends ListItem {

    private Icon icon;
    private Html content;
    private Avatar avatar;
    private Span author;
    private Span activity;
    private Span time;

    private TimelineListItem(VaadinIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor) {
        addClassNames("timeline");
        setIcon(icon, iconBackgroundColor, iconTextColor);
    }

    public TimelineListItem(VaadinIcon icon, String content, String time) {
        this(icon, BackgroundColor.BASE, TextColor.SECONDARY, content, time);
    }

    public TimelineListItem(VaadinIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor, String content, String time) {
        this(icon, iconBackgroundColor, iconTextColor);
        setContent(content);

        this.time = new Span(time);
        this.time.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        setPrefix(this.icon);
        setPrimary(this.content);
        setSuffix(this.time);
    }

    public TimelineListItem(VaadinIcon icon, String author, String activity, String time) {
        this(icon, BackgroundColor.BASE, TextColor.SECONDARY, author, activity, time);
    }

    public TimelineListItem(VaadinIcon icon, TextColor iconTextColor, String author, String activity, String time) {
        this(icon, BackgroundColor.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(VaadinIcon icon, String author, Component activity, String time) {
        this(icon, BackgroundColor.BASE, TextColor.SECONDARY, author, activity, time);
    }

    public TimelineListItem(VaadinIcon icon, TextColor iconTextColor, String author, Component activity, String time) {
        this(icon, BackgroundColor.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(VaadinIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor, String author, String activity, String time) {
        this(icon, iconBackgroundColor, iconTextColor, author, new Text(" " + activity + " "), time);
    }

    public TimelineListItem(VaadinIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor, String author, Component activity, String time) {
        this(icon, iconBackgroundColor, iconTextColor);

        this.avatar = new Avatar(author);
        this.avatar.addThemeVariants(AvatarVariant.LUMO_XSMALL);

        this.author = new Span(author);
        this.author.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.TextColor.BODY);

        this.activity = new Span(activity);
        this.activity.addClassNames(LumoUtility.TextColor.SECONDARY);

        this.time = new Span(time);
        this.time.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        setPrefix(this.icon);
        setPrimary(this.avatar, new Span(this.author, this.activity));
        setSuffix(this.time);
    }

    public void setIcon(VaadinIcon icon, BackgroundColor background, TextColor color) {
        this.icon = icon.create();
        this.icon.addClassNames(
                LumoUtility.Border.ALL, LumoUtility.BorderColor.CONTRAST_10, LumoUtility.Height.MEDIUM,
                LumoUtility.Padding.SMALL, "rounded-full", LumoUtility.Width.MEDIUM
        );
        this.icon.addClassNames(background.getClassName(), color.getClassName());
    }

    public void setContent(String content) {
        this.content = new Html("<span class='" + LumoUtility.TextColor.SECONDARY + "'>" +
                content
                        .replace("<b>", "<span class='" + LumoUtility.FontWeight.SEMIBOLD +
                                " " + LumoUtility.TextColor.BODY + "'>")
                        .replace("</b>", "</span>")
                + "</span>"
        );
    }

    public void setAvatarImage(String url) {
        this.avatar.setImage(url);
    }

    public void setAuthor(String author) {
        this.avatar.setName(author);
        this.author.setText(author);
    }

    public void setActivity(String activity) {
        this.activity.setText(activity);
    }

    public void setActivity(Component... components) {
        this.activity.removeAll();
        this.activity.add(components);
    }

    public void setTime(String time) {
        this.time.setText(time);
    }
}
