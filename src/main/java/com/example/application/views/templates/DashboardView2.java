package com.example.application.views.templates;

import com.example.application.components.*;
import com.example.application.utilities.BadgeVariant;
import com.example.application.utilities.Color;
import com.example.application.utilities.Font;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.AvatarGroup;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@PageTitle("Dashboard º2")
@Route(value = "dashboard-2", layout = MainLayout.class)
public class DashboardView2 extends Main {

    public static final String ORDERS = "Orders";
    public static final String ORDERS_VALUE = "42,719";
    public static final String SALES = "Sales (€)";
    public static final String SALES_VALUE = "546k";
    public static final String VISITORS = "Visitors";
    public static final String VISITORS_VALUE = "62,806";
    public static final String VISITORS_CHANGE = "13.35%";
    private final Random random = new Random();

    public DashboardView2() {
        addClassNames(Display.FLEX, FlexDirection.COLUMN, Gap.LARGE, Padding.LARGE);
        add(createHeader(), createHighlights(), createToolbar(), createContent());
    }

    private Component createHeader() {
        Header header = new Header("Dashboard");
        header.setGap(Layout.Gap.MEDIUM);
        header.setHeadingFontSize(Font.Size.XXLARGE);

        // Remove the default padding
        header.getRowLayout().removeClassName(Padding.MEDIUM);

        // Position the tabs along the edge with negative margins
        header.getTabs().addClassName("-mx-l");
        header.setTabs(
                new Tab("Overview"),
                new Tab("Reports"),
                new Tab("Settings")
        );
        return header;
    }

    private Component createHighlights() {
        Highlights highlights = new Highlights();
        highlights.setGap(Layout.Gap.LARGE);
        highlights.add(
                createHighlight(ORDERS, ORDERS_VALUE),
                createHighlight(SALES, SALES_VALUE),
                createHighlight(VISITORS, VISITORS_VALUE)
        );
        return highlights;
    }

    private Highlight createHighlight(String heading, String value) {
        Highlight highlight = new Highlight(heading, value);
        highlight.addClassNames(Border.ALL, BorderRadius.LARGE, Padding.Bottom.XSMALL, Padding.Top.MEDIUM);
        highlight.removeClassName(LumoUtility.Padding.Vertical.SMALL);
        highlight.setSuffix(createHighlightSuffix());
        highlight.setValueFontSize(Font.Size.XXXLARGE);
        return highlight;
    }

    private Component createHighlightSuffix() {
        Button button = new Button(LineAwesomeIcon.ELLIPSIS_V_SOLID.create());
        button.addClassNames(Margin.Bottom.NONE, "-me-s", "-mt-m", TextColor.SECONDARY);
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        button.setAriaLabel("More");
        button.setTooltipText("More");

        Tag tag = new Tag(LineAwesomeIcon.ARROW_UP_SOLID, VISITORS_CHANGE, Color.Text.SUCCESS);

        Div suffix = new Div(button, tag);
        suffix.addClassNames(AlignItems.END, Display.FLEX, FlexDirection.COLUMN, Gap.MEDIUM);
        return suffix;
    }

    private Component createToolbar() {
        TextField search = new TextField();
        search.addClassNames(Flex.GROW, MinWidth.NONE, Padding.Vertical.NONE);
        search.setAriaLabel("Search");
        search.setClearButtonVisible(true);
        search.setMaxWidth(37, Unit.REM);
        search.setPlaceholder("Search");
        search.setPrefixComponent(LumoIcon.SEARCH.create());

        Button filter = new Button("Filter", LumoIcon.DROPDOWN.create());
        filter.addClassNames(Margin.Vertical.NONE);
        filter.setIconAfterText(true);

        Layout searchFilter = new Layout(search, filter);
        searchFilter.setGap(Layout.Gap.SMALL);
        searchFilter.setJustifyContent(Layout.JustifyContent.BETWEEN);

        Layout toolbar = new Layout(searchFilter, createFilters());
        toolbar.setFlexDirection(Layout.FlexDirection.COLUMN);
        toolbar.setGap(Layout.Gap.MEDIUM);
        return toolbar;
    }

    private Component createFilters() {
        Layout layout = new Layout(
                createFilter("Filter 1"),
                createFilter("Filter 2"),
                createFilter("Filter 3")
        );
        layout.setGap(Layout.Gap.SMALL);
        layout.setFlexWrap(Layout.FlexWrap.WRAP);
        return layout;
    }

    private Component createFilter(String text) {
        Icon icon = LumoIcon.CROSS.create();
        icon.getStyle().setMargin("0");

        Button button = new Button(icon);
        button.setAriaLabel("Clear " + text);
        button.setTooltipText("Clear " + text);
        button.addClassNames("-me-s", "-my-s", Padding.NONE);
        button.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);

        Badge badge = new Badge(text);
        badge.add(button);
        badge.addThemeVariants(BadgeVariant.PILL);
        return badge;
    }

    private Component createContent() {
        Grid<DummyItem> grid = new Grid<>();
        grid.addClassNames(BorderRadius.LARGE, Overflow.HIDDEN);
        grid.setAllRowsVisible(true);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setItems(createItems());

        grid.addComponentColumn(this::renderName)
                .setAutoWidth(true)
                .setHeader("Name");
        grid.addComponentColumn(this::renderTask)
                .setAutoWidth(true)
                .setHeader("Task");
        grid.addComponentColumn(this::renderUsers)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Users");
        grid.addComponentColumn(this::renderProgress)
                .setFlexGrow(0)
                .setHeader("Progress")
                .setWidth("10rem");
        grid.addComponentColumn(this::renderActions)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Actions");

        return grid;
    }

    private List<DummyItem> createItems() {
        List<DummyItem> items = new ArrayList<>();
        items.add(new DummyItem("images/logo-1.png", "Tech Solutions Inc", "TSI", this.random.nextInt(101), getUsers()));
        items.add(new DummyItem("images/logo-2.png", "Innovate Systems Ltd", "ISL", this.random.nextInt(101), getUsers()));
        items.add(new DummyItem("images/logo-3.png", "DataTech Analytics", "DTA", this.random.nextInt(101), getUsers()));
        items.add(new DummyItem("images/logo-4.png", "Digital Innovations", "DI", this.random.nextInt(101), getUsers()));
        items.add(new DummyItem("images/logo-5.png", "Cloud Systems", "CS", this.random.nextInt(101), getUsers()));
        return items;
    }

    private Person[] getUsers() {
        int colorIndex = 0;
        return new Person[]{
                new Person(
                        "Emily Johnson",
                        "https://images.unsplash.com/photo-1530785602389-07594beb8b73?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                        colorIndex++
                ),
                new Person(
                        "Michael Thompson",
                        "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?&auto=format&fit=facearea&facepad=2.25&w=256&h=256&q=80",
                        colorIndex++
                ),
                new Person(
                        "Olivia Martinez",
                        "https://images.unsplash.com/photo-1553514029-1318c9127859?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                        colorIndex++
                ),
                new Person(
                        "Daniel Wilson",
                        "https://images.unsplash.com/photo-1491528323818-fdd1faba62cc?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                        colorIndex++
                ),
                new Person(
                        "Sophia Clark",
                        "https://images.unsplash.com/photo-1580489944761-15a19d654956?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
                        colorIndex
                )
        };
    }

    private Component renderName(DummyItem item) {
        Image img = new Image(item.getImage(), item.getPrimary() + " logo");
        img.addClassNames(LumoUtility.Height.MEDIUM, LumoUtility.Width.MEDIUM);

        Span primary = new Span(item.getPrimary());
        primary.addClassNames(FontWeight.SEMIBOLD);

        Span secondary = new Span(item.getSecondary());
        secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Div text = new Div(primary, secondary);
        text.addClassNames(Display.FLEX, FlexDirection.COLUMN);

        Div div = new Div(img, text);
        div.addClassNames(AlignItems.CENTER, Display.FLEX, Gap.MEDIUM, Padding.Vertical.SMALL);
        return div;
    }

    private Component renderTask(DummyItem item) {
        return new Span("Task description goes here");
    }

    private Component renderUsers(DummyItem item) {
        AvatarGroup group = new AvatarGroup();
        group.setMaxItemsVisible(4);
        for (Person user : item.getUsers()) {
            AvatarGroup.AvatarGroupItem avatar = new AvatarGroup.AvatarGroupItem(user.getName());
            avatar.setColorIndex(user.getColorIndex());
            avatar.setImage(user.getImage());
            group.add(avatar);
        }
        return group;
    }

    private Component renderProgress(DummyItem item) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setValue(item.getProgress() / 100.0f);
        return progressBar;
    }

    private Component renderActions(DummyItem item) {
        Button edit = new Button(LumoIcon.EDIT.create());
        edit.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        edit.setAriaLabel("Edit " + item.getPrimary());
        edit.setTooltipText("Edit " + item.getPrimary());

        Button delete = new Button(LineAwesomeIcon.TRASH_SOLID.create());
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);
        delete.setAriaLabel("Delete " + item.getPrimary());
        delete.setTooltipText("Delete " + item.getPrimary());

        Div actions = new Div(edit, delete);
        actions.addClassNames(Display.FLEX);
        return actions;
    }

    private static class DummyItem {
        private String image;
        private String primary;
        private String secondary;
        private int progress;
        private Person[] users;

        public DummyItem(String image, String primary, String secondary, int progress, Person[] users) {
            this.image = image;
            this.primary = primary;
            this.secondary = secondary;
            this.progress = progress;
            this.users = users;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public Person[] getUsers() {
            return users;
        }

        public void setUsers(Person[] users) {
            this.users = users;
        }
    }

    private static class Person {
        private String name;
        private String image;
        private int colorIndex;

        public Person(String name, String image, int colorIndex) {
            this.name = name;
            this.image = image;
            this.colorIndex = colorIndex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getColorIndex() {
            return colorIndex;
        }

        public void setColorIndex(int colorIndex) {
            this.colorIndex = colorIndex;
        }
    }
}
