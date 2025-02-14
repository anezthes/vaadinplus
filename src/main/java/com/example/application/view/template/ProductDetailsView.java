package com.example.application.view.template;

import com.example.application.component.Breadcrumb;
import com.example.application.component.BreadcrumbItem;
import com.example.application.component.Layout;
import com.example.application.theme.RadioButtonTheme;
import com.example.application.view.HomeView;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Product details")
@Route(value = "product-details", layout = MainLayout.class)
public class ProductDetailsView extends Main {

    private String img1 = "https://images.unsplash.com/photo-1507668077129-56e32842fceb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=400";
    private String alt1 = "Clear glass bulb on human palm ⋅ Rohan Makhecha ⋅ Unsplash";

    private String img2 = "https://images.unsplash.com/photo-1520532622976-1bdf3b7a5af9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=100";
    private String alt2 = "Clear glass light bulb on sand during daytime ⋅ Glen Carrie ⋅ Unsplash";

    private String img3 = "https://images.unsplash.com/photo-1567177662154-dfeb4c93b6ae?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=100";
    private String alt3 = "Selective focus photography of light bulb ⋅ Ameen Fahmy ⋅ Unsplash";

    private String img4 = "https://images.unsplash.com/photo-1573621622238-f7ac6ac0429a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=100";
    private String alt4 = "Hanging black and clear light bulb turned on ⋅ Jonathan Borba ⋅ Unsplash";

    public ProductDetailsView() {
        addClassNames(Display.FLEX, FlexWrap.WRAP_REVERSE, JustifyContent.CENTER);
        add(createInformation(), createImages());
    }

    public Component createImages() {
        Layout images = new Layout(
                createPreview(),
                createThumbnails()
        );
        images.addClassNames(Padding.LARGE);
        images.setAlignSelf(Layout.AlignSelf.END);
        images.setBoxSizing(Layout.BoxSizing.BORDER);
        images.setFlexDirection(Layout.FlexDirection.COLUMN);
        images.setGap(Layout.Gap.MEDIUM);
        images.setMaxWidth(24, Unit.REM);
        return images;
    }

    public Component createPreview() {
        Image img = new Image(this.img1, this.alt1);
        img.setWidthFull();

        Layout preview = new Layout(img);
        preview.addClassNames("aspect-square", BorderRadius.LARGE, BoxShadow.SMALL);
        preview.setAlignItems(Layout.AlignItems.CENTER);
        preview.setJustifyContent(Layout.JustifyContent.CENTER);
        preview.setOverflow(Layout.Overflow.HIDDEN);
        preview.setWidthFull();
        return preview;
    }

    public Component createThumbnails() {
        // TODO: Accessibility, use tabs or radio buttons
        Layout thumbnails = new Layout(
                createThumbnail(this.img1, this.alt1),
                createThumbnail(this.img2, this.alt2),
                createThumbnail(this.img3, this.alt3),
                createThumbnail(this.img4, this.alt4)
        );
        thumbnails.setColumns(Layout.GridColumns.COLUMNS_4);
        thumbnails.setDisplay(Layout.Display.GRID);
        thumbnails.setGap(Layout.Gap.MEDIUM);
        return thumbnails;
    }

    public Component createThumbnail(String src, String alt) {
        Image img = new Image(src, alt);
        img.setWidthFull();

        Layout thumbnail = new Layout(img);
        thumbnail.addClassNames("aspect-square", BorderRadius.LARGE, BoxShadow.SMALL, Overflow.HIDDEN);
        thumbnail.setAlignItems(Layout.AlignItems.CENTER);
        thumbnail.setJustifyContent(Layout.JustifyContent.CENTER);
        return thumbnail;
    }

    public Component createInformation() {
        Breadcrumb breadcrumb = new Breadcrumb(
                new BreadcrumbItem("Home", HomeView.class),
                new BreadcrumbItem("Products", ProductListView.class),
                new BreadcrumbItem("Xyloflux", ProductDetailsView.class)
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
        reviewLayout.setAlignItems(Layout.AlignItems.CENTER);
        reviewLayout.setGap(Layout.Gap.SMALL);

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
        setRadioButtonGroupTheme(color, RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.GAP, RadioButtonTheme.TOGGLE);

        RadioButtonGroup<String> intensity = new RadioButtonGroup("Sound intensity");
        intensity.setItems("Low", "High");
        intensity.setRenderer(new ComponentRenderer<>(item -> {
            if (item.equals("Low")) {
                return renderLabelWithDescription(item, "Creates soft and mellow sounds");
            } else {
                return renderLabelWithDescription(item, "Produces vibrant and energetic tones");
            }
        }));
        setRadioButtonGroupTheme(intensity, RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.GAP, RadioButtonTheme.TOGGLE);

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
        setRadioButtonGroupTheme(effects, RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.GAP, RadioButtonTheme.TOGGLE);

        IntegerField quantity = new IntegerField("Quantity");
        quantity.setStepButtonsVisible(true);
        quantity.setValue(1);

        Button add = new Button("Add to cart");
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Layout quantityLayout = new Layout(quantity, add);
        quantityLayout.setAlignItems(Layout.AlignItems.BASELINE);
        quantityLayout.setColumns(Layout.GridColumns.COLUMNS_2);
        quantityLayout.setDisplay(Layout.Display.GRID);
        quantityLayout.setGap(Layout.Gap.SMALL);

        Details settings = createDetails("Performance settings", "Users can customize the performance " +
                "settings of Xyloflux to optimize its speed and responsiveness. They can adjust parameters such as " +
                "animation smoothness, transition effects, and rendering quality based on their device capabilities " +
                "and preferences.");

        Details customization = createDetails("Theme customization", "Xyloflux offers extensive theme " +
                "customization options, allowing users to personalize the visual appearance of the product. Users " +
                "can choose from a variety of color schemes, font styles, and layout options to create a unique and " +
                "tailored experience.");

        Details collaboration = createDetails("Collaboration tools", "Xyloflux offers built-in " +
                "collaboration tools to facilitate teamwork and communication. Users can invite team members, assign " +
                "tasks, share files, and track project progress directly within the platform.");

        Layout details = new Layout(settings, customization, collaboration);
        details.addClassNames(Border.BOTTOM, Margin.Bottom.MEDIUM, Margin.Top.LARGE);
        details.setFlexDirection(Layout.FlexDirection.COLUMN);

        Layout layout = new Layout(breadcrumb, title, price, reviewLayout, description, color, intensity, effects,
                details, quantityLayout);
        layout.addClassNames(BoxSizing.BORDER, MaxWidth.SCREEN_SMALL, Padding.LARGE);
        layout.setBoxSizing(Layout.BoxSizing.BORDER);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    private Component createStar() {
        SvgIcon star = LineAwesomeIcon.STAR_SOLID.create();
        star.addClassNames(IconSize.SMALL);
        return star;
    }

    private Component createHalfStar() {
        SvgIcon star = LineAwesomeIcon.STAR_HALF_SOLID.create();
        star.addClassNames(IconSize.SMALL);
        return star;
    }

    private Component renderLabelWithDescription(String title, String desc) {
        Span primary = new Span(title);

        Span secondary = new Span(desc);
        secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Layout layout = new Layout(primary, secondary);
        layout.addClassNames(Padding.SMALL);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        layout.setGap(Layout.Gap.XSMALL);
        return layout;
    }

    private void setRadioButtonGroupTheme(RadioButtonGroup group, String... themeNames) {
        group.addThemeNames(themeNames);
        group.getChildren().forEach(component -> {
            for (String themeName : themeNames) {
                component.getElement().getThemeList().add(themeName);
            }
        });
    }

    private Details createDetails(String title, String description) {
        Span summary = new Span(title);
        summary.addClassNames(FontSize.SMALL);

        Span content = new Span(description);
        content.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Details details = new Details(summary, content);
        details.addClassNames(Border.TOP, Margin.Vertical.NONE, Padding.Vertical.MEDIUM);
        details.addThemeVariants(DetailsVariant.REVERSE);
        return details;
    }

}
