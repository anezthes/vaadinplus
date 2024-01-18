package com.example.application.components.list;

import com.example.application.components.Layout;
import com.example.application.utilities.BackgroundColor;
import com.example.application.utilities.BoxSizing;
import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
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

    private TimelineListItem(LineAwesomeIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor) {
        addClassNames("timeline");
        setIcon(icon, iconBackgroundColor, iconTextColor);
    }

    public TimelineListItem(LineAwesomeIcon icon, String content, String time) {
        this(icon, BackgroundColor.BASE, TextColor.SECONDARY, content, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor, String content, String time) {
        this(icon, iconBackgroundColor, iconTextColor);
        setContent(content);

        this.time = new Span(time);
        this.time.addClassNames(FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        setPrefix(this.icon);
        setPrimary(this.content);
        setSuffix(this.time);
    }

    public TimelineListItem(LineAwesomeIcon icon, String author, String activity, String time) {
        this(icon, BackgroundColor.BASE, TextColor.SECONDARY, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, TextColor iconTextColor, String author, String activity, String time) {
        this(icon, BackgroundColor.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, String author, Component activity, String time) {
        this(icon, BackgroundColor.BASE, TextColor.SECONDARY, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, TextColor iconTextColor, String author, Component activity, String time) {
        this(icon, BackgroundColor.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(LineAwesomeIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor, String author, String activity, String time) {
        this(icon, iconBackgroundColor, iconTextColor, author, new Text(" " + activity + " "), time);
    }

    public TimelineListItem(LineAwesomeIcon icon, BackgroundColor iconBackgroundColor, TextColor iconTextColor, String author, Component activity, String time) {
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

    public void setIcon(LineAwesomeIcon icon, BackgroundColor background, TextColor color) {
        SvgIcon i = icon.create();
        i.addClassNames(IconSize.SMALL);

        this.icon = new Layout(i);
        this.icon.addClassNames(
                background.getClassName(), Border.ALL, BorderColor.CONTRAST_30,
                color.getClassName(), Height.MEDIUM, "rounded-full", Width.MEDIUM
        );
        this.icon.setAlignItems(FlexComponent.Alignment.CENTER);
        this.icon.setBoxSizing(BoxSizing.BORDER);
        this.icon.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
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
