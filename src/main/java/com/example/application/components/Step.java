package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class Step extends ListItem implements AfterNavigationObserver, HasTheme {

    private Stepper.Orientation orientation;
    private boolean small;
    private State state;
    private RouterLink link;
    private Div circle;
    private Div layout;
    private Span label;
    private Span description;

    public Step(String label, String description, Class<? extends Component> navigationTarget) {
        addClassNames(MinWidth.NONE, Position.RELATIVE);

        this.circle = new Div();
        this.label = new Span(label);
        this.description = new Span(description);

        this.layout = new Div(this.label, this.description);
        this.layout.addClassNames(Display.FLEX, FlexDirection.COLUMN, Overflow.HIDDEN);

        this.link = new RouterLink();
        this.link.add(this.circle, layout);
        if (navigationTarget != null) this.link.setRoute(navigationTarget);
        add(this.link);

        setState(State.INACTIVE);
    }

    public Step(String label, Class<? extends Component> navigationTarget) {
        this(label, "", navigationTarget);
    }

    public void setOrientation(Stepper.Orientation orientation) {
        this.orientation = orientation;
        updateClassNames();
    }

    public void setSmall(boolean small) {
        this.small = small;
        updateClassNames();
    }

    public void setState(State state) {
        this.state = state;
        updateClassNames();
    }

    private void updateClassNames() {
        updateLinkClassNames();
        updateCircleIcon();
        updateCircleClassNames();
        updateLabelClassNames();
        updateDescriptionClassNames();
    }

    private void updateLinkClassNames() {
        this.link.getClassNames().clear();
        this.link.addClassNames(AlignItems.CENTER, Display.FLEX, "no-underline", Padding.SMALL);

        if (this.small) {
            this.link.addClassNames(Gap.SMALL);
        } else {
            this.link.addClassNames(Gap.MEDIUM);
        }
    }

    private void updateCircleIcon() {
        this.circle.removeAll();

        switch (this.state) {
            case COMPLETE -> this.circle.add(LineAwesomeIcon.CHECK_SOLID.create());
            case ERROR -> this.circle.add(LineAwesomeIcon.EXCLAMATION_SOLID.create());
        }
    }

    private void updateCircleClassNames() {
        this.circle.getClassNames().clear();
        this.circle.addClassNames(AlignItems.CENTER, Border.ALL, BoxSizing.BORDER, Display.FLEX, Flex.SHRINK_NONE,
                FontWeight.MEDIUM, JustifyContent.CENTER, "rounded-full");

        if (this.small) {
            this.circle.addClassNames(FontSize.XSMALL, Height.XSMALL, Width.XSMALL);
        } else {
            this.circle.addClassNames(FontSize.SMALL, Height.MEDIUM, Width.MEDIUM);
        }

        switch (this.state) {
            case ACTIVE ->
                    this.circle.addClassNames(Background.BASE, BorderColor.PRIMARY, "border-2", TextColor.PRIMARY);
            case COMPLETE ->
                    this.circle.addClassNames(Background.PRIMARY, BorderColor.PRIMARY, TextColor.PRIMARY_CONTRAST);
            case ERROR -> this.circle.addClassNames(Background.ERROR, BorderColor.ERROR, TextColor.ERROR_CONTRAST);
            case INACTIVE -> this.circle.addClassNames(Background.BASE, BorderColor.CONTRAST_30, TextColor.SECONDARY);
        }
    }

    private void updateLabelClassNames() {
        this.label.getClassNames().clear();
        this.label.addClassNames(FontWeight.MEDIUM);

        if (this.orientation != null && this.orientation.equals(Stepper.Orientation.HORIZONTAL)) {
            this.label.addClassNames("lg:overflow-ellipsis", "lg:overflow-hidden", "lg:whitespace-nowrap");
        }

        if (this.small) {
            this.label.addClassNames(FontSize.SMALL);
        }

        switch (state) {
            case ACTIVE -> this.label.addClassName(TextColor.PRIMARY);
            case COMPLETE -> this.label.addClassName(TextColor.BODY);
            case ERROR -> this.label.addClassName(TextColor.ERROR);
            case INACTIVE -> this.label.addClassName(TextColor.SECONDARY);
        }
    }

    private void updateDescriptionClassNames() {
        this.description.getClassNames().clear();
        this.description.addClassNames(TextColor.SECONDARY);

        if (this.orientation != null && this.orientation.equals(Stepper.Orientation.HORIZONTAL)) {
            this.description.addClassNames("lg:overflow-ellipsis", "lg:overflow-hidden", "lg:whitespace-nowrap");
        }

        if (this.small) {
            this.description.addClassNames(FontSize.XSMALL);
        } else {
            this.description.addClassNames(FontSize.SMALL);
        }
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (this.link.getHref().equals(event.getLocation().getPath())) {
            this.link.getElement().setAttribute("aria-current", "step");
            setState(State.ACTIVE);
        } else {
            this.link.getElement().removeAttribute("aria-current");
            // TODO: Check if COMPLETE, ERROR, etc.
            setState(State.INACTIVE);
        }
    }

    public enum State {
        ACTIVE,
        COMPLETE,
        ERROR,
        INACTIVE
    }
}
