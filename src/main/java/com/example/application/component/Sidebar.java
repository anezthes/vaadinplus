package com.example.application.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasEnabled;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class Sidebar extends Section implements HasEnabled, HasTheme {

    private Header header;
    private Layout content;
    private Footer footer;

    public Sidebar(String title, Component... components) {
        this(title, null, components);
    }

    public Sidebar(String title, String description, Component... components) {
        addClassNames(Background.BASE, BoxShadow.MEDIUM, Display.FLEX, FlexDirection.COLUMN, Overflow.HIDDEN,
                Position.FIXED, Position.Bottom.NONE, Position.End.NONE, Position.Top.NONE, Transition.ALL, ZIndex.XSMALL);
        setMaxWidth(100, Unit.PERCENTAGE);
        setWidth(480, Unit.PIXELS);

        createHeader(title, description);
        createContent(components);
        createFooter();

        close();
    }

    private void createHeader(String title, String description) {
        H2 h2 = new H2(title);
        h2.addClassNames(FontSize.XLARGE);

        Layout layout = new Layout(h2);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        layout.setGap(Layout.Gap.SMALL);

        if (description != null) {
            layout.add(new Span(description, FontSize.SMALL, TextColor.SECONDARY));
        }

        Button close = new Button(LineAwesomeIcon.TIMES_SOLID.create(), e -> close());
        close.addClassNames(Margin.Vertical.NONE);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close sidebar");
        close.setTooltipText("Close sidebar");

        this.header = new Header(layout, close);
        this.header.addClassNames(Border.BOTTOM, Display.FLEX, JustifyContent.BETWEEN,
                Padding.End.MEDIUM, Padding.Start.LARGE, Padding.Vertical.MEDIUM);

        if (description == null) {
            this.header.addClassNames(AlignItems.CENTER);
        }

        add(this.header);
    }

    private void createContent(Component... components) {
        this.content = new Layout(components);
        this.content.addClassNames(Flex.GROW, Padding.Bottom.MEDIUM, Padding.Horizontal.LARGE, Padding.Top.SMALL);
        this.content.setFlexDirection(Layout.FlexDirection.COLUMN);
        add(this.content);
    }

    private void createFooter() {
        Button save = new Button("Save");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button cancel = new Button("Cancel");

        this.footer = new Footer(cancel, save);
        this.footer.addClassNames(Background.CONTRAST_5, Display.FLEX, Gap.SMALL, JustifyContent.END,
                Padding.Horizontal.MEDIUM, Padding.Vertical.SMALL);
        add(this.footer);
    }

    // TODO: Refocus the component that opened the sidebar after closing
    public void close() {
        getStyle().set("translate", "100%");
        setEnabled(false);
        getElement().setAttribute("inert", true);
    }

    public void open() {
        getStyle().set("translate", "0");
        setEnabled(true);
        getElement().removeAttribute("inert");
    }

    public void addHeaderThemeName(String theme) {
        this.header.getElement().getThemeList().add(theme);
    }

    public void removeHeaderThemeName(String theme) {
        this.header.getElement().getThemeList().remove(theme);
    }

    public Layout getContent() {
        return this.content;
    }

    public Footer getFooter() {
        return this.footer;
    }
}
