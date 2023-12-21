package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class Step extends ListItem implements AfterNavigationObserver, HasTheme {

    private RouterLink link;
    private Div circle;
    private Span label;
    private Span description;

    public Step(String label, String description, Class<? extends Component> navigationTarget) {
        addClassNames(Overflow.HIDDEN, Position.RELATIVE);

        this.circle = new Div();
        this.circle.addClassNames(AlignItems.CENTER, BoxSizing.BORDER, Display.FLEX, Flex.SHRINK_NONE, FontSize.SMALL,
                FontWeight.MEDIUM, Height.MEDIUM, JustifyContent.CENTER, "rounded-full", Width.MEDIUM);

        this.label = new Span(label);
        this.label.addClassNames(FontWeight.MEDIUM, TextColor.BODY);

        this.description = new Span(description);
        this.description.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Layout layout = new Layout(this.label, this.description);
        layout.addClassNames(Background.BASE, Padding.End.SMALL);
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setOverflow(com.example.application.utilities.Overflow.HIDDEN);

        this.link = new RouterLink();
        this.link.addClassNames(AlignItems.CENTER, Display.FLEX, Gap.MEDIUM, "no-underline", Padding.SMALL,
                Position.RELATIVE, "z-10");
        if (navigationTarget != null) {
            this.link.setRoute(navigationTarget);
        }
        this.link.add(this.circle, layout);
        add(this.link);

        setState(State.INACTIVE);
    }

    public Step(String label, Class<? extends Component> navigationTarget) {
        this(label, "", navigationTarget);
    }

    public Step(String label, String description) {
        this(label, description, null);
    }

    public Step(String label) {
        this(label, "", null);
    }

    public void setRoute(Router router, Class<? extends Component> navigationTarget) {
        this.link.setRoute(router, navigationTarget, RouteParameters.empty());
    }

    public void setState(State state) {
        this.circle.removeAll();
        this.circle.removeClassNames(getActiveClassNames());
        this.circle.removeClassNames(getCompleteClassNames());
        this.circle.removeClassNames(getErrorClassNames());
        this.circle.removeClassNames(getInactiveClassNames());

        this.label.removeClassNames(TextColor.PRIMARY, TextColor.SECONDARY, TextColor.ERROR);

        switch (state) {
            case ACTIVE -> {
                this.circle.addClassNames(getActiveClassNames());
                this.label.addClassName(TextColor.PRIMARY);
            }
            case COMPLETE -> {
                this.circle.add(LineAwesomeIcon.CHECK_SOLID.create());
                this.circle.addClassNames(getCompleteClassNames());
            }
            case ERROR -> {
                this.circle.add(LineAwesomeIcon.EXCLAMATION_SOLID.create());
                this.circle.addClassNames(getErrorClassNames());
                this.label.addClassName(TextColor.ERROR);
            }
            case INACTIVE -> {
                this.circle.addClassNames(getInactiveClassNames());
                this.label.addClassName(TextColor.SECONDARY);
            }
        }
    }

    public void setOrientation(Stepper.Orientation orientation) {
        if (orientation.equals(Stepper.Orientation.HORIZONTAL)) {
            this.label.addClassNames("lg:overflow-ellipsis", "lg:overflow-hidden", "lg:whitespace-nowrap");
            this.description.addClassNames("lg:overflow-ellipsis", "lg:overflow-hidden", "lg:whitespace-nowrap");
        } else {
            this.label.removeClassNames("lg:overflow-ellipsis", "lg:overflow-hidden", "lg:whitespace-nowrap");
            this.description.removeClassNames("lg:overflow-ellipsis", "lg:overflow-hidden", "lg:whitespace-nowrap");
        }
    }

    public void setSmall(boolean small) {
        this.link.addClassNames(getLinkClassNames(small));
        this.circle.addClassNames(getCircleClassNames(small));
        this.label.addClassNames(getLabelClassNames(small));
        this.description.addClassName(getDescriptionClassNames(small));

        this.link.removeClassNames(getLinkClassNames(!small));
        this.circle.removeClassNames(getCircleClassNames(!small));
        this.label.removeClassNames(getLabelClassNames(!small));
        this.description.removeClassName(getDescriptionClassNames(!small));
    }

    private String[] getActiveClassNames() {
        return new String[]{Background.BASE, Border.ALL, BorderColor.PRIMARY, "border-2", TextColor.PRIMARY};
    }

    private String[] getCompleteClassNames() {
        return new String[]{Background.PRIMARY, TextColor.PRIMARY_CONTRAST};
    }

    private String[] getErrorClassNames() {
        return new String[]{Background.ERROR, TextColor.ERROR_CONTRAST};
    }

    private String[] getInactiveClassNames() {
        return new String[]{Background.BASE, Border.ALL, BorderColor.CONTRAST_30, TextColor.SECONDARY};
    }

    private String getLinkClassNames(boolean small) {
        return !small ? Gap.MEDIUM : Gap.SMALL;
    }

    private String[] getCircleClassNames(boolean small) {
        return !small ?
                new String[]{FontSize.SMALL, Height.MEDIUM, Width.MEDIUM} :
                new String[]{FontSize.XSMALL, Height.XSMALL, Width.XSMALL};
    }

    private String getLabelClassNames(boolean small) {
        return !small ? FontSize.MEDIUM : FontSize.SMALL;
    }

    private String getDescriptionClassNames(boolean small) {
        return !small ? FontSize.SMALL : FontSize.XSMALL;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (this.link.getHref().equals(event.getLocation().getFirstSegment())) {
            this.link.getElement().setAttribute("aria-current", "step");
            setState(State.ACTIVE);
        } else {
            this.link.getElement().removeAttribute("aria-current");
        }
    }

    public enum State {
        ACTIVE,
        COMPLETE,
        ERROR,
        INACTIVE
    }
}
