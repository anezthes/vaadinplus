package com.example.application.component;

import com.example.application.utility.Color;
import com.example.application.utility.Size;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.theme.lumo.LumoUtility.*;


public class IconDialog extends Dialog {

    private final Layout layout;
    private final Layout iconLayout;
    private final Span icon;
    private final Layout textLayout;
    private Color.Background background;
    private Color.Text color;

    public IconDialog(MaterialSymbol symbol, String title, String message) {
        // Icon
        this.icon = symbol.create();

        this.iconLayout = new Layout(this.icon);
        this.iconLayout.addClassNames(BorderRadius.FULL, Flex.SHRINK_NONE);
        this.iconLayout.setAlignItems(Layout.AlignItems.CENTER);
        this.iconLayout.setJustifyContent(Layout.JustifyContent.CENTER);

        // Text
        H2 h2 = new H2(title);
        h2.addClassNames(FontSize.MEDIUM);

        this.textLayout = new Layout(h2, new Span(message, FontSize.SMALL, TextColor.SECONDARY));
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
