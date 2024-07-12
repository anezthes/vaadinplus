package com.example.application.views.templates;

import com.example.application.components.Badge;
import com.example.application.components.InputGroup;
import com.example.application.components.Layout;
import com.example.application.components.Tag;
import com.example.application.themes.RadioButtonTheme;
import com.example.application.utilities.BadgeVariant;
import com.example.application.utilities.Breakpoint;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoIcon;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.time.LocalDate;

@PageTitle("Hotels")
@Route(value = "hotels", layout = MainLayout.class)
public class HotelsView extends Main {

    public HotelsView() {
        addClassNames(Display.FLEX, FlexDirection.COLUMN, Gap.LARGE, Padding.LARGE);
        add(createHeader(), createHr(), createToolbar(), createContent(), createFooter());
    }

    private Component createHeader() {
        H2 title = new H2("Hotels");

        Paragraph description = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        description.addClassNames(Margin.Vertical.NONE);

        Div titleDescription = new Div(title, description);
        titleDescription.addClassNames(Display.FLEX, FlexDirection.COLUMN, Gap.SMALL, Margin.End.AUTO);

        Button follow = new Button("Follow", LumoIcon.PLUS.create());

        Button save = new Button("Save", LumoIcon.CHECKMARK.create());
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Div actions = new Div(follow, save);
        actions.addClassNames(Display.FLEX, Gap.SMALL);

        Div header = new Div(titleDescription, actions);
        header.addClassNames("sm:items-center", Display.FLEX, FlexDirection.COLUMN,
                FlexDirection.Breakpoint.Small.ROW, Gap.MEDIUM);

        return header;
    }

    private Hr createHr() {
        Hr hr = new Hr();
        hr.addClassNames(Margin.NONE);
        return hr;
    }

    private Component createToolbar() {
        ComboBox<String> destination = new ComboBox<>();
        destination.setAriaLabel("Destination");
        destination.addClassNames(MinWidth.NONE);
        destination.setItems("\uD83C\uDDEB\uD83C\uDDEE Turku, FIN");
        destination.setValue("\uD83C\uDDEB\uD83C\uDDEE Turku, FIN");

        DatePicker checkIn = new DatePicker();
        checkIn.setAriaLabel("Check in");
        checkIn.setTooltipText("Check in");
        checkIn.setValue(LocalDate.now());
        checkIn.setWidth(9, Unit.REM);

        DatePicker checkOut = new DatePicker();
        checkOut.setAriaLabel("Check out");
        checkOut.setTooltipText("Check out");
        checkOut.setValue(LocalDate.now().plusDays(7));
        checkOut.setWidth(9, Unit.REM);

        InputGroup dateRange = new InputGroup(checkIn, checkOut);
        dateRange.addClassName(MinWidth.NONE);
        dateRange.setGap(Layout.Gap.PIXEL);

        TextField priceMin = new TextField();
        priceMin.setAriaLabel("Minimum price");
        priceMin.setPrefixComponent(LineAwesomeIcon.EURO_SIGN_SOLID.create());
        priceMin.setTooltipText("Minimum price");
        priceMin.setValue("80");
        priceMin.setWidth(6, Unit.REM);

        TextField priceMax = new TextField();
        priceMax.setAriaLabel("Maximum price");
        priceMax.setPrefixComponent(LineAwesomeIcon.EURO_SIGN_SOLID.create());
        priceMax.setTooltipText("Maximum price");
        priceMax.setValue("420");
        priceMax.setWidth(6, Unit.REM);

        InputGroup priceRange = new InputGroup(priceMin, priceMax);
        priceRange.addClassName(MinWidth.NONE);
        priceRange.setGap(Layout.Gap.PIXEL);

        Layout ranges = new Layout(dateRange, priceRange);
        ranges.addClassNames(MinWidth.NONE, "lg:flex-grow-0");
        ranges.setGap(Layout.Gap.MEDIUM);
        ranges.setFlexDirection(Layout.FlexDirection.COLUMN);
        ranges.setFlexDirection(Breakpoint.SMALL, Layout.FlexDirection.ROW);
        ranges.setFlexGrow(dateRange, priceRange);

        RadioButtonGroup<String> sort = new RadioButtonGroup<>();
        sort.setAriaLabel("Sort by");
        sort.setItems("Date", "Price");
        sort.setRenderer(new ComponentRenderer<>(item -> {
            Span span = new Span(item);
            span.addClassNames(Padding.Horizontal.SMALL);
            return span;
        }));
        sort.setTooltipText("Sort by");
        sort.setValue("Date");

        RadioButtonGroup<String> view = new RadioButtonGroup<>();
        view.setAriaLabel("View");
        view.setItems("List", "Map");
        view.setRenderer(new ComponentRenderer<>(item -> {
            Span span = new Span(item);
            span.addClassNames(Accessibility.SCREEN_READER_ONLY);
            return new Span(span, item.equals("List") ?
                    LumoIcon.UNORDERED_LIST.create() : LineAwesomeIcon.MAP.create()
            );
        }));
        view.setTooltipText("View");
        view.setValue("List");

        for (RadioButtonGroup group : new RadioButtonGroup[]{sort, view}) {
            group.addThemeName(RadioButtonTheme.TOGGLE);
            group.getChildren().forEach(component ->
                    component.getElement().getThemeList().add(RadioButtonTheme.TOGGLE));
        }

        Layout toggles = new Layout(sort, view);
        toggles.setGap(Layout.Gap.MEDIUM);

        // Flex input fields (needed for mobile)
        for (Component component : new Component[]{checkIn, checkOut, priceMin, priceMax}) {
            component.addClassNames(Flex.GROW);
        }

        // Remove paddings
        for (Component component : new Component[]{destination, checkIn, checkOut, priceMin, priceMax, sort, view}) {
            component.addClassNames(Padding.Vertical.NONE);
        }

        Layout toolbar = new Layout(destination, ranges, toggles);
        toolbar.setFlexDirection(Layout.FlexDirection.COLUMN);
        toolbar.setFlexDirection(Breakpoint.LARGE, Layout.FlexDirection.ROW);
        toolbar.setGap(Layout.Gap.MEDIUM);
        return toolbar;
    }

    private Component createContent() {
        OrderedList list = new OrderedList(
                createListItem(
                        "https://images.unsplash.com/photo-1511884642898-4c92249e20b6?w=640",
                        "Aerial shot of forest"
                ),
                createListItem(
                        "https://images.unsplash.com/photo-1434725039720-aaad6dd32dfe?w=640",
                        "Photo of green grass field at sunrise"
                ),
                createListItem(
                        "https://images.unsplash.com/photo-1532274402911-5a369e4c4bb5?w=640",
                        "Brown wooden dock between lavender flower field near body of water during golden hour"
                ),
                createListItem(
                        "https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=640",
                        "Three brown wooden boat on blue lake water taken at daytime"
                ),
                createListItem(
                        "https://images.unsplash.com/photo-1470770841072-f978cf4d019e?w=640",
                        "Brown house near body of water"
                )
        );
        list.addClassNames(Border.BOTTOM, Border.TOP, Display.FLEX, FlexDirection.COLUMN, ListStyleType.NONE,
                Margin.Vertical.NONE, Padding.Start.NONE, "divide-y");
        return list;
    }

    private ListItem createListItem(String src, String alt) {
        // Image and favourite button
        Image img = new Image(src, alt);
        img.addClassNames(BorderRadius.MEDIUM, MaxWidth.FULL);

        Button button = new Button(LineAwesomeIcon.HEART.create());
        button.addClassNames(Background.BASE, Margin.NONE, Padding.NONE, Position.ABSOLUTE, "end-s", "top-l",
                "md:top-s", "rounded-full");
        button.addThemeVariants(ButtonVariant.LUMO_ERROR);
        button.setAriaLabel("Favourite");
        button.setTooltipText("Favourite");

        Layout image = new Layout(img, button);
        image.addClassNames("contents");
        image.setDisplay(Breakpoint.SMALL, Layout.Display.FLEX);
        image.setJustifyContent(Layout.JustifyContent.CENTER);
        image.setOverflow(Layout.Overflow.HIDDEN);
        image.setPosition(Layout.Position.RELATIVE);
        image.setWidth(160, Unit.PIXELS);

        // Header
        Span title = new Span("Title");
        title.addClassNames(FontSize.LARGE, FontWeight.MEDIUM);

        Badge badge = new Badge("Popular");
        badge.addThemeVariants(BadgeVariant.PILL, BadgeVariant.SMALL);

        Layout header = new Layout(title, badge);
        header.setAlignItems(Layout.AlignItems.CENTER);
        header.setGap(Layout.Gap.SMALL);

        // Feedback
        Span rating = new Span("4.96");
        rating.addClassNames(FontWeight.MEDIUM);

        Layout stars = new Layout(createStar(), createStar(), createStar(), createStar(), createStar());
        stars.addClassNames(TextColor.PRIMARY);

        Span reviews = new Span("(420)");
        reviews.addClassNames(TextColor.SECONDARY);

        Layout feedback = new Layout(rating, stars, reviews);
        feedback.addClassNames(FontSize.SMALL);
        feedback.setAlignItems(Layout.AlignItems.CENTER);
        feedback.setGap(Layout.Gap.SMALL);

        // Tags
        Tag parking = new Tag(LineAwesomeIcon.PARKING_SOLID.create(), "Parking");
        Tag breakfast = new Tag(LineAwesomeIcon.UTENSILS_SOLID.create(), "Breakfast");
        Tag wifi = new Tag(LineAwesomeIcon.WIFI_SOLID.create(), "Wi-Fi");

        Layout tags = new Layout(parking, breakfast, wifi);
        tags.setGap(Layout.Gap.MEDIUM);

        // Content layout
        Layout content = new Layout(header, feedback, tags);
        content.setFlexDirection(Layout.FlexDirection.COLUMN);
        content.setFlexGrow();
        content.setGap(Layout.Gap.SMALL);

        // Price
        Span price = new Span("€692");
        price.addClassNames(FontSize.XXLARGE, FontWeight.SEMIBOLD, LineHeight.SMALL);

        // Main layout
        Layout layout = new Layout(image, content, price);
        layout.addClassNames(Padding.Vertical.MEDIUM);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        layout.setFlexDirection(Breakpoint.SMALL, Layout.FlexDirection.ROW);
        layout.setGap(Layout.Gap.MEDIUM);
        layout.setPosition(Layout.Position.RELATIVE);
        return new ListItem(layout);
    }

    private Component createStar() {
        SvgIcon svgIcon = LineAwesomeIcon.STAR_SOLID.create();
        svgIcon.addClassNames(IconSize.SMALL);
        return svgIcon;
    }

    private Component createFooter() {
        UnorderedList list = new UnorderedList(
                createPaginationPreviousLink(),
                createPageIndicator(),
                createPaginationLink("1"),
                createPaginationDots(),
                createPaginationLink("6"),
                createPaginationLink("7"),
                createPaginationLink("8"),
                createPaginationLink("9"),
                createPaginationLink("10"),
                createPaginationDots(),
                createPaginationLink("20"),
                createPaginationNextLink()
        );
        list.addClassNames(Display.FLEX, Gap.SMALL, ListStyleType.NONE, Margin.Vertical.NONE, Padding.Start.NONE);

        Nav nav = new Nav(list);
        nav.setAriaLabel("Pagination");
        nav.setTitle("Pagination");
        return nav;
    }

    private ListItem createPaginationPreviousLink() {
        Span label = new Span("Previous");
        label.addClassNames(Accessibility.SCREEN_READER_ONLY, "lg:not-sr-only");

        RouterLink link = new RouterLink(this.getClass());
        link.addClassNames(AlignItems.CENTER, Background.CONTRAST_5, BorderRadius.MEDIUM, Display.FLEX, FontSize.SMALL,
                FontWeight.MEDIUM, Gap.SMALL, Height.MEDIUM, Padding.Horizontal.SMALL, "lg:pe-m", TextColor.BODY);
        link.add(LumoIcon.ARROW_LEFT.create(), label);

        ListItem item = new ListItem(link);
        item.addClassNames(Margin.End.AUTO);
        return item;
    }

    private ListItem createPageIndicator() {
        Span span = new Span("1 / 20");
        span.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        ListItem item = new ListItem(span);
        item.addClassNames(AlignItems.CENTER, Display.FLEX, Display.Breakpoint.Small.HIDDEN);
        return item;
    }

    private ListItem createPaginationLink(String text) {
        RouterLink link = new RouterLink(text, this.getClass());
        link.addClassNames(AlignItems.CENTER, Background.CONTRAST_5, "rounded-full", Display.FLEX, FontSize.SMALL,
                FontWeight.MEDIUM, Height.MEDIUM, JustifyContent.CENTER, TextColor.BODY, Width.MEDIUM);

        ListItem item = new ListItem(link);
        item.addClassNames(Display.HIDDEN, Display.Breakpoint.Small.FLEX);
        return item;
    }

    private ListItem createPaginationDots() {
        Span span = new Span("...");
        span.addClassNames(AlignItems.CENTER, Display.FLEX, FontWeight.MEDIUM, Height.MEDIUM, JustifyContent.CENTER,
                TextColor.SECONDARY, Width.MEDIUM);

        ListItem item = new ListItem(span);
        item.addClassNames(Display.HIDDEN, Display.Breakpoint.Small.FLEX);
        return item;
    }

    private ListItem createPaginationNextLink() {
        Span label = new Span("Next");
        label.addClassNames(Accessibility.SCREEN_READER_ONLY, "lg:not-sr-only");

        RouterLink link = new RouterLink(this.getClass());
        link.addClassNames(AlignItems.CENTER, Background.CONTRAST_5, BorderRadius.MEDIUM, Display.FLEX, FontSize.SMALL,
                FontWeight.MEDIUM, Gap.SMALL, Height.MEDIUM, Padding.Horizontal.SMALL, "lg:ps-m", TextColor.BODY);
        link.add(label, LumoIcon.ARROW_RIGHT.create());

        ListItem item = new ListItem(link);
        item.addClassNames(Margin.Start.AUTO);
        return item;
    }
}
