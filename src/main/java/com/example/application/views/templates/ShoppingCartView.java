package com.example.application.views.templates;

import com.example.application.components.InputGroup;
import com.example.application.components.KeyValuePair;
import com.example.application.components.KeyValuePairs;
import com.example.application.components.Layout;
import com.example.application.components.list.ShoppingCartListItem;
import com.example.application.components.list.UnorderedList;
import com.example.application.themes.ButtonTheme;
import com.example.application.themes.InputTheme;
import com.example.application.utilities.BoxSizing;
import com.example.application.utilities.Gap;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Shopping cart")
@Route(value = "shopping-cart", layout = MainLayout.class)
public class ShoppingCartView extends Main {

    public ShoppingCartView() {
        addClassNames(LumoUtility.AlignItems.START, LumoUtility.Display.FLEX, LumoUtility.FlexWrap.WRAP,
                LumoUtility.JustifyContent.CENTER);
        add(createShoppingCart(), createSummary());
    }

    private Component createShoppingCart() {
        H2 title = new H2("Items (3)");
        title.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.Margin.Top.XLARGE);

        UnorderedList list = new UnorderedList(
                new ShoppingCartListItem(
                        "https://images.unsplash.com/photo-1610136649349-0f646f318053?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=320&q=80",
                        "Black framed sunglasses on white table",
                        "Sunglasses 001",
                        "Introducing the ZephyrBlaze HyperShade sunglasses, a cosmic fusion of neon splashes and techno-textured frames. These avant-garde shades defy gravity, turning sunbeams into pixelated rainbows.",
                        "550,00 €"
                ),
                new ShoppingCartListItem(
                        "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=320&q=80",
                        "Flatlay photography of wireless headphones",
                        "Headphones 002",
                        "Introducing the SonicWave Pulse headphones, where sound dances through the cosmos in harmonious symphony. Immerse yourself in a sonic nebula of crystal resonances and ethereal beats.",
                        "2 750,00 €"
                ),
                new ShoppingCartListItem(
                        "https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=320&q=80",
                        "Unpaired red Nike sneaker",
                        "Sneakers 003",
                        "Step into the TechnoGlide Sneakers, where each stride unleashes a kinetic surge of energy. Crafted from quantum mesh and quantum foam, these sneakers defy gravity and pulse with a rhythm only known to the cosmos.",
                        "650,00 €"
                )
        );
        list.setHorizontalDividers(true);

        Section section = new Section(title, list);
        section.addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.MaxWidth.SCREEN_SMALL, LumoUtility.Padding.Horizontal.LARGE);
        return section;
    }

    private Component createSummary() {
        H2 title = new H2("Order summary");
        title.addClassNames(LumoUtility.FontSize.XLARGE);

        KeyValuePairs pairs = new KeyValuePairs(
                new KeyValuePair("Subtotal", "3 950,00 €"),
                new KeyValuePair("Delivery", "0,00 €"),
                new KeyValuePair("Total", "3 950,00 €")
        );
        pairs.setHorizontalDividers(true);
        pairs.setKeyWidthFull();
        pairs.removeBackgroundColor();
        pairs.removeHorizontalPadding();

        TextField code = new TextField("Enter a promo code");
        code.addClassNames(LumoUtility.Flex.GROW);
        code.addThemeName(InputTheme.OUTLINE);

        Button apply = new Button("Apply");
        apply.addClassNames(LumoUtility.Background.BASE);
        apply.addThemeName(ButtonTheme.OUTLINE);

        InputGroup inputGroup = new InputGroup(code, apply);

        RouterLink checkout = new RouterLink("Checkout", CheckoutView.class);
        checkout.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.Background.PRIMARY,
                LumoUtility.BorderRadius.MEDIUM, LumoUtility.Display.FLEX, LumoUtility.FontWeight.SEMIBOLD,
                LumoUtility.Height.MEDIUM, LumoUtility.JustifyContent.CENTER, LumoUtility.TextColor.PRIMARY_CONTRAST);

        Layout layout = new Layout(title, pairs, inputGroup, checkout);
        layout.addClassNames(LumoUtility.Background.CONTRAST_5, LumoUtility.BorderRadius.LARGE, LumoUtility.Padding.LARGE);
        layout.setBoxSizing(BoxSizing.BORDER);
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setGap(Gap.MEDIUM);

        Section section = new Section(layout);
        section.addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.Flex.GROW, LumoUtility.Padding.LARGE);
        section.setMaxWidth(24, Unit.REM);
        return section;
    }

}
