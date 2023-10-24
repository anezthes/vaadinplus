package com.example.application.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasEnabled;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class Sidebar extends Section implements HasEnabled {

    private Header header;
    private H2 title;
    private Span description;

    private FlexLayout content;

    private Footer footer;
    private Button save;
    private Button cancel;

    public Sidebar(String title, String description, Component... components) {
        addClassNames(
                LumoUtility.Background.BASE, LumoUtility.BoxShadow.MEDIUM, LumoUtility.Display.FLEX,
                LumoUtility.FlexDirection.COLUMN, LumoUtility.Overflow.HIDDEN, LumoUtility.Position.FIXED,
                "bottom-0", "top-0", "transition-all", "z-10"
        );
        setMaxWidth(100, Unit.PERCENTAGE);
        setWidth(480, Unit.PIXELS);

        createHeader(title, description);
        createContent(components);
        createFooter();

        close();
    }

    private void createHeader(String title, String description) {
        this.title = new H2(title);
        this.title.addClassNames(LumoUtility.FontSize.XLARGE);

        this.description = new Span(description);
        this.description.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        FlexLayout layout = new FlexLayout(this.title, this.description);
        layout.addClassNames(LumoUtility.Gap.SMALL);
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        Button close = new Button(LineAwesomeIcon.TIMES_SOLID.create(), e -> close());
        close.addClassNames(LumoUtility.Margin.NONE);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close sidebar");
        close.setTooltipText("Close sidebar");

        this.header = new Header(layout, close);
        this.header.addClassNames(
                LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10, LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.BETWEEN, LumoUtility.Padding.End.MEDIUM, LumoUtility.Padding.Start.LARGE,
                LumoUtility.Padding.Vertical.MEDIUM
        );
        add(this.header);
    }

    private void createContent(Component... components) {
        this.content = new FlexLayout(components);
        this.content.addClassNames(
                LumoUtility.Flex.GROW, LumoUtility.Padding.Bottom.MEDIUM, LumoUtility.Padding.Horizontal.LARGE,
                LumoUtility.Padding.Top.SMALL
        );
        this.content.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        add(this.content);
    }

    private void createFooter() {
        this.save = new Button("Save");
        this.save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        this.cancel = new Button("Cancel");

        this.footer = new Footer(this.cancel, this.save);
        this.footer.addClassNames(
                LumoUtility.Background.CONTRAST_5, LumoUtility.Display.FLEX, LumoUtility.Gap.SMALL,
                LumoUtility.JustifyContent.END, LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Padding.Vertical.SMALL
        );
        add(this.footer);
    }

    public void close() {
        addClassNames("-end-full");
        removeClassName("end-0");
        setEnabled(false);
    }

    public void open() {
        addClassNames("end-0");
        removeClassNames("-end-full");
        setEnabled(true);
    }

    public void addHeaderTheme(String theme) {
        this.header.getElement().getThemeList().add(theme);
    }

    public void removeHeaderTheme(String theme) {
        this.header.getElement().getThemeList().remove(theme);
    }
}
