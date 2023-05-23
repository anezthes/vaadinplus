package com.example.application.components;

import com.example.application.utilities.BorderColor;
import com.example.application.utilities.Gap;
import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;

// TODO: Needs a new name to avoid clashing with the default.
public class Notification extends Layout implements HasTheme {

    private BorderColor borderColor;

    private Type type;
    private Icon icon;
    private Layout row;
    private Layout column;
    private Span title;
    private Div description;
    private Layout actions;

    public Notification(String title, String description) {
        this(title, new Text(description), Type.INFO);
    }

    public Notification(String title, String description, Type type) {
        this(title, new Text(description), type);
    }

    public Notification(String title, Component description) {
        this(title, description, Type.INFO);
    }

    public Notification(String title, Component description, Type type) {
        addClassNames(
                "notification", LumoUtility.Background.BASE, LumoUtility.BorderRadius.MEDIUM,
                LumoUtility.Padding.SMALL
        );
        setGap(Gap.SMALL);
        setType(type);

        this.title = new Span(title);
        this.title.addClassNames(LumoUtility.FontWeight.SEMIBOLD);

        this.description = new Div(description);
        this.description.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        this.column = new Layout(this.title, this.description);
        this.column.addClassNames(LumoUtility.Margin.Vertical.XSMALL);
        this.column.setFlexDirection(FlexDirection.COLUMN);

        this.actions = new Layout();
        this.actions.setGap(Gap.SMALL);
        setActions(null);

        this.row = new Layout(this.column, this.actions);
        this.row.setFlexGrow(1, this.column);
        this.row.setFlexWrap(FlexWrap.WRAP);
        this.row.setGap(Gap.XSMALL);

        add(this.icon, this.row);
        setFlexGrow(1, this.row);
    }

    /**
     * Applies a border around the notification.
     */
    public void setBorder(boolean border) {
        if (border) {
            addClassNames(LumoUtility.Border.ALL);
        } else {
            removeClassNames(LumoUtility.Border.ALL);
        }
    }

    /**
     * Applies a left (LTR) or right (RTL) border on the notification.
     * TODO: Needs a better name.
     */
    public void setAccentBorder(boolean border) {
        if (border) {
            getStyle().set("border-inline-start-style", "solid");
            getStyle().set("border-inline-start-width", "var(--lumo-space-xs)");
            this.icon.removeClassName(LumoUtility.Margin.Start.XSMALL);
        } else {
            getStyle().remove("border-inline-start-style");
            getStyle().remove("border-inline-start-width");
            this.icon.addClassName(LumoUtility.Margin.Start.XSMALL);
        }
    }

    /**
     * Sets the border color.
     */
    private void setBorderColor(BorderColor borderColor) {
        if (this.borderColor != null) {
            removeClassNames(this.borderColor.getClassName());
        }
        addClassNames(borderColor.getClassName());
        this.borderColor = borderColor;
    }

    /**
     * Sets the text color.
     */
    public void setTextColor(TextColor color) {
        this.description.removeClassName(LumoUtility.TextColor.SECONDARY);

        this.title.addClassNames(color.getClassName());
        this.description.addClassNames(color.getClassName());
    }

    /**
     * Sets the type (info, success or error).
     */
    private void setType(Type type) {
        this.type = type;
        switch (type) {
            case INFO:
            default:
                setBorderColor(BorderColor.PRIMARY_50);
                getElement().setAttribute("role", "status");
                getStyle().set("background-image", "linear-gradient(var(--lumo-primary-color-10pct), var(--lumo-primary-color-10pct))");
                setIcon(VaadinIcon.INFO_CIRCLE, TextColor.PRIMARY);
                break;
            case SUCCESS:
                setBorderColor(BorderColor.SUCCESS_50);
                getElement().setAttribute("role", "status");
                getStyle().set("background-image", "linear-gradient(var(--lumo-success-color-10pct), var(--lumo-success-color-10pct))");
                setIcon(VaadinIcon.CHECK_CIRCLE, TextColor.SUCCESS);
                break;
            case ERROR:
                setBorderColor(BorderColor.ERROR_50);
                getElement().setAttribute("role", "alert");
                getStyle().set("background-image", "linear-gradient(var(--lumo-error-color-10pct), var(--lumo-error-color-10pct))");
                setIcon(VaadinIcon.EXCLAMATION_CIRCLE, TextColor.ERROR);
                break;
        }
    }

    /**
     * Sets the icon.
     */
    public void setIcon(VaadinIcon icon, TextColor color) {
        this.icon = icon.create();
        this.icon.addClassNames(
                color.getClassName(), LumoUtility.Flex.SHRINK_NONE, LumoUtility.Margin.Top.XSMALL,
                LumoUtility.Margin.Start.XSMALL, LumoUtility.Padding.XSMALL
        );
    }

    /**
     * Sets the title.
     */
    public void setTitle(String text) {
        this.title.setText(text);
    }

    /**
     * Sets the description.
     */
    public void setDescription(Component... components) {
        this.description.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.description.add(component);
                }
            }
        }
        this.description.setVisible(this.description.getComponentCount() > 0);
    }

    /**
     * Sets the actions.
     */
    public void setActions(Component... components) {
        this.actions.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    if (component instanceof Button) {
                        themeButton((Button) component);
                    }
                    this.actions.add(component);
                }
            }
        }
        this.actions.setVisible(this.actions.getComponentCount() > 0);
    }

    private void themeButton(Button button) {
        if (this.type.equals(Notification.Type.SUCCESS)) {
            button.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        } else if (this.type.equals(Notification.Type.ERROR)) {
            button.addThemeVariants(ButtonVariant.LUMO_ERROR);
        }
    }

    public enum Type {
        INFO, SUCCESS, ERROR
    }
}
