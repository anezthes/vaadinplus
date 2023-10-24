package com.example.application.views.templates;

import com.example.application.components.Layout;
import com.example.application.components.NativeDialog;
import com.example.application.components.PriceRange;
import com.example.application.components.list.List;
import com.example.application.components.list.ProductListItem;
import com.example.application.themes.RadioButtonTheme;
import com.example.application.utilities.Gap;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
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
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Product List")
@Route(value = "product-list", layout = MainLayout.class)
public class ProductListView extends Main {

    private Section sidebar;

    public ProductListView() {
        addClassNames(Display.FLEX, Height.FULL, Overflow.HIDDEN);
        add(createSidebar(), createContent());
    }

    public Component createContent() {
        Layout content = new Layout(createToolbar(), createList());
        content.addClassNames(Flex.GROW);
        content.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        content.setOverflow(com.example.application.utilities.Overflow.HIDDEN);
        return content;
    }

    public Component createToolbar() {
        TextField search = new TextField();
        search.addClassNames(Flex.GROW, MinWidth.NONE);
        search.setAriaLabel("Search");
        search.setPlaceholder("Search...");
        search.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());

        MultiSelectComboBox brands = new MultiSelectComboBox<>();
        brands.addClassNames(MinWidth.NONE);
        brands.setAriaLabel("Brands");
        brands.setItems("LuxeLiving", "DecoHaven", "CasaCharm", "HomelyCraft", "ArtisanHaus");
        brands.setPlaceholder("Brands");

        Button price = new Button("Price");
        price.setIcon(new Icon("lumo", "angle-down"));
        price.setIconAfterText(true);

        PriceRange priceRange = new PriceRange("Price");
        priceRange.addClassNames(Margin.SMALL, Padding.Top.XSMALL);
        priceRange.setWidth(16, Unit.REM);

        NativeDialog priceDialog = new NativeDialog(priceRange);
        priceDialog.setRight(8, Unit.REM);
        priceDialog.setTop(7.5f, Unit.REM);
        price.addClickListener(e -> priceDialog.showModal());

        Button filters = new Button("Filters", LineAwesomeIcon.SLIDERS_H_SOLID.create());
        filters.addClickListener(e -> this.sidebar.setVisible(!this.sidebar.isVisible()));

        RadioButtonGroup<String> mode = new RadioButtonGroup();
        mode.setAriaLabel("View mode");
        mode.setItems("Grid", "List");
        mode.setRenderer(new ComponentRenderer<>(item -> renderIconWithAriaLabel(item)));
        mode.setValue("Grid");
        setRadioButtonGroupTheme(mode, RadioButtonTheme.TOGGLE);

        Layout toolbar = new Layout(search, brands, price, priceDialog, filters, mode);
        toolbar.addClassNames(Border.BOTTOM, BorderColor.CONTRAST_10, Padding.Horizontal.LARGE, Padding.Vertical.SMALL);
        toolbar.setAlignItems(FlexComponent.Alignment.CENTER);
        toolbar.setGap(Gap.MEDIUM);
        return toolbar;
    }

    private Component renderIconWithAriaLabel(String item) {
        Component icon = item.equals("Grid") ?
                LineAwesomeIcon.TH_SOLID.create() :
                LineAwesomeIcon.LIST_SOLID.create();
        icon.getElement().setAttribute("aria-label", item);
        return icon;
    }

    public Component createList() {
        List list = new List();
        list.setAutoFill(320, Unit.PIXELS);
        list.setOverflow(com.example.application.utilities.Overflow.AUTO);

        list.add(
                new ProductListItem(
                        "https://images.unsplash.com/photo-1511884642898-4c92249e20b6?w=640",
                        "Aerial shot of forest",
                        "SparkleClean", "8,99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1434725039720-aaad6dd32dfe?w=640",
                        "Photo of green grass field at sunrise",
                        "FlexiFit", "24,99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1532274402911-5a369e4c4bb5?w=640",
                        "Brown wooden dock between lavender flower field near body of water during golden hour",
                        "ChillBliss", "11.99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1501785888041-af3ef285b470?w=640",
                        "Three brown wooden boat on blue lake water taken at daytime",
                        "BrewMist", "16,99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1470770841072-f978cf4d019e?w=640",
                        "Brown house near body of water",
                        "SnapTunes", "59,99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1433838552652-f9a46b332c40?w=640",
                        "Hot air balloon contest",
                        "PetPawfect", "99,99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1419242902214-272b3f66ee7a?w=640",
                        "Silhouette photo of mountain during night time",
                        "PowerGlide", "379,99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                ),
                new ProductListItem(
                        "https://images.unsplash.com/photo-1468276311594-df7cb65d8df6?w=640",
                        "Milky way above body of water",
                        "DreamScent", "21,99 €",
                        createIconButton(LineAwesomeIcon.HEART, "Favourite")
                )
        );
        return list;
    }

    private Button createIconButton(LineAwesomeIcon icon, String ariaLabel) {
        Button button = new Button(icon.create());
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        button.setAriaLabel(ariaLabel);
        return button;
    }

    private void setRadioButtonGroupTheme(RadioButtonGroup group, String... themeNames) {
        group.addThemeNames(themeNames);
        group.getChildren().forEach(component -> {
            for (String themeName : themeNames) {
                component.getElement().getThemeList().add(themeName);
            }
        });
    }

    private Section createSidebar() {
        H2 title = new H2("Filters");
        title.addClassNames(FontSize.MEDIUM, Padding.Vertical.XSMALL);

        Layout header = new Layout(title);
        header.addClassNames(Padding.Horizontal.LARGE, Padding.Vertical.MEDIUM);
        header.setAlignItems(FlexComponent.Alignment.CENTER);

        CheckboxGroup brands = new CheckboxGroup("Brands");
        brands.setItems("LuxeLiving", "DecoHaven", "CasaCharm", "HomelyCraft", "ArtisanHaus");
        brands.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);

        PriceRange priceRange = new PriceRange("Price");

        CheckboxGroup rating = new CheckboxGroup("Rating");
        rating.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        rating.setItems("★☆☆☆☆", "★★☆☆☆", "★★★☆☆", "★★★★☆", "★★★★★");
        rating.setRenderer(new ComponentRenderer(item -> {
            Span span = new Span(item.toString());
            span.getElement().setAttribute("aria-hidden", "true");

            Span screenReader = new Span(item.toString().chars().filter(ch -> ch == '★').count() + " star(s)");
            screenReader.addClassNames(Accessibility.SCREEN_READER_ONLY);

            return new Span(span, screenReader);
        }));

        CheckboxGroup availability = new CheckboxGroup("Availability");
        availability.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        availability.setItems("In stock (72)", "Out of stock (4)");

        Layout form = new Layout(brands, priceRange, rating, availability);
        form.addClassNames(Padding.Horizontal.LARGE);
        form.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        this.sidebar = new Section(header, form);
        this.sidebar.addClassNames(Border.RIGHT, BorderColor.CONTRAST_10, Display.FLEX, FlexDirection.COLUMN);
        this.sidebar.setWidth(20, Unit.REM);
        return this.sidebar;
    }

}
