package com.example.application.components;

import com.example.application.utilities.Color;
import com.example.application.utilities.Size;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class IconDialog extends Dialog {

    private Layout layout;
    private Layout iconLayout;
    private Color.Background background;
    private Color.Text color;
    private SvgIcon icon;
    private Layout textLayout;
    private H2 title;
    private Span message;

    public IconDialog(LineAwesomeIcon icon, String title, String message) {
        // Icon
        this.icon = icon.create();

        this.iconLayout = new Layout(this.icon);
        this.iconLayout.addClassNames(Flex.SHRINK_NONE, "rounded-full");
        this.iconLayout.setAlignItems(Layout.AlignItems.CENTER);
        this.iconLayout.setJustifyContent(Layout.JustifyContent.CENTER);

        // Text
        this.title = new H2(title);
        this.title.addClassNames(FontSize.MEDIUM);

        this.message = new Span(message);
        this.message.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        this.textLayout = new Layout(this.title, this.message);
        this.textLayout.setFlexDirection(Layout.FlexDirection.COLUMN);
        this.textLayout.setGap(Layout.Gap.SMALL);

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
                setIconBackgroundColor(Color.Background.PRIMARY_10);
                setIconTextColor(Color.Text.PRIMARY);
                break;
            case SUCCESS:
                setIconBackgroundColor(Color.Background.SUCCESS_10);
                setIconTextColor(Color.Text.SUCCESS);
                break;
            case ERROR:
                setIconBackgroundColor(Color.Background.ERROR_10);
                setIconTextColor(Color.Text.ERROR);
                break;
        }
    }

    private void setIconBackgroundColor(Color.Background background) {
        if (this.background != null) this.iconLayout.removeClassNames(this.background.getClassName());
        this.iconLayout.addClassNames(background.getClassName());
        this.background = background;
    }

    private void setIconTextColor(Color.Text color) {
        if (this.color != null) this.icon.removeClassNames(this.color.getClassName());
        this.icon.addClassNames(color.getClassName());
        this.color = color;
    }

    public void setIconPosition(Position position) {
        switch (position) {
            case START:
                setIconSize(Size.MEDIUM);
                this.textLayout.removeClassNames(TextAlignment.CENTER);
                this.layout.setAlignItems(Layout.AlignItems.START);
                this.layout.setFlexDirection(Layout.FlexDirection.ROW);
                this.layout.setGap(Layout.Gap.MEDIUM);
                break;
            case TOP:
                setIconSize(Size.LARGE);
                this.textLayout.addClassNames(TextAlignment.CENTER);
                this.layout.setAlignItems(Layout.AlignItems.CENTER);
                this.layout.setFlexDirection(Layout.FlexDirection.COLUMN);
                this.layout.setGap(Layout.Gap.LARGE);
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
