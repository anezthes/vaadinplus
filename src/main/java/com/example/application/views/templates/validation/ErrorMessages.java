package com.example.application.views.templates.validation;

import com.example.application.components.Layout;
import com.example.application.utilities.BorderColor;
import com.example.application.utilities.Gap;
import com.example.application.utilities.TextColor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.List;
import java.util.Optional;

public class ErrorMessages extends Layout implements HasTheme, Focusable<ErrorMessages> {

    private BorderColor borderColor;
    private Layout icon;
    private final Layout row;
    private final Layout column;
    private final Span title;
    private final Div description;
    private final Layout actions;

    public ErrorMessages(String title, Component description) {
        addClassNames("error-messages", Background.BASE, BorderRadius.MEDIUM, Padding.SMALL);
        setGap(Gap.SMALL);

        setBorderColor(BorderColor.ERROR_50);
        getElement().setAttribute("role", "group");
        getElement().setAttribute("aria-label", title);
        getStyle().set("background-image", "linear-gradient(var(--lumo-error-color-10pct), var(--lumo-error-color-10pct))");
        setIcon(LineAwesomeIcon.EXCLAMATION_CIRCLE_SOLID, TextColor.ERROR);
        setTabIndex(-1);

        this.title = new Span(title);
        this.title.addClassNames(FontWeight.SEMIBOLD);

        this.description = new Div(description);
        this.description.addClassNames(FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        this.column = new Layout(this.title, this.description);
        this.column.addClassNames(Margin.Vertical.XSMALL);
        this.column.setFlexDirection(FlexDirection.COLUMN);

        this.actions = new Layout();
        this.actions.setGap(Gap.SMALL);
        this.actions.setVisible(false);

        this.row = new Layout(this.column, this.actions);
        this.row.setFlexGrow(1, this.column);
        this.row.setFlexWrap(FlexWrap.WRAP);
        this.row.setGap(Gap.XSMALL);

        add(this.icon, this.row);
        setFlexGrow(1, this.row);
        // automatically get the focus
        focus();
    }

    /**
     * Applies a border around the notification.
     */
    public void setBorder(boolean border) {
        if (border) {
            addClassNames(Border.ALL);
        } else {
            removeClassNames(Border.ALL);
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
     * Sets the icon.
     */
    public void setIcon(LineAwesomeIcon icon, TextColor color) {
        SvgIcon i = icon.create();
        i.addClassNames(IconSize.SMALL);

        this.icon = new Layout(i);
        this.icon.addClassNames(color.getClassName(), Flex.SHRINK_NONE, Height.XSMALL, Margin.Top.XSMALL,
                Margin.Start.XSMALL, Width.XSMALL);
        this.icon.setAlignItems(Alignment.CENTER);
        this.icon.setJustifyContentMode(JustifyContentMode.CENTER);
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
                    if (component instanceof Button button) {
                        button.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    }
                    this.actions.add(component);
                }
            }
        }
        this.actions.setVisible(this.actions.getComponentCount() > 0);
    }

    public static Optional<ErrorMessages> createErrorNotification(BinderValidationStatus<?> binderValidationStatus) {
        List<BindingValidationStatus<?>> fieldValidationErrors = binderValidationStatus.getFieldValidationErrors();
        List<ValidationResult> beanValidationErrors = binderValidationStatus.getBeanValidationErrors();
        final OrderedList list = new OrderedList();
        for (BindingValidationStatus<?> fieldValidationError : fieldValidationErrors) {
            fieldValidationError.getMessage().ifPresent(errorMessage -> {
                if (fieldValidationError.getField() instanceof Focusable<?> focusableField) {
                    NativeButton nativeButton = new NativeButton(errorMessage, e -> focusableField.focus());
                    nativeButton.addClassName("error-messages__button");
                    list.add(new ListItem(nativeButton));
                } else {
                    list.add(new ListItem(errorMessage));
                }
            });
        }

        var beanValidationErrorsStream = beanValidationErrors.stream().filter(ValidationResult::isError)
                .map(ValidationResult::getErrorMessage);
        beanValidationErrorsStream.forEach(errorMessage -> {
            list.add(new ListItem(errorMessage));
        });
        long count = list.getChildren().count();
        if (count > 0) {
            list.addClassNames(LumoUtility.Margin.NONE, LumoUtility.Padding.Start.MEDIUM);
            return Optional.of(new ErrorMessages(String.format("There are %d errors:", count), list));
        } else {
            return Optional.empty();
        }
    }
}
