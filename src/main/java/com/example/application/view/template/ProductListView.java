package com.example.application.view.template;

import com.example.application.component.Badge;
import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.component.PriceRange;
import com.example.application.component.list.List;
import com.example.application.component.list.ProductListItem;
import com.example.application.theme.RadioButtonTheme;
import com.example.application.utility.BadgeVariant;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.popover.Popover;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

import java.util.Random;

@PageTitle("Product list")
@Route(value = "product-list", layout = MainLayout.class)
public class ProductListView extends Main {

    private final Random random = new Random();
    private Section sidebar;

    public ProductListView() {
        addClassNames(Display.FLEX, Height.FULL, Overflow.HIDDEN);
        add(createSidebar(), createContent());
        closeSidebar();
    }

    private Section createSidebar() {
        H2 title = new H2("Filters");
        title.addClassNames(FontSize.MEDIUM);

        Button close = new Button(MaterialSymbol.CLOSE.create(), e -> closeSidebar());
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        close.setAriaLabel("Close sidebar");
        close.setTooltipText("Close sidebar");

        Layout header = new Layout(title, close);
        header.addClassNames(Padding.End.MEDIUM, Padding.Start.LARGE, Padding.Vertical.SMALL);
        header.setAlignItems(Layout.AlignItems.CENTER);
        header.setJustifyContent(Layout.JustifyContent.BETWEEN);

        CheckboxGroup<String> brands = new CheckboxGroup<>("Brands");
        brands.setItems("LuxeLiving", "DecoHaven", "CasaCharm", "HomelyCraft", "ArtisanHaus");
        brands.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        setRenderer(brands);

        PriceRange priceRange = new PriceRange("Price");

        CheckboxGroup<String> rating = new CheckboxGroup<>("Rating");
        rating.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        rating.setItems("1 star", "2 stars", "3 stars", "4 stars", "5 stars");
        rating.setRenderer(new ComponentRenderer<>(item -> {
            String count = Integer.toString(this.random.nextInt(100));

            Badge badge = new Badge(count);
            badge.addThemeVariants(BadgeVariant.CONTRAST, BadgeVariant.SMALL, BadgeVariant.PILL);

            int stars = Integer.parseInt(item.split(" ")[0]);

            Span span = new Span(getStars(stars), badge);
            span.addClassNames(AlignItems.CENTER, Display.FLEX, Gap.SMALL);
            span.getElement().setAttribute("aria-hidden", "true");

            Span screenReader = new Span(item + ", " + count + " items");
            screenReader.addClassNames(Accessibility.SCREEN_READER_ONLY);

            return new Span(span, screenReader);
        }));

        CheckboxGroup<String> availability = new CheckboxGroup<>("Availability");
        availability.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        availability.setItems("In stock", "Out of stock");
        setRenderer(availability);

        Layout form = new Layout(brands, priceRange, rating, availability);
        form.addClassNames(Padding.Horizontal.LARGE);
        form.setFlexDirection(Layout.FlexDirection.COLUMN);

        this.sidebar = new Section(header, form);
        this.sidebar.addClassNames(BackdropBlur.SMALL, Background.TINT_90, Border.RIGHT, Display.FLEX,
                FlexDirection.COLUMN, Position.ABSOLUTE, Position.Breakpoint.Large.STATIC, Position.Bottom.NONE,
                Position.Top.NONE, Transition.ALL, ZIndex.XSMALL);
        this.sidebar.setWidth(20, Unit.REM);
        return this.sidebar;
    }

    private void setRenderer(CheckboxGroup<String> checkboxGroup) {
        checkboxGroup.setRenderer(new ComponentRenderer<>(item -> {
            Badge badge = new Badge(Integer.toString(this.random.nextInt(100)));
            badge.addThemeVariants(BadgeVariant.CONTRAST, BadgeVariant.SMALL, BadgeVariant.PILL);

            Span span = new Span(new Text(item), badge);
            span.addClassNames(AlignItems.CENTER, Display.FLEX, Gap.SMALL);
            return span;
        }));
    }

    private Text getStars(int stars) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (i < stars) {
                builder.append("★");
            } else {
                builder.append("☆");
            }
        }
        return new Text(builder.toString());
    }

    public Component createContent() {
        Layout content = new Layout(createToolbar(), createList());
        content.addClassNames(Flex.GROW);
        content.setFlexDirection(Layout.FlexDirection.COLUMN);
        content.setOverflow(Layout.Overflow.HIDDEN);
        return content;
    }

    public Component createToolbar() {
        TextField search = new TextField();
        search.addClassNames(Flex.GROW, MinWidth.NONE);
        search.setAriaLabel("Search");
        search.setPlaceholder("Search...");
        search.setPrefixComponent(MaterialSymbol.SEARCH.create());

        MultiSelectComboBox<String> brands = new MultiSelectComboBox<>();
        brands.addClassNames(Display.HIDDEN, Display.Breakpoint.Large.INLINE_FLEX, MinWidth.NONE);
        brands.setAriaLabel("Brands");
        brands.setItems("LuxeLiving", "DecoHaven", "CasaCharm", "HomelyCraft", "ArtisanHaus");
        brands.setPlaceholder("Brands");

        Button price = new Button("Price");
        price.addClassNames(Display.HIDDEN, Display.Breakpoint.Large.INLINE_BLOCK);
        price.setIcon(new Icon("lumo", "angle-down"));
        price.setIconAfterText(true);

        PriceRange priceRange = new PriceRange("Price");
        priceRange.addClassNames(Margin.SMALL, Padding.Top.XSMALL);
        priceRange.setWidth(16, Unit.REM);

        Popover priceDialog = new Popover(priceRange);
        priceDialog.setTarget(price);

        // TODO: a11y improvements, opened/closed states
        Button filters = new Button("Filters", MaterialSymbol.FILTER_LIST.create());
        filters.addClickListener(e -> toggleSidebar());

        RadioButtonGroup<String> mode = new RadioButtonGroup<>();
        mode.setAriaLabel("View mode");
        mode.setItems("Grid", "List");
        mode.setRenderer(new ComponentRenderer<>(this::renderIconWithAriaLabel));
        mode.setValue("Grid");
        setRadioButtonGroupTheme(mode, RadioButtonTheme.TOGGLE);

        Layout toolbar = new Layout(search, brands, price, priceDialog, filters, mode);
        toolbar.addClassNames(Border.BOTTOM, Padding.Horizontal.LARGE, Padding.Vertical.SMALL);
        toolbar.setAlignItems(Layout.AlignItems.CENTER);
        toolbar.setGap(Layout.Gap.MEDIUM);
        return toolbar;
    }

    private void toggleSidebar() {
        if (this.sidebar.isEnabled()) {
            closeSidebar();
        } else {
            openSidebar();
        }
    }

    private void openSidebar() {
        this.sidebar.setEnabled(true);
        this.sidebar.addClassNames(Border.RIGHT);
        // Desktop
        this.sidebar.getStyle().remove("margin-inline-start");
        // Mobile
        this.sidebar.addClassNames(Position.Start.NONE);
        this.sidebar.removeClassName(Position.Minus.Start.FULL);
    }

    private void closeSidebar() {
        this.sidebar.setEnabled(false);
        this.sidebar.removeClassName(Border.RIGHT);
        // Desktop
        this.sidebar.getStyle().set("margin-inline-start", "-20rem");
        // Mobile
        this.sidebar.addClassNames(Position.Minus.Start.FULL);
        this.sidebar.removeClassName(Position.Start.NONE);
    }

    private Component renderIconWithAriaLabel(String item) {
        Component icon = item.equals("Grid") ?
                MaterialSymbol.GRID_VIEW.create() :
                MaterialSymbol.VIEW_LIST.create();
        icon.getElement().setAttribute("aria-label", item);
        return icon;
    }

    public Component createList() {
        List list = new List();
        list.setAutoFill(320, Unit.PIXELS);
        list.setOverflow(Layout.Overflow.AUTO);

        list.add(
                new ProductListItem(
                        "https://images.unsplash.com/photo-1511884642898-4c92249e20b6?w=640",
                        "Aerial shot of forest",
                        "SparkleClean", "8,99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite SparkleClean")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1434725039720-aaad6dd32dfe?w=640",
                        "Photo of green grass field at sunrise",
                        "FlexiFit", "24,99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite FlexiFit")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1532274402911-5a369e4c4bb5?w=640",
                        "Brown wooden dock between lavender flower field near body of water during golden hour",
                        "ChillBliss", "11.99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite ChillBliss")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=640",
                        "Three brown wooden boat on blue lake water taken at daytime",
                        "BrewMist", "16,99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite BrewMist")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1470770841072-f978cf4d019e?w=640",
                        "Brown house near body of water",
                        "SnapTunes", "59,99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite SnapTunes")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1433838552652-f9a46b332c40?w=640",
                        "Hot air balloon contest",
                        "PetPawfect", "99,99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite PetPawfect")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1419242902214-272b3f66ee7a?w=640",
                        "Silhouette photo of mountain during night time",
                        "PowerGlide", "379,99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite PowerGlide")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1468276311594-df7cb65d8df6?w=640",
                        "Milky way above body of water",
                        "DreamScent", "21,99 €",
                        createIconButton(MaterialSymbol.FAVORITE, "Favourite DreamScent")
                )
        );
        return list;
    }

    private Button createIconButton(MaterialSymbol symbol, String label) {
        Button button = new Button(symbol.create());
        button.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);
        button.setAriaLabel(label);
        button.setTooltipText(label);
        return button;
    }

    private void setRadioButtonGroupTheme(RadioButtonGroup<String> group, String... themeNames) {
        group.addThemeNames(themeNames);
        group.getChildren().forEach(component -> {
            for (String themeName : themeNames) {
                component.getElement().getThemeList().add(themeName);
            }
        });
    }

}
