package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class Step extends ListItem implements AfterNavigationObserver {

    private State state;
    private RouterLink link;
    private Div circle;
    private Span label;
    private Span description;

    public Step(String label, String description, Class<? extends Component> navigationTarget) {
        addClassNames(LumoUtility.Position.RELATIVE);

        this.circle = new Div();
        this.circle.addClassNames(
                LumoUtility.AlignItems.CENTER, LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX,
                LumoUtility.Flex.SHRINK_NONE, LumoUtility.FontSize.SMALL, LumoUtility.FontWeight.MEDIUM,
                LumoUtility.Height.MEDIUM, LumoUtility.JustifyContent.CENTER, "rounded-full",
                LumoUtility.Width.MEDIUM
        );

        this.label = new Span(label);
        this.label.addClassNames(LumoUtility.FontWeight.MEDIUM, LumoUtility.TextColor.BODY);

        this.description = new Span(description);
        this.description.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        Div div = new Div(this.label, this.description);
        div.addClassNames(LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN);

        this.link = new RouterLink();
        this.link.addClassNames(
                LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.Gap.MEDIUM,
                LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Padding.Vertical.SMALL,
                LumoUtility.Position.RELATIVE
        );
        if (navigationTarget != null) {
            this.link.setRoute(navigationTarget);
        }
        this.link.add(this.circle, div);
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

        this.label.removeClassNames(LumoUtility.TextColor.PRIMARY, LumoUtility.TextColor.SECONDARY, LumoUtility.TextColor.ERROR);

        switch (state) {
            case ACTIVE -> {
                this.circle.addClassNames(getActiveClassNames());
                this.label.addClassName(LumoUtility.TextColor.PRIMARY);
            }
            case COMPLETE -> {
                this.circle.add(LineAwesomeIcon.CHECK_SOLID.create());
                this.circle.addClassNames(getCompleteClassNames());
            }
            case ERROR -> {
                this.circle.add(LineAwesomeIcon.EXCLAMATION_SOLID.create());
                this.circle.addClassNames(getErrorClassNames());
                this.label.addClassName(LumoUtility.TextColor.ERROR);
            }
            case INACTIVE -> {
                this.circle.addClassNames(getInactiveClassNames());
                this.label.addClassName(LumoUtility.TextColor.SECONDARY);
            }
        }
    }

    private String[] getActiveClassNames() {
        return new String[]{
                LumoUtility.Background.BASE, LumoUtility.Border.ALL, LumoUtility.BorderColor.PRIMARY,
                LumoUtility.TextColor.PRIMARY
        };
    }

    private String[] getCompleteClassNames() {
        return new String[]{LumoUtility.Background.PRIMARY, LumoUtility.TextColor.PRIMARY_CONTRAST};
    }

    private String[] getErrorClassNames() {
        return new String[]{LumoUtility.Background.ERROR, LumoUtility.TextColor.ERROR_CONTRAST};
    }

    private String[] getInactiveClassNames() {
        return new String[]{
                LumoUtility.Background.BASE, LumoUtility.Border.ALL, LumoUtility.BorderColor.CONTRAST_30,
                LumoUtility.TextColor.SECONDARY
        };
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (this.link.getHref().equals(event.getLocation().getFirstSegment())) {
            setState(State.ACTIVE);
        }
    }

    public enum State {
        ACTIVE,
        COMPLETE,
        ERROR,
        INACTIVE
    }
}
