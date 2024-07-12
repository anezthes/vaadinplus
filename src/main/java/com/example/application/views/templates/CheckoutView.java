package com.example.application.views.templates;

import com.example.application.components.*;
import com.example.application.themes.ButtonTheme;
import com.example.application.themes.InputTheme;
import com.example.application.themes.RadioButtonTheme;
import com.example.application.utilities.Breakpoint;
import com.example.application.utilities.Size;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@PageTitle("Checkout")
@Route(value = "checkout", layout = MainLayout.class)
public class CheckoutView extends Main {

    public CheckoutView() {
        addClassNames(BoxSizing.BORDER, Display.FLEX, FlexDirection.COLUMN, FlexDirection.Breakpoint.Medium.ROW,
                Margin.Horizontal.AUTO, MaxWidth.SCREEN_LARGE);
        add(createForm(), createSummary());
    }

    public static LocalDate getNextBusinessDay(LocalDate date) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            date = date.plusDays(2);
        } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.plusDays(1);
        }
        return date;
    }

    private Component createForm() {
        Layout layout = new Layout(createShippingInformation(), createDeliveryMethod(), createPaymentInformation());
        layout.addClassNames(Padding.LARGE);
        layout.setBoxSizing(Layout.BoxSizing.BORDER);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    private Component createShippingInformation() {
        H2 title = new H2("Shipping information");
        title.addClassNames(FontSize.XLARGE, Margin.Bottom.SMALL, Margin.Top.MEDIUM);

        TextField address = new TextField("Address");
        TextField city = new TextField("City");
        ComboBox state = new ComboBox("State");
        TextField zip = new TextField("ZIP");

        TextField phone = new TextField("Phone");
        phone.setPrefixComponent(LineAwesomeIcon.PHONE_SOLID.create());

        EmailField email = new EmailField("Email");
        email.setPrefixComponent(LineAwesomeIcon.ENVELOPE.create());

        Layout layout = new Layout(title, address, city, state, zip, phone, email);
        // Viewport < 1024px
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        // Viewport > 1024px
        layout.setDisplay(Breakpoint.LARGE, Layout.Display.GRID);
        layout.setColumns(Layout.GridColumns.COLUMNS_4);
        layout.setColumnGap(Layout.Gap.MEDIUM);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_2, city, phone, email);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_FULL, title, address);
        return layout;
    }

    private Component createDeliveryMethod() {
        H2 title = new H2("Delivery method");
        title.addClassNames(FontSize.XLARGE, Margin.Bottom.SMALL, Margin.Top.XLARGE);

        RadioButtonGroup<DeliveryMethod> deliveryMethod = new RadioButtonGroup("Delivery method");
        deliveryMethod.setItems(DeliveryMethod.values());
        deliveryMethod.setRenderer(new ComponentRenderer<>(method -> renderDeliveryMethod(method)));
        deliveryMethod.setValue(DeliveryMethod.STANDARD);
        setRadioButtonGroupTheme(deliveryMethod, RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.TOGGLE);

        Layout layout = new Layout(title, deliveryMethod);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    private Component renderDeliveryMethod(DeliveryMethod method) {
        Span name = new Span(method.getDisplayName());
        name.addClassNames(FontWeight.MEDIUM);

        Span cost = new Span();

        Span date = new Span();
        date.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, MMM d, yyyy", Locale.ENGLISH);

        switch (method) {
            case STANDARD:
            default:
                cost.setText("Free");
                date.setText(getNextBusinessDay(today.plusDays(7)).format(formatter));
                break;

            case EXPRESS:
                cost.setText("42,00 €");
                date.setText(getNextBusinessDay(today.plusDays(2)).format(formatter));
                break;
        }

        Span primary = new Span(name, cost);
        primary.addClassNames(Display.FLEX, FlexWrap.WRAP, JustifyContent.BETWEEN);

        Span span = new Span(primary, date);
        span.addClassNames(Display.FLEX, Flex.GROW, FlexDirection.COLUMN,
                Gap.XSMALL, Padding.SMALL);
        return span;
    }

    private Component createPaymentInformation() {
        H2 title = new H2("Payment information");
        title.addClassNames(FontSize.XLARGE, Margin.Bottom.SMALL, Margin.Top.XLARGE);

        RadioButtonGroup<PaymentMethod> paymentMethod = new RadioButtonGroup("Payment method");
        paymentMethod.setItems(PaymentMethod.values());
        paymentMethod.setRenderer(new ComponentRenderer<>(method -> renderPaymentMethod(method)));
        paymentMethod.setValue(PaymentMethod.CREDIT_CARD);
        setRadioButtonGroupTheme(paymentMethod, RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.TOGGLE);

        TextField creditCard = new TextField("Card number");
        ExpirationDateField expiration = new ExpirationDateField("Expiration date");
        TextField securityCode = new TextField("Security code");

        Layout layout = new Layout(title, paymentMethod, creditCard, expiration, securityCode);
        // Viewport < 1024px
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        // Viewport > 1024px
        layout.setDisplay(Breakpoint.LARGE, Layout.Display.GRID);
        layout.setColumns(Layout.GridColumns.COLUMNS_2);
        layout.setColumnGap(Layout.Gap.MEDIUM);
        layout.setColumnSpan(Layout.ColumnSpan.COLUMN_SPAN_FULL, title, paymentMethod, creditCard);
        return layout;
    }

    private Component renderPaymentMethod(PaymentMethod method) {
        switch (method) {
            case CREDIT_CARD:
            default:
                return createCreditCard();

            case APPLE_PAY:
                return createImage("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Apple_Pay_logo.svg/2560px-Apple_Pay_logo.svg.png", method.getDisplayName());

            case PAYPAL:
                return createImage("https://upload.wikimedia.org/wikipedia/commons/b/b5/PayPal.svg", method.getDisplayName());

            case GOOGLE_PAY:
                return createImage("https://upload.wikimedia.org/wikipedia/commons/f/f2/Google_Pay_Logo.svg", method.getDisplayName());
        }
    }

    private Component createCreditCard() {
        Image visa = new Image("https://upload.wikimedia.org/wikipedia/commons/d/d6/Visa_2021.svg", "Visa");
        visa.setMaxHeight(Size.LARGE);
        visa.setMaxWidth(100, Unit.PERCENTAGE);

        Image mastercard = new Image("https://upload.wikimedia.org/wikipedia/commons/a/a4/Mastercard_2019_logo.svg", "Mastercard");
        mastercard.setMaxHeight(Size.LARGE);
        mastercard.setMaxWidth(100, Unit.PERCENTAGE);

        Span images = new Span(visa, mastercard);
        images.addClassNames(AlignItems.CENTER, BoxSizing.BORDER, Display.GRID,
                Gap.SMALL, Grid.Column.COLUMNS_2, Padding.SMALL);
        return images;
    }

    private Component createImage(String src, String alt) {
        Image img = new Image(src, alt);
        img.addClassNames(BoxSizing.BORDER, Margin.Horizontal.AUTO, Padding.SMALL);
        img.setMaxHeight(Size.LARGE);
        img.setMaxWidth(100, Unit.PERCENTAGE);
        return img;
    }

    private void setRadioButtonGroupTheme(RadioButtonGroup group, String... themeNames) {
        group.addThemeNames(themeNames);
        group.getChildren().forEach(component -> {
            for (String themeName : themeNames) {
                component.getElement().getThemeList().add(themeName);
            }
        });
    }

    private Component createSummary() {
        H2 title = new H2("Order summary");
        title.addClassNames(FontSize.XLARGE);

        KeyValuePairs pairs = new KeyValuePairs(
                new KeyValuePair("Subtotal", "3 950,00 €"),
                new KeyValuePair("Delivery", "0,00 €"),
                new KeyValuePair("Total", "3 950,00 €")
        );
        pairs.addClassNames("divide-y");
        pairs.setKeyWidthFull();
        pairs.removeBackgroundColor();
        pairs.removeHorizontalPadding();

        TextField code = new TextField("Enter a promo code");
        code.addClassNames(Flex.GROW);
        code.addThemeName(InputTheme.OUTLINE);

        Button apply = new Button("Apply");
        apply.addClassNames(Background.BASE);
        apply.addThemeName(ButtonTheme.OUTLINE);

        InputGroup inputGroup = new InputGroup(code, apply);

        RouterLink confirmOrder = new RouterLink("Confirm order", ShoppingCartView.class);
        confirmOrder.addClassNames(AlignItems.CENTER, Background.PRIMARY,
                BorderRadius.MEDIUM, Display.FLEX, FontWeight.SEMIBOLD,
                Height.MEDIUM, JustifyContent.CENTER, TextColor.PRIMARY_CONTRAST);

        Layout layout = new Layout(title, pairs, inputGroup, confirmOrder);
        layout.addClassNames(Background.CONTRAST_5, BorderRadius.LARGE, Padding.LARGE);
        layout.setBoxSizing(Layout.BoxSizing.BORDER);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        layout.setGap(Layout.Gap.MEDIUM);

        Section section = new Section(layout);
        section.addClassNames(BoxSizing.BORDER, Padding.LARGE);
        section.setMinWidth(24, Unit.REM);
        return section;
    }

    public enum DeliveryMethod {
        STANDARD("Standard delivery"),
        EXPRESS("Express delivery");

        private final String displayName;

        DeliveryMethod(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum PaymentMethod {
        CREDIT_CARD("Credit card"),
        PAYPAL("PayPal"),
        APPLE_PAY("Apple Pay"),
        GOOGLE_PAY("Google Pay");

        private final String displayName;

        PaymentMethod(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

}
