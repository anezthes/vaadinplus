package com.example.application.views.components;

import com.example.application.components.BreadcrumbItem;
import com.example.application.components.Header;
import com.example.application.components.Tag;
import com.example.application.utilities.Font;
import com.example.application.utilities.HeadingLevel;
import com.example.application.views.HomeView;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Headers")
@Route(value = "headers", layout = MainLayout.class)
public class HeadersView extends ComponentView {

    public HeadersView() {
        addH2("Basic");
        addPreview(createHeader());

        addH2("Prefix");
        addPreview(createHeaderWithPrefix());

        addH2("Breadcrumb");
        addPreview(createHeaderWithBreadcrumb());

        addH2("Details");
        addPreview(createHeaderWithDetails());

        addH2("Tabs");
        addPreview(createHeaderWithTabs());

        addH2("Actions");
        addPreview(createHeaderWithActions());

        addH2("Breadcrumb, details, tabs & actions");
        addPreview(createHeaderWithAllTheThings());

        addH2("Example: user");
        addPreview(createUserExample());
    }

    private Header createHeader() {
        return new Header("Lorem ipsum", HeadingLevel.H3);
    }

    private Header createHeaderWithPrefix() {
        Header header = createHeader();
        header.setPrefix(createBackButton());
        return header;
    }

    private Header createHeaderWithBreadcrumb() {
        Header header = createHeader();
        header.setBreadcrumb(
                new BreadcrumbItem("Home", HomeView.class),
                new BreadcrumbItem("Headers", HeadersView.class)
        );
        return header;
    }

    private Header createHeaderWithDetails() {
        Header header = createHeader();
        header.setDetails(
                new Tag(LineAwesomeIcon.TOOTH_SOLID, "Dolor sit"),
                new Tag(LineAwesomeIcon.PAPER_PLANE, "Amet consectetur"),
                new Tag(LineAwesomeIcon.THUMBS_UP, "Adipiscing elit")
        );
        return header;
    }

    private Header createHeaderWithTabs() {
        Header header = createHeader();
        header.setTabs(new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"));
        return header;
    }

    private Header createHeaderWithActions() {
        Button button = new Button("Button");

        Button primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Header header = createHeader();
        header.setActions(button, primaryButton);
        return header;
    }

    private Header createHeaderWithAllTheThings() {
        Button button = new Button("Button");

        Button primaryButton = new Button("Button");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Header header = createHeader();
        header.setBreadcrumb(
                new BreadcrumbItem("Home", HomeView.class),
                new BreadcrumbItem("Headers", HeadersView.class)
        );
        header.setDetails(
                new Tag(LineAwesomeIcon.TOOTH_SOLID, "Dolor sit"),
                new Tag(LineAwesomeIcon.PAPER_PLANE, "Amet consectetur"),
                new Tag(LineAwesomeIcon.THUMBS_UP, "Adipiscing elit")
        );
        header.setTabs(new Tab("Tab 1"), new Tab("Tab 2"), new Tab("Tab 3"));
        header.setActions(button, primaryButton);
        return header;
    }

    private RouterLink createBackButton() {
        SvgIcon icon = LineAwesomeIcon.ARROW_LEFT_SOLID.create();
        icon.addClassNames(IconSize.MEDIUM);

        RouterLink link = new RouterLink("", HomeView.class);
        link.add(icon);
        link.addClassNames(AlignItems.CENTER, Display.FLEX, Height.MEDIUM, JustifyContent.CENTER, Width.MEDIUM);
        link.getElement().setAttribute("aria-label", "Home");
        link.getElement().setAttribute("title", "Home");
        return link;
    }

    private Header createUserExample() {
        Avatar avatar = new Avatar("John Smith");

        Span details = new Span("john.smith@company.com");
        details.addClassNames(LumoUtility.FontSize.SMALL, TextColor.SECONDARY);

        Button button = new Button("Edit", LineAwesomeIcon.EDIT.create());

        Header header = new Header("John Smith", HeadingLevel.H3);
        header.getColumnLayout().removeGap();
        header.setActions(button);
        header.setDetails(details);
        header.setHeadingFontSize(Font.Size.LARGE);
        header.setPrefix(avatar);
        return header;
    }

}
