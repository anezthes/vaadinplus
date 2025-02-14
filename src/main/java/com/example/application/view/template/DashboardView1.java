package com.example.application.view.template;

import com.example.application.component.Header;
import com.example.application.component.Span;
import com.example.application.component.*;
import com.example.application.component.list.List;
import com.example.application.component.list.MessageListItem;
import com.example.application.theme.RadioButtonTheme;
import com.example.application.utility.BadgeVariant;
import com.example.application.utility.Color;
import com.example.application.utility.Font;
import com.example.application.view.MainLayout;
import com.example.application.view.component.HighlightsView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

@PageTitle("Dashboard º1")
@Route(value = "dashboard-1", layout = MainLayout.class)
public class DashboardView1 extends Main {

    public static final String ARIA_LABEL = "aria-label";
    public static final String ARIA_LABELLEDBY = "aria-labelledby";
    public static final String STATISTICS_ID = "statistics";
    public static final String MARKET_SUMMARY_ID = "market-summary";
    public static final String TRANSACTIONS_ID = "transactions";
    public static final String ORDERS = "Orders";
    public static final String ORDERS_VALUE = "42,719";
    public static final String ORDERS_CHANGE = "16.38%";
    public static final String SALES = "Sales";
    public static final String SALES_VALUE = "€546,110.70";
    public static final String SALES_CHANGE = "40.82%";
    public static final String VISITORS = "Visitors";
    public static final String VISITORS_VALUE = "62,806";
    public static final String VISITORS_CHANGE = "13.35%";

    public static final String PERSON_1_IMG = "https://images.unsplash.com/photo-1530785602389-07594beb8b73?w=160";
    public static final String PERSON_2_IMG = "https://images.unsplash.com/photo-1553514029-1318c9127859?w=160";
    public static final String PERSON_3_IMG = "https://images.unsplash.com/photo-1580489944761-15a19d654956?w=160";

    private Sidebar chartSidebar;

    public DashboardView1() {
        Layout layout = new Layout(
                createTitleDescription(),
                createToggle(),
                createHighlights(),
                createMarketSummary(),
                createTransactions()
        );
        layout.addClassNames(Margin.Horizontal.AUTO, MaxWidth.SCREEN_LARGE, Padding.LARGE);
        layout.setBoxSizing(Layout.BoxSizing.BORDER);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        layout.setGap(Layout.Gap.LARGE);
        add(layout);

        // TODO: Add list, comments, collaborative features, improve mobile experience
    }

    private Component createTitleDescription() {
        H2 heading = new H2("Zoomblix data vista");

        Paragraph paragraph = new Paragraph("Information coalescing into kaleidoscopic insights, painting the canvas of cognition with ineffable splendor");
        paragraph.addClassNames(Margin.Bottom.NONE, TextColor.SECONDARY);

        return new Div(heading, paragraph);
    }

    private Component createToggle() {
        RadioButtonGroup<String> group = new RadioButtonGroup<>();
        group.setItems("1 day", "1 week", "1 month");
        group.setRenderer(new ComponentRenderer<>(item -> new Span(item, Padding.Horizontal.SMALL)));
        group.setValue("1 day");

        // Accessibility
        group.setAriaLabel("Duration");
        group.setTooltipText("Duration");

        // Theme
        group.addThemeNames(RadioButtonTheme.TOGGLE);
        group.getChildren().forEach(component -> component.getElement().getThemeList().add(RadioButtonTheme.TOGGLE));
        return group;
    }

    private Component createHighlights() {
        Highlights highlights = new Highlights();
        highlights.addClassNames(Border.ALL, BorderRadius.LARGE, "md:divide-x");

        Highlight highlight = new Highlight(
                createIcon(LineAwesomeIcon.CUBES_SOLID, Color.Background.PRIMARY_10, Color.Text.PRIMARY),
                ORDERS, ORDERS_VALUE,
                createSuffix(ORDERS)
        );
        highlight.setDetails(new Tag(LineAwesomeIcon.ARROW_UP_SOLID, ORDERS_CHANGE, Color.Text.SUCCESS));
        highlights.add(highlight);

        highlight = new Highlight(
                createIcon(LineAwesomeIcon.CHART_BAR_SOLID, Color.Background.SUCCESS_10, Color.Text.SUCCESS),
                SALES, SALES_VALUE,
                createSuffix(SALES)
        );
        highlight.setDetails(new Tag(LineAwesomeIcon.ARROW_UP_SOLID, SALES_CHANGE, Color.Text.SUCCESS));
        highlights.add(highlight);

        highlight = new Highlight(
                createIcon(LineAwesomeIcon.USER, Color.Background.ERROR_10, Color.Text.ERROR),
                VISITORS, VISITORS_VALUE,
                createSuffix(VISITORS)
        );
        highlight.setDetails(new Tag(LineAwesomeIcon.ARROW_UP_SOLID, VISITORS_CHANGE, Color.Text.SUCCESS));
        highlights.add(highlight);

        Section section = new Section(highlights);
        section.getElement().setAttribute(ARIA_LABEL, STATISTICS_ID);
        return section;
    }

    private Component createIcon(LineAwesomeIcon icon, Color.Background backgroundColor, Color.Text textColor) {
        SvgIcon i = icon.create();
        i.addClassNames(IconSize.LARGE);

        Layout container = new Layout(i);
        container.addClassNames(backgroundColor.getClassName(), "rounded-full", Height.XLARGE, textColor.getClassName(),
                Width.XLARGE);
        container.setAlignItems(Layout.AlignItems.CENTER);
        container.setJustifyContent(Layout.JustifyContent.CENTER);
        return container;
    }

    private RouterLink createSuffix(String label) {
        SvgIcon icon = LineAwesomeIcon.ARROW_RIGHT_SOLID.create();
        icon.addClassNames(IconSize.SMALL, TextColor.SECONDARY);

        RouterLink link = new RouterLink("", HighlightsView.class);
        link.add(icon);
        link.addClassNames(AlignItems.CENTER, Display.FLEX, Height.MEDIUM, JustifyContent.CENTER, Width.MEDIUM);
        link.getElement().setAttribute("aria-label", label);
        link.getElement().setAttribute("title", label);
        return link;
    }

    private Component createMarketSummary() {
        Section section = new Section(createChartHeader(), createChartSidebar(), createChart());
        section.getElement().setAttribute(ARIA_LABELLEDBY, MARKET_SUMMARY_ID);
        return section;
    }

    private Component createChartHeader() {
        Button details = new Button("Details", LineAwesomeIcon.INFO_CIRCLE_SOLID.create());

        Badge commentsBadge = new Badge();
        commentsBadge.addClassNames(LumoUtility.Position.ABSOLUTE, "end-xs", "top-xs");
        commentsBadge.addThemeVariants(BadgeVariant.ERROR, BadgeVariant.PILL, BadgeVariant.PRIMARY, BadgeVariant.SMALL);

        Button comments = new Button(LineAwesomeIcon.COMMENT_ALT.create(), e -> this.chartSidebar.open());
        comments.setAriaLabel("View comments (4)");
        comments.setSuffixComponent(commentsBadge);
        comments.setTooltipText("View comments (4)");

        Header header = new Header("Market summary");
        header.setActions(details, comments);
        header.setHeadingFontSize(Font.Size.XLARGE);
        header.setHeadingId(MARKET_SUMMARY_ID);
        header.removeClassName(Border.BOTTOM);
        return header;
    }

    private Component createChartSidebar() {
        this.chartSidebar = new Sidebar("Comments (4)", createChartSidebarContent());
        this.chartSidebar.addThemeName(Lumo.DARK);

        // Remove the content padding
        // TODO: API? Variant?
        this.chartSidebar.getContent().removeClassNames(Padding.Bottom.MEDIUM,
                Padding.Horizontal.LARGE, Padding.Top.SMALL);

        // Hide the footer
        // TODO: Footer component? Should it be added by default?
        this.chartSidebar.getFooter().setVisible(false);
        return this.chartSidebar;
    }

    private List createChartSidebarContent() {
        return new List(
                new MessageListItem(PERSON_1_IMG, "Sarah Anderson", "Impressive market resilience reflected in this chart! Positive trends across sectors indicate a robust and promising outlook.",
                        LocalDateTime.now().minusMinutes(12)),
                new MessageListItem(PERSON_2_IMG, "Daniella Parker", "The upward trajectory showcased in the market summary is truly encouraging, signaling strength and stability for investors.",
                        LocalDateTime.now().minusMinutes(36)),
                new MessageListItem(PERSON_3_IMG, "Rachel Hughes", "Noteworthy performance across the board! This market summary paints a picture of growth and opportunity for savvy investors.",
                        LocalDateTime.now().minusMinutes(42)),
                new MessageListItem("Andrew Murphy", "A stellar representation of market dynamics! The positive indicators are a testament to the thriving conditions within the market.",
                        LocalDateTime.now().minusMinutes(56))
        );
    }

    private Component createChart() {
        Chart chart = new Chart();
        Configuration config = chart.getConfiguration();

        config.getChart().setStyledMode(true);
        config.getChart().setType(ChartType.LINE);

        config.getLegend().setEnabled(false);

        config.setTooltip(new Tooltip());
        config.getxAxis().setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
                "Nov", "Dec");
        config.getyAxis().setTitle("");

        // TODO: Make it make just a tad bit more sense :)
        SeriesTooltip tooltip = new SeriesTooltip();
        tooltip.setPointFormatter("function() { return this.x + 'M €' }");

        PlotOptionsSeries series = new PlotOptionsSeries();
        series.setTooltip(tooltip);
        config.setPlotOptions(series);

        ListSeries ls = new ListSeries();
        ls.setName("Luminary Trail");
        ls.setData(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6);
        config.addSeries(ls);

        ls = new ListSeries();
        ls.setName("Radiant Pathway");
        ls.setData(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8);
        config.addSeries(ls);

        return chart;
    }

    private Component createTransactions() {
        GridHeader header = createGridHeader();
        header.setHeadingFontSize(Font.Size.XLARGE);

        Grid<DashboardItem> grid = createGrid();
        header.setGrid(grid);

        Section section = new Section(header, grid);
        section.getElement().setAttribute(ARIA_LABELLEDBY, TRANSACTIONS_ID);
        return section;
    }

    private GridHeader createGridHeader() {
        GridHeader header = new GridHeader("Transactions (8)", createGrid());
        header.setContextActions(getContextActions());
        header.setDefaultActions(getDefaultActions());
        header.setHeadingId(TRANSACTIONS_ID);
        return header;
    }

    private Component[] getContextActions() {
        Button share = new Button("Share", LineAwesomeIcon.SHARE_SOLID.create());
        share.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Button download = new Button("Download", LineAwesomeIcon.DOWNLOAD_SOLID.create());
        download.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        return new Component[]{share, download};
    }

    private Component[] getDefaultActions() {
        TextField search = new TextField();
        search.setAriaLabel("Search");
        search.setPlaceholder("Search");
        search.setPrefixComponent(LumoIcon.SEARCH.create());

        Badge filtersBadge = new Badge("2");
        filtersBadge.addThemeVariants(BadgeVariant.PILL, BadgeVariant.PRIMARY, BadgeVariant.SMALL);

        Button filters = new Button("Filters");
        filters.setSuffixComponent(filtersBadge);

        return new Component[]{search, filters};
    }

    private Grid<DashboardItem> createGrid() {
        Grid<DashboardItem> grid = new Grid<>();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setAllRowsVisible(true);
        grid.setItems(createItems());
        grid.setSelectionMode(Grid.SelectionMode.MULTI);

        grid.addComponentColumn(this::renderName)
                .setAutoWidth(true)
                .setHeader("Name");
        grid.addComponentColumn(this::renderAmount)
                .setAutoWidth(true)
                .setHeader("Amount")
                .setTextAlign(ColumnTextAlign.END);
        grid.addComponentColumn(this::renderStatus)
                .setAutoWidth(true)
                .setHeader("Status");
        grid.addColumn(new LocalDateRenderer<>(DashboardItem::getDate, () ->
                        DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH)))
                .setAutoWidth(true)
                .setHeader("Date");
        grid.addComponentColumn(this::renderEditButton)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Edit");

        return grid;
    }

    private Component renderName(DashboardItem item) {
        Image img = new Image(item.getImage(), item.getName() + " logo");
        img.addClassNames(Height.MEDIUM, Width.MEDIUM);

        Span span = new Span(item.getName());
        span.addClassNames(FontWeight.SEMIBOLD);

        Layout layout = new Layout(img, span);
        layout.addClassNames(Padding.Vertical.SMALL);
        layout.setAlignItems(Layout.AlignItems.CENTER);
        layout.setGap(Layout.Gap.SMALL);
        return layout;
    }

    private Component renderAmount(DashboardItem item) {
        Span span = new Span(item.getAmount());
        span.addClassNames("font-mono");
        return span;
    }

    private Component renderStatus(DashboardItem item) {
        Badge badge = new Badge(item.getStatus());
        badge.setIcon(LineAwesomeIcon.CLOCK);
        if (item.getStatus().equals("Completed")) {
            badge.addThemeVariants(BadgeVariant.SUCCESS);
            badge.setIcon(LineAwesomeIcon.CHECK_SOLID);
        } else if (item.getStatus().equals("Refunded")) {
            badge.addThemeVariants(BadgeVariant.WARNING);
            badge.setIcon(LineAwesomeIcon.UNDO_SOLID);
        }
        return badge;
    }

    private Component renderEditButton(DashboardItem item) {
        Button button = new Button(LineAwesomeIcon.EDIT.create());
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        button.setAriaLabel("Edit " + item.getName());
        button.setTooltipText("Edit " + item.getName());
        return button;
    }

    private ArrayList<DashboardItem> createItems() {
        ArrayList<DashboardItem> items = new ArrayList<>();
        items.add(new DashboardItem("images/logo-1.png", "Galactic Gadget Emporium", "57,89 €", LocalDate.now(), "Completed"));
        items.add(new DashboardItem("images/logo-2.png", "Nebula Café", "22,50 €", LocalDate.now(), "Pending"));
        items.add(new DashboardItem("images/logo-3.png", "Techno Gear Outfitters", "120,75 €", LocalDate.now(), "Completed"));
        items.add(new DashboardItem("images/logo-4.png", "AstroBooks Online", "45,99 €", LocalDate.now(), "Refunded"));
        items.add(new DashboardItem("images/logo-5.png", "Stellar Fashion Boutique", "85,25 €", LocalDate.now(), "Completed"));
        items.add(new DashboardItem("images/logo-6.png", "AstroGrocery Mart", "32,10 €", LocalDate.now(), "Completed"));
        items.add(new DashboardItem("images/logo-7.png", "Cosmic Fitness Studio", "50,00 €", LocalDate.now(), "Pending"));
        items.add(new DashboardItem("images/logo-8.png", "NebulaCraft Art Gallery", "200,45 €", LocalDate.now(), "Completed"));
        return items;
    }

    private static class DashboardItem {

        private String image;
        private String name;
        private String amount;
        private LocalDate date;
        private String status;

        public DashboardItem(String image, String name, String amount, LocalDate date, String status) {
            this.image = image;
            this.name = name;
            this.amount = amount;
            this.date = date;
            this.status = status;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
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
    }

}
