package com.example.application.components;

import com.example.application.utilities.BackgroundColor;
import com.example.application.utilities.Gap;
import com.example.application.utilities.Size;
import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class IconDialog extends Dialog {

    private Layout layout;
    private Layout iconLayout;
    private BackgroundColor iconBackgroundColor;
    private TextColor iconTextColor;
    private SvgIcon icon;
    private Layout textLayout;
    private H2 title;
    private Span message;

    public IconDialog(LineAwesomeIcon icon, String title, String message) {
        // Icon
        this.icon = icon.create();

        this.iconLayout = new Layout(this.icon);
        this.iconLayout.addClassNames(Flex.SHRINK_NONE, "rounded-full");
        this.iconLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        this.iconLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        // Text
        this.title = new H2(title);
        this.title.addClassNames(FontSize.MEDIUM);

        this.message = new Span(message);
        this.message.addClassNames(FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        this.textLayout = new Layout(this.title, this.message);
        this.textLayout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        this.textLayout.setGap(Gap.SMALL);

        // Main layout
        this.layout = new Layout(this.iconLayout, this.textLayout);
        add(this.layout);

        // Footer
        Button ok = new Button("OK");
        ok.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button cancel = new Button("Cancel");

        getFooter().add(cancel, ok);

        // Defaults
        setIconPosition(Position.START);
        setIconTheme(Theme.PRIMARY);
    }

    public void setIconTheme(Theme theme) {
        switch (theme) {
            case PRIMARY:
                setIconBackgroundColor(BackgroundColor.PRIMARY_10);
                setIconTextColor(TextColor.PRIMARY);
                break;
            case SUCCESS:
                setIconBackgroundColor(BackgroundColor.SUCCESS_10);
                setIconTextColor(TextColor.SUCCESS);
                break;
            case ERROR:
                setIconBackgroundColor(BackgroundColor.ERROR_10);
                setIconTextColor(TextColor.ERROR);
                break;
        }
    }

    private void setIconBackgroundColor(BackgroundColor iconBackgroundColor) {
        if (this.iconBackgroundColor != null) this.iconLayout.removeClassNames(this.iconBackgroundColor.getClassName());
        this.iconLayout.addClassNames(iconBackgroundColor.getClassName());
        this.iconBackgroundColor = iconBackgroundColor;
    }

    private void setIconTextColor(TextColor iconTextColor) {
        if (this.iconTextColor != null) this.icon.removeClassNames(this.iconTextColor.getClassName());
        this.icon.addClassNames(iconTextColor.getClassName());
        this.iconTextColor = iconTextColor;
    }

    public void setIconPosition(Position position) {
        switch (position) {
            case START:
                setIconSize(Size.MEDIUM);
                this.textLayout.removeClassNames(TextAlignment.CENTER);
                this.layout.setAlignItems(FlexComponent.Alignment.START);
                this.layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
                this.layout.setGap(Gap.MEDIUM);
                break;
            case TOP:
                setIconSize(Size.LARGE);
                this.textLayout.addClassNames(TextAlignment.CENTER);
                this.layout.setAlignItems(FlexComponent.Alignment.CENTER);
                this.layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
                this.layout.setGap(Gap.LARGE);
                break;
        }
    }

    private void setIconSize(String size) {
        if (size.equals(Size.MEDIUM)) {
            this.icon.addClassNames(IconSize.SMALL);
            this.iconLayout.addClassNames(Height.MEDIUM, Width.MEDIUM);
            this.iconLayout.removeClassNames(Height.LARGE, Width.LARGE);

        } else if (size.equals(Size.LARGE)) {
            this.icon.addClassNames(IconSize.MEDIUM);
            this.iconLayout.addClassNames(Height.LARGE, Width.LARGE);
            this.iconLayout.removeClassNames(Height.MEDIUM, Width.MEDIUM);
        }
    }

    public enum Position {
        START, TOP
    }

    public enum Theme {
        PRIMARY, SUCCESS, ERROR
    }

}
