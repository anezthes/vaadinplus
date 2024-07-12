package com.example.application.components.list;

import com.example.application.components.Layout;
import com.example.application.utilities.Color;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class TimelineListItem extends ListItem {

    private Layout icon;
    private Html content;
    private Avatar avatar;
    private Span author;
    private Span activity;
    private Span time;

    private TimelineListItem(LineAwesomeIcon icon, Color.Background iconBackgroundColor, Color.Text iconTextColor) {
        addClassNames("timeline");
        setIcon(icon, iconBackgroundColor, iconTextColor);
    }

    public TimelineListItem(LineAwesomeIcon icon, String content, String time) {
        this(icon, Color.Background.BASE, Color.Text.SECONDARY, content, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, Color.Background iconBackgroundColor, Color.Text iconTextColor, String content, String time) {
        this(icon, iconBackgroundColor, iconTextColor);
        setContent(content);

        this.time = new Span(time);
        this.time.addClassNames(FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        setPrefix(this.icon);
        setPrimary(this.content);
        setSuffix(this.time);
    }

    public TimelineListItem(LineAwesomeIcon icon, String author, String activity, String time) {
        this(icon, Color.Background.BASE, Color.Text.SECONDARY, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, Color.Text iconTextColor, String author, String activity, String time) {
        this(icon, Color.Background.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, String author, Component activity, String time) {
        this(icon, Color.Background.BASE, Color.Text.SECONDARY, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, Color.Text iconTextColor, String author, Component activity, String time) {
        this(icon, Color.Background.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, Color.Background iconBackgroundColor, Color.Text iconTextColor, String author, String activity, String time) {
        this(icon, iconBackgroundColor, iconTextColor, author, new Text(" " + activity + " "), time);
    }

    public TimelineListItem(LineAwesomeIcon icon, Color.Background iconBackgroundColor, Color.Text iconTextColor, String author, Component activity, String time) {
        this(icon, iconBackgroundColor, iconTextColor);

        this.avatar = new Avatar(author);
        this.avatar.addThemeVariants(AvatarVariant.LUMO_XSMALL);

        this.author = new Span(author);
        this.author.addClassNames(FontWeight.SEMIBOLD, LumoUtility.TextColor.BODY);

        this.activity = new Span(activity);
        this.activity.addClassNames(LumoUtility.TextColor.SECONDARY);

        this.time = new Span(time);
        this.time.addClassNames(FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        setPrefix(this.icon);
        setPrimary(this.avatar, new Span(this.author, this.activity));
        setSuffix(this.time);
    }

    public void setIcon(LineAwesomeIcon icon, Color.Background backgroundColor, Color.Text color) {
        SvgIcon i = icon.create();
        i.addClassNames(IconSize.SMALL);

        this.icon = new Layout(i);
        this.icon.addClassNames(backgroundColor.getClassName(), Border.ALL, BorderColor.CONTRAST_30,
                "rounded-full", Height.MEDIUM, color.getClassName(), Width.MEDIUM);
        this.icon.setAlignItems(Layout.AlignItems.CENTER);
        this.icon.setBoxSizing(Layout.BoxSizing.BORDER);
        this.icon.setJustifyContent(Layout.JustifyContent.CENTER);
    }

    public void setContent(String content) {
        this.content = new Html("<span class='" + TextColor.SECONDARY + "'>" +
                content
                        .replace("<b>", "<span class='" + FontWeight.SEMIBOLD +
                                " " + TextColor.BODY + "'>")
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
