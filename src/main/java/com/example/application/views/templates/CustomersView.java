package com.example.application.views.templates;

import com.example.application.components.*;
import com.example.application.utilities.BadgeVariant;
import com.example.application.utilities.Breakpoint;
import com.example.application.utilities.Font;
import com.example.application.utilities.HeadingLevel;
import com.example.application.views.HomeView;
import com.example.application.views.MainLayout;
import com.example.application.views.components.BreadcrumbsView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@PageTitle("Customers")
@Route(value = "customers", layout = MainLayout.class)
public class CustomersView extends Main {

    public static final String ACTIVE = "Active";
    public static final String INACTIVE = "Inactive";
    public static final String LOST = "Lost";
    public static final String PROSPECT = "Prospect";
    private final Person PERSON_1 = new Person("Ava Smith", "ava.smith@company.com", "https://images.unsplash.com/photo-1530785602389-07594beb8b73?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");
    private final Person PERSON_2 = new Person("Emma Johnson", "emma.johnson@company.com", "https://images.unsplash.com/photo-1553514029-1318c9127859?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");
    private final Person PERSON_3 = new Person("Mia Williams", "mia.williams@company.com", "https://images.unsplash.com/photo-1580489944761-15a19d654956?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

    public CustomersView() {
        addClassNames(Display.FLEX, FlexDirection.COLUMN, Gap.LARGE, Padding.LARGE);
        add(createHeader(), createToolbar(), createContent());
    }

    private Component createHeader() {
        Header header = new Header("Customer Management");
        header.setGap(Layout.Gap.MEDIUM);
        header.setHeadingFontSize(Font.Size.XXLARGE);

        // Remove the default padding
        header.getRowLayout().removeClassName(Padding.MEDIUM);

        // Position the tabs along the edge with negative margins
        header.getTabs().addClassName("-mx-l");
        header.setTabs(
                new Tab("All"),
                new Tab("Recent"),
                new Tab("Favourite")
        );

        // Breadcrumbs
        header.setBreadcrumb(
                new BreadcrumbItem("Home", HomeView.class),
                new BreadcrumbItem("Breadcrumbs", BreadcrumbsView.class)
        );

        // Details
        Paragraph description = new Paragraph("View and manage customer information, including contact details and purchase history");
        description.addClassNames(Margin.Vertical.NONE);
        header.setDetails(description);

        // Actions
        Button create = new Button("Create", LineAwesomeIcon.ROCKET_SOLID.create());
        Button add = new Button("Customer", LumoIcon.PLUS.create());
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        header.setActions(create, add);

        return header;
    }

    private Component createToolbar() {
        TextField search = new TextField();
        search.addClassNames(Flex.GROW, MinWidth.NONE, Padding.Vertical.NONE);
        search.setAriaLabel("Search");
        search.setClearButtonVisible(true);
        search.setMaxWidth(35, Unit.REM);
        search.setPlaceholder("Search");
        search.setPrefixComponent(LumoIcon.SEARCH.create());

        Button status = new Button("Status", LineAwesomeIcon.TAGS_SOLID.create());
        status.addClassNames(Margin.Vertical.NONE);

        Button advanced = new Button("Advanced", LineAwesomeIcon.SLIDERS_H_SOLID.create());
        advanced.addClassNames(Margin.Vertical.NONE);

        Layout buttons = new Layout(status, advanced);
        buttons.setGap(Layout.Gap.SMALL);

        Layout toolbar = new Layout(search, buttons);
        toolbar.setFlexDirection(Layout.FlexDirection.COLUMN);
        toolbar.setFlexDirection(Breakpoint.SMALL, Layout.FlexDirection.ROW);
        toolbar.setGap(Layout.Gap.MEDIUM);
        toolbar.setJustifyContent(Layout.JustifyContent.BETWEEN);
        return toolbar;
    }

    private Component createContent() {
        Grid<DummyItem> grid = new Grid<>();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setAllRowsVisible(true);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setItems(createItems());

        grid.addComponentColumn(this::renderName)
                .setAutoWidth(true)
                .setHeader("Name");
        grid.addColumn(new LocalDateRenderer<>(DummyItem::getDate, () -> DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH)))
                .setAutoWidth(true)
                .setHeader("Date");
        grid.addComponentColumn(this::renderStatus)
                .setAutoWidth(true)
                .setHeader("Status");
        grid.addComponentColumn(this::renderContact)
                .setAutoWidth(true)
                .setHeader("Contact");
        grid.addComponentColumn(this::renderActions)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Actions");

        GridHeader header = new GridHeader("Customers (42)", HeadingLevel.H3, grid);
        header.getRowLayout().addClassNames(Padding.End.SMALL);
        header.setDefaultActions(createDefaultActions());
        header.setContextActions(createContextActions());

        Layout content = new Layout(header, grid);
        content.addClassNames(Border.ALL, BorderRadius.LARGE);
        content.setFlexDirection(Layout.FlexDirection.COLUMN);
        content.setOverflow(Layout.Overflow.HIDDEN);
        return content;
    }

    private List<DummyItem> createItems() {
        List<DummyItem> items = new ArrayList<>();
        items.add(new DummyItem("Tech Solutions Inc", "TSI", LocalDate.now().minusDays(1), ACTIVE, PERSON_1));
        items.add(new DummyItem("Innovate Systems Ltd", "ISL", LocalDate.now().minusDays(2), LOST, PERSON_2));
        items.add(new DummyItem("DataTech Analytics", "DTA", LocalDate.now().minusDays(3), PROSPECT, PERSON_3));
        items.add(new DummyItem("Digital Innovations", "DI", LocalDate.now().minusDays(4), INACTIVE, PERSON_1));
        items.add(new DummyItem("Cloud Systems", "CS", LocalDate.now().minusDays(5), ACTIVE, PERSON_2));
        return items;
    }

    private Component renderName(DummyItem item) {
        Span primary = new Span(item.getPrimary());
        primary.addClassNames(FontWeight.SEMIBOLD);

        Span secondary = new Span(item.getSecondary());
        secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Layout layout = new Layout(primary, secondary);
        layout.addClassNames(Padding.Vertical.SMALL);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    private Component renderStatus(DummyItem item) {
        String status = item.getStatus();

        Badge badge = new Badge(status);
        badge.addThemeVariants(BadgeVariant.PILL);

        switch (status) {
            case INACTIVE -> badge.addThemeVariants(BadgeVariant.WARNING);
            case LOST -> badge.addThemeVariants(BadgeVariant.ERROR);
            case PROSPECT -> badge.addThemeVariants(BadgeVariant.SUCCESS);
        }
        return badge;
    }

    private Component renderContact(DummyItem item) {
        Person person = item.getContact();

        Image img = new Image(person.getImage(), person.getName());
        img.addClassNames(Height.MEDIUM, "rounded-full", Width.MEDIUM);

        Span name = new Span(person.getName());

        Span email = new Span(person.getEmail());
        email.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Layout nameEmail = new Layout(name, email);
        nameEmail.setFlexDirection(Layout.FlexDirection.COLUMN);

        Layout owner = new Layout(img, nameEmail);
        owner.setAlignItems(Layout.AlignItems.CENTER);
        owner.setGap(Layout.Gap.MEDIUM);
        return owner;
    }

    private Component renderActions(DummyItem item) {
        Button edit = new Button(LumoIcon.EDIT.create());
        edit.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        edit.setAriaLabel("Edit " + item.getPrimary());
        edit.setTooltipText("Edit " + item.getPrimary());

        Button more = new Button(LineAwesomeIcon.ELLIPSIS_V_SOLID.create());
        more.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        more.setAriaLabel("More options for " + item.getPrimary());
        more.setTooltipText("More options for " + item.getPrimary());

        Layout actions = new Layout(edit, more);
        actions.addClassNames("-mx-s");
        return actions;
    }

    private Component createDefaultActions() {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_ICON, MenuBarVariant.LUMO_TERTIARY);

        MenuItem item = menuBar.addItem(LineAwesomeIcon.ELLIPSIS_V_SOLID.create());
        item.setAriaLabel("More");

        item.getSubMenu().addItem(new Item("Search", LumoIcon.SEARCH));
        item.getSubMenu().addItem(new Item("Filter", LineAwesomeIcon.ADJUST_SOLID));

        return menuBar;
    }

    private Component createContextActions() {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_ICON, MenuBarVariant.LUMO_TERTIARY);

        MenuItem item = menuBar.addItem(LineAwesomeIcon.ELLIPSIS_V_SOLID.create());
        item.setAriaLabel("More");

        item.getSubMenu().addItem(new Item("Edit", LumoIcon.EDIT));
        item.getSubMenu().addItem(new Item("Delete", LineAwesomeIcon.TRASH_SOLID));

        return menuBar;
    }

    private static class DummyItem {
        private String primary;
        private String secondary;
        private LocalDate date;
        private String status;
        private Person contact;

        public DummyItem(String primary, String secondary, LocalDate date, String status, Person contact) {
            this.primary = primary;
            this.secondary = secondary;
            this.date = date;
            this.status = status;
            this.contact = contact;
        }

        public String getPrimary() {
            return primary;
        }

        public void setPrimary(String primary) {
            this.primary = primary;
        }

        public String getSecondary() {
            return secondary;
        }

        public void setSecondary(String secondary) {
            this.secondary = secondary;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Person getContact() {
            return contact;
        }

        public void setContact(Person contact) {
            this.contact = contact;
        }
    }

    private static class Person {
        private String name;
        private String email;
        private String image;

        public Person(String name, String email, String image) {
            this.name = name;
            this.email = email;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
