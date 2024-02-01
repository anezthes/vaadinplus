package com.example.application.views.templates.validation;

import com.example.application.components.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ErrorMessages extends Layout implements HasTheme, Focusable<ErrorMessages> {

    public ErrorMessages(String title, ListItem... items) {
        addClassNames(Background.ERROR_10, BorderRadius.MEDIUM, Gap.SMALL, Padding.SMALL);
        getElement().setAttribute("aria-label", title);
        getElement().setAttribute("role", "group");
        setTabIndex(-1);

        H3 heading = new H3(title);
        heading.addClassNames(FontSize.MEDIUM, LineHeight.MEDIUM);

        OrderedList list = new OrderedList(items);
        list.addClassNames(FontSize.SMALL, Margin.NONE, Padding.Start.MEDIUM, TextColor.SECONDARY);

        Layout content = new Layout(heading, list);
        content.addClassNames(Margin.Vertical.XSMALL);
        content.setFlexDirection(FlexDirection.COLUMN);

        add(createIcon(), content);

        // Automatically get the focus
        focus();
    }

    public static Optional<ErrorMessages> createErrorNotification(BinderValidationStatus<?> binderValidationStatus) {
        List<BindingValidationStatus<?>> fieldValidationErrors = binderValidationStatus.getFieldValidationErrors();
        List<ValidationResult> beanValidationErrors = binderValidationStatus.getBeanValidationErrors();

        ArrayList<ListItem> items = new ArrayList();

        for (BindingValidationStatus<?> fieldValidationError : fieldValidationErrors) {
            fieldValidationError.getMessage().ifPresent(errorMessage -> {
                if (fieldValidationError.getField() instanceof Component component) {
                    // TODO: Get current URL
                    AtomicReference<String> href = null;
                    UI.getCurrent().getPage().fetchCurrentURL(url -> href.set(url.getPath()));

                    Anchor anchor = new Anchor("#" + component.getId().get(), errorMessage);
                    anchor.addClassNames(LumoUtility.TextColor.SECONDARY);
                    items.add(new ListItem(anchor));
                } else {
                    items.add(new ListItem(errorMessage));
                }
            });
        }

        var beanValidationErrorsStream = beanValidationErrors.stream().filter(ValidationResult::isError)
                .map(ValidationResult::getErrorMessage);
        beanValidationErrorsStream.forEach(errorMessage -> items.add(new ListItem(errorMessage)));

        if (items.size() > 0) {
            return Optional.of(new ErrorMessages(String.format("There are %d errors:", items.size()),
                    items.toArray(new ListItem[0])));
        } else {
            return Optional.empty();
        }
    }

    private Component createIcon() {
        SvgIcon svgIcon = LineAwesomeIcon.EXCLAMATION_CIRCLE_SOLID.create();
        svgIcon.addClassNames(IconSize.SMALL);

        Div icon = new Div(svgIcon);
        icon.addClassNames(AlignItems.CENTER, Display.FLEX, Flex.SHRINK_NONE, Height.XSMALL, JustifyContent.CENTER,
                Margin.Top.XSMALL, Margin.Start.XSMALL, TextColor.ERROR, Width.XSMALL);
        return icon;
    }
}
