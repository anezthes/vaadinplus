package com.example.application.views;

import com.example.application.components.Header;
import com.example.application.components.Tag;
import com.example.application.utilities.FontSize;
import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Headers")
@Route(value = "headers", layout = MainLayout.class)
public class HeadersView extends View {

    public HeadersView() {
        addH2("Basic");
        Header header = new Header("Lorem ipsum", HeadingLevel.H3);
        add(header);

        addH2("Prefix");
        header = new Header("Lorem ipsum", HeadingLevel.H3);
        header.setPrefix(createBackButton());
        add(header);

        addH2("Breadcrumb");
        header = new Header("Lorem ipsum", HeadingLevel.H3);
        header.setBreadcrumb(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Headers", HeadersView.class)
        );
        add(header);

        addH2("Details");
        header = new Header("Lorem ipsum", HeadingLevel.H3);
        header.setDetails(
                new Tag(LineAwesomeIcon.TOOTH_SOLID, "Dolor sit"),
                new Tag(LineAwesomeIcon.PAPER_PLANE, "Amet consectetur"),
                new Tag(LineAwesomeIcon.THUMBS_UP, "Adipiscing elit")
        );
        add(header);

        addH2("Tabs");
        header = new Header("Lorem ipsum", HeadingLevel.H3);
        header.setTabs(new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"));
        add(header);

        addH2("Actions");
        header = new Header("Lorem ipsum", HeadingLevel.H3);
        Button button = new Button("Button");
        Button primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        header.setActions(button, primaryButton);
        add(header);

        addH2("Breadcrumb, Details, Tabs & Actions");
        header = new Header("Lorem ipsum", HeadingLevel.H3);
        header.setBreadcrumb(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Headers", HeadersView.class)
        );
        header.setDetails(
                new Tag(LineAwesomeIcon.TOOTH_SOLID, "Dolor sit"),
                new Tag(LineAwesomeIcon.PAPER_PLANE, "Amet consectetur"),
                new Tag(LineAwesomeIcon.THUMBS_UP, "Adipiscing elit")
        );
        header.setTabs(new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"));
        button = new Button("Button");
        primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        header.setActions(button, primaryButton);
        add(header);

        addH2("Example: User");
        createUserExample();
    }

    private RouterLink createBackButton() {
        Component icon = LineAwesomeIcon.ARROW_LEFT_SOLID.create();
        icon.addClassNames(LumoUtility.BoxSizing.BORDER);
        ((HasSize) icon).setHeight("var(--lumo-size-m)");
        ((HasSize) icon).setWidth("var(--lumo-size-m)");

        RouterLink link = new RouterLink();
        link.add(icon);
        link.setRoute(HomeView.class);
        return link;
    }

    private void createUserExample() {
        Avatar avatar = new Avatar("John Smith");

        Span details = new Span("john.smith@company.com");
        details.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        Button button = new Button("Edit", LineAwesomeIcon.EDIT.create());

        Header header = new Header("John Smith", HeadingLevel.H3);
        header.setPrefix(avatar);
        header.getColumnLayout().removeGap();
        header.setHeadingFontSize(FontSize.LARGE);
        header.setDetails(details);
        header.setActions(button);
        add(header);
    }

}
