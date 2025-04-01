package com.example.application.component.list;

import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.utility.Color;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;


public class TimelineListItem extends ListItem {

    private Layout icon;
    private Html content;
    private Avatar avatar;
    private Span author;
    private Span activity;
    private Span time;

    private TimelineListItem(MaterialSymbol symbol, Color.Background iconBackgroundColor, Color.Text iconTextColor) {
        addClassNames("timeline");
        setIcon(symbol, iconBackgroundColor, iconTextColor);
    }

    public TimelineListItem(MaterialSymbol symbol, String content, String time) {
        this(symbol, Color.Background.BASE, Color.Text.SECONDARY, content, time);
    }

    public TimelineListItem(MaterialSymbol symbol, Color.Background iconBackgroundColor, Color.Text iconTextColor, String content, String time) {
        this(symbol, iconBackgroundColor, iconTextColor);
        setContent(content);

        this.icon.setPosition(Layout.Position.RELATIVE);

        this.time = new Span(time);
        this.time.addClassNames(FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        setPrefix(this.icon);
        setPrimary(this.content);
        setSuffix(this.time);
    }

    public TimelineListItem(MaterialSymbol symbol, String author, String activity, String time) {
        this(symbol, Color.Background.BASE, Color.Text.SECONDARY, author, activity, time);
    }

    public TimelineListItem(MaterialSymbol symbol, Color.Text iconTextColor, String author, String activity, String time) {
        this(symbol, Color.Background.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(MaterialSymbol symbol, String author, Component activity, String time) {
        this(symbol, Color.Background.BASE, Color.Text.SECONDARY, author, activity, time);
    }

    public TimelineListItem(MaterialSymbol symbol, Color.Text iconTextColor, String author, Component activity, String time) {
        this(symbol, Color.Background.BASE, iconTextColor, author, activity, time);
    }

    public TimelineListItem(MaterialSymbol symbol, Color.Background iconBackgroundColor, Color.Text iconTextColor, String author, String activity, String time) {
        this(symbol, iconBackgroundColor, iconTextColor, author, new Text(" " + activity + " "), time);
    }

    public TimelineListItem(MaterialSymbol symbol, Color.Background iconBackgroundColor, Color.Text iconTextColor, String author, Component activity, String time) {
        this(symbol, iconBackgroundColor, iconTextColor);

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

    public void setIcon(MaterialSymbol symbol, Color.Background backgroundColor, Color.Text color) {
        this.icon = new Layout(symbol.create(IconSize.SMALL));
        this.icon.addClassNames(backgroundColor.getClassName(), Border.ALL, BorderColor.CONTRAST_30, BorderRadius.FULL,
                Height.MEDIUM, color.getClassName(), Width.MEDIUM);
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
