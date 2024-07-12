package com.example.application.views.templates.validation;

import com.example.application.components.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasAriaLabel;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ErrorSummary extends Layout implements HasAriaLabel, HasTheme, Focusable<ErrorSummary> {

    public ErrorSummary(String title, ListItem... items) {
        addClassNames(Background.ERROR_10, BorderRadius.MEDIUM, Padding.SMALL);
        getElement().setAttribute("role", "group");
        setAriaLabelledBy(formatId(title));
        setGap(Gap.SMALL);
        setTabIndex(-1);

        H3 heading = new H3(title);
        heading.addClassNames(FontSize.MEDIUM, LineHeight.MEDIUM);
        heading.setId(formatId(title));

        OrderedList list = new OrderedList(items);
        list.addClassNames(FontSize.SMALL, Margin.Vertical.NONE, Padding.Start.MEDIUM);

        Layout content = new Layout(heading, list);
        content.addClassNames(Margin.Vertical.XSMALL);
        content.setFlexDirection(FlexDirection.COLUMN);

        add(createIcon(), content);

        // Automatically get the focus
        focus();
    }

    public static Optional<ErrorSummary> createErrorNotification(BinderValidationStatus<?> binderValidationStatus) {
        List<BindingValidationStatus<?>> fieldValidationErrors = binderValidationStatus.getFieldValidationErrors();
        List<ValidationResult> beanValidationErrors = binderValidationStatus.getBeanValidationErrors();

        ArrayList<ListItem> items = new ArrayList();

        for (BindingValidationStatus<?> fieldValidationError : fieldValidationErrors) {
            fieldValidationError.getMessage().ifPresent(errorMessage -> {
                if (fieldValidationError.getField() instanceof Focusable<?> field) {
                    // TODO: Use anchors instead of buttons
                    /* AtomicReference<String> href = null;
                    UI.getCurrent().getPage().fetchCurrentURL(url -> href.set(url.getPath()));
                    Anchor anchor = new Anchor("#" + component.getId().get(), errorMessage);
                    anchor.addClassNames(LumoUtility.TextColor.SECONDARY); */
                    Button button = new Button(errorMessage, e -> field.focus());
                    button.addClassNames(TextColor.SECONDARY);
                    button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
                    items.add(new ListItem(button));
                } else {
                    items.add(new ListItem(errorMessage));
                }
            });
        }

        var beanValidationErrorsStream = beanValidationErrors.stream().filter(ValidationResult::isError)
                .map(ValidationResult::getErrorMessage);
        beanValidationErrorsStream.forEach(errorMessage -> items.add(new ListItem(errorMessage)));

        if (items.size() > 0) {
            return Optional.of(new ErrorSummary(String.format("There are %d errors:", items.size()),
                    items.toArray(new ListItem[0])));
        } else {
            return Optional.empty();
        }
    }

    private String formatId(String id) {
        return id.replace(" ", "-").toLowerCase();
    }

    private Component createIcon() {
        SvgIcon svgIcon = LineAwesomeIcon.EXCLAMATION_CIRCLE_SOLID.create();
        svgIcon.addClassNames(IconSize.SMALL);

        Layout icon = new Layout(svgIcon);
        icon.addClassNames(Flex.SHRINK_NONE, Height.XSMALL, Margin.Top.XSMALL, Margin.Start.XSMALL, TextColor.ERROR,
                Width.XSMALL);
        icon.setAlignItems(AlignItems.CENTER);
        icon.setJustifyContent(JustifyContent.CENTER);
        return icon;
    }
}
