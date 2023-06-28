package com.example.application.views.templates;

import com.example.application.components.Breadcrumb;
import com.example.application.components.Layout;
import com.example.application.themes.RadioButtonTheme;
import com.example.application.utilities.GridColumns;
import com.example.application.views.MainLayout;
import com.example.application.views.components.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.stream.Collectors;

@PageTitle("Product")
@Route(value = "product", layout = MainLayout.class)
public class ProductView extends Main {

    private String img1 = "https://images.unsplash.com/photo-1507668077129-56e32842fceb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=400";
    private String alt1 = "Clear glass bulb on human palm ⋅ Rohan Makhecha ⋅ Unsplash";

    private String img2 = "https://images.unsplash.com/photo-1507668077129-56e32842fceb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=400";
    private String alt2 = "Clear glass bulb on human palm ⋅ Rohan Makhecha ⋅ Unsplash";

    private String img3 = "https://images.unsplash.com/photo-1507668077129-56e32842fceb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=400";
    private String alt3 = "Clear glass bulb on human palm ⋅ Rohan Makhecha ⋅ Unsplash";

    private String img4 = "https://images.unsplash.com/photo-1507668077129-56e32842fceb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=400";
    private String alt4 = "Clear glass bulb on human palm ⋅ Rohan Makhecha ⋅ Unsplash";

    private String img5 = "https://images.unsplash.com/photo-1507668077129-56e32842fceb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=400";
    private String alt5 = "Clear glass bulb on human palm ⋅ Rohan Makhecha ⋅ Unsplash";

    public ProductView() {
        addClassNames(AlignItems.START, Display.FLEX, FlexDirection.COLUMN, FlexDirection.Breakpoint.Small.ROW,
                Gap.XLARGE, JustifyContent.CENTER, Padding.LARGE);
        add(createImages(), createInformation());
    }

    public Component createImages() {
        Layout images = new Layout(
                createPreview(),
                createThumbnails()
        );
        images.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        images.setGap(com.example.application.utilities.Gap.MEDIUM);
        images.setMaxWidth(100, Unit.PERCENTAGE);
        images.setWidth(24, Unit.REM);
        return images;
    }

    public Component createPreview() {
        Image img = new Image(this.img1, this.alt1);
        img.setWidthFull();

        Layout preview = new Layout(img);
        preview.addClassNames("aspect-square", BorderRadius.LARGE, BoxShadow.SMALL, Overflow.HIDDEN);
        preview.setAlignItems(FlexComponent.Alignment.CENTER);
        preview.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        preview.setWidthFull();
        return preview;
    }

    public Component createThumbnails() {
        Layout thumbnails = new Layout(
                createThumbnail(this.img2, this.alt2),
                createThumbnail(this.img3, this.alt3),
                createThumbnail(this.img4, this.alt4),
                createThumbnail(this.img5, this.alt5)
        );
        thumbnails.setDisplay(com.example.application.utilities.Display.GRID);
        thumbnails.setGap(com.example.application.utilities.Gap.MEDIUM);
        thumbnails.setGridColumns(GridColumns.COLUMNS_4);
        return thumbnails;
    }

    public Component createThumbnail(String src, String alt) {
        Image img = new Image(src, alt);
        img.setWidthFull();

        Layout thumbnail = new Layout(img);
        thumbnail.addClassNames("aspect-square", BorderRadius.LARGE, BoxShadow.SMALL, Overflow.HIDDEN);
        thumbnail.setAlignItems(FlexComponent.Alignment.CENTER);
        thumbnail.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        return thumbnail;
    }

    public Component createInformation() {
        Breadcrumb breadcrumb = new Breadcrumb(
                new RouterLink("Link 1", HomeView.class),
                new RouterLink("Link 2", HomeView.class),
                new RouterLink("Link 3", HomeView.class)
        );
        breadcrumb.addClassNames(Margin.Bottom.XSMALL);

        Span stars = new Span("4.5 stars");
        stars.addClassNames(FontSize.SMALL, Margin.Start.XSMALL);

        Layout rating = new Layout(createStar(), createStar(), createStar(), createStar(), createHalfStar());
        rating.addClassNames(TextColor.PRIMARY);

        Button review = new Button("Write a review");
        review.addClassNames(Margin.Vertical.NONE);
        review.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_TERTIARY);

        Layout reviewLayout = new Layout(rating, stars, review);
        reviewLayout.addClassNames(Margin.Bottom.XSMALL, Margin.Top.MEDIUM);
        reviewLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        reviewLayout.setGap(com.example.application.utilities.Gap.SMALL);

        H2 title = new H2("Xyloflux");
        title.addClassNames(FontSize.XLARGE, Margin.Bottom.XSMALL, Margin.Top.MEDIUM);

        Span price = new Span("420,00 €");
        price.addClassNames(FontWeight.BOLD, Margin.Bottom.XSMALL, Margin.Top.NONE);

        Paragraph description = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        description.addClassNames(Margin.Bottom.LARGE, Margin.Top.MEDIUM);

        RadioButtonGroup<String> color = new RadioButtonGroup("Color scheme");
        color.setItems("Light", "Dark");
        color.setRenderer(new ComponentRenderer<>(item -> {
            if (item.equals("Light")) {
                return renderLabelWithDescription(item, "Minimalist and modern look, focused on readability " +
                        "and a soothing visual experience");
            } else {
                return renderLabelWithDescription(item, "Dramatic and immersive visual style, reduces eye " +
                        "strain in low-light environments");
            }
        }));
        setRadioButtonGroupTheme(color, RadioButtonTheme.BORDER_ONLY, RadioButtonTheme.GAP,
                RadioButtonTheme.EQUAL_WIDTH);

        RadioButtonGroup<String> intensity = new RadioButtonGroup("Sound intensity");
        intensity.setItems("Low", "High");
        intensity.setRenderer(new ComponentRenderer<>(item -> {
            if (item.equals("Low")) {
                return renderLabelWithDescription(item, "Creates soft and mellow sounds");
            } else {
                return renderLabelWithDescription(item, "Produces vibrant and energetic tones");
            }
        }));
        setRadioButtonGroupTheme(intensity, RadioButtonTheme.BORDER_ONLY, RadioButtonTheme.GAP,
                RadioButtonTheme.EQUAL_WIDTH);

        RadioButtonGroup<String> effects = new RadioButtonGroup("Lighting effects");
        effects.setItems("Solid", "Transitional");
        effects.setRenderer(new ComponentRenderer<>(item -> {
            if (item.equals("Solid")) {
                return renderLabelWithDescription(item, "Choose from a range of solid colors to illuminate the " +
                        "xylophone keys");
            } else {
                return renderLabelWithDescription(item, "Enjoy smooth color transitions that create a " +
                        "mesmerizing visual display");
            }
        }));
        setRadioButtonGroupTheme(effects, RadioButtonTheme.BORDER_ONLY, RadioButtonTheme.GAP,
                RadioButtonTheme.EQUAL_WIDTH);

        IntegerField quantity = new IntegerField("Quantity");
        quantity.setStepButtonsVisible(true);
        quantity.setValue(1);

        Button add = new Button("Add to cart");
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Layout quantityLayout = new Layout(quantity, add);
        quantityLayout.setAlignItems(FlexComponent.Alignment.BASELINE);
        quantityLayout.setDisplay(com.example.application.utilities.Display.GRID);
        quantityLayout.setGap(com.example.application.utilities.Gap.SMALL);
        quantityLayout.setGridColumns(GridColumns.COLUMNS_2);

        Details settings = createDetails("Performance Settings", "Users can customize the performance " +
                "settings of Xyloflux to optimize its speed and responsiveness. They can adjust parameters such as " +
                "animation smoothness, transition effects, and rendering quality based on their device capabilities " +
                "and preferences.");

        Details customization = createDetails("Theme Customization", "Xyloflux offers extensive theme " +
                "customization options, allowing users to personalize the visual appearance of the product. Users " +
                "can choose from a variety of color schemes, font styles, and layout options to create a unique and " +
                "tailored experience.");

        Details collaboration = createDetails("Collaboration Tools", "Xyloflux offers built-in " +
                "collaboration tools to facilitate teamwork and communication. Users can invite team members, assign " +
                "tasks, share files, and track project progress directly within the platform.");

        Layout details = new Layout(settings, customization, collaboration);
        details.addClassNames(Border.BOTTOM, BorderColor.CONTRAST_10, Margin.Bottom.MEDIUM, Margin.Top.LARGE);
        details.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        Layout layout = new Layout(breadcrumb, title, price, reviewLayout, description, color, intensity, effects,
                details, quantityLayout);
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setMaxWidth(32, Unit.REM);
        return layout;
    }

    private Component createStar() {
        Component star = LineAwesomeIcon.STAR_SOLID.create();
        ((HasSize) star).setHeight(com.example.application.utilities.IconSize.SMALL.getCSSVariable());
        ((HasSize) star).setWidth(com.example.application.utilities.IconSize.SMALL.getCSSVariable());
        return star;
    }

    private Component createHalfStar() {
        Component star = LineAwesomeIcon.STAR_HALF_SOLID.create();
        ((HasSize) star).setHeight(com.example.application.utilities.IconSize.SMALL.getCSSVariable());
        ((HasSize) star).setWidth(com.example.application.utilities.IconSize.SMALL.getCSSVariable());
        return star;
    }

    private Component renderLabelWithDescription(String title, String desc) {
        Span primary = new Span(title);

        Span secondary = new Span(desc);
        secondary.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        Layout layout = new Layout(primary, secondary);
        layout.addClassNames(Padding.XSMALL);
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setGap(com.example.application.utilities.Gap.XSMALL);
        return layout;
    }

    private void setRadioButtonGroupTheme(RadioButtonGroup group, String... themeNames) {
        group.addThemeNames(themeNames);
        for (Component component : group.getChildren().collect(Collectors.toList())) {
            for (String themeName : themeNames) {
                component.getElement().getThemeList().add(themeName);
            }
        }
    }

    private Details createDetails(String title, String description) {
        Span summary = new Span(title);
        summary.addClassNames(FontSize.SMALL);

        Span content = new Span(description);
        content.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Details details = new Details(summary, content);
        details.addClassNames(Border.TOP, BorderColor.CONTRAST_10, Margin.NONE, Padding.Vertical.MEDIUM);
        details.addThemeVariants(DetailsVariant.REVERSE);
        return details;
    }

}
