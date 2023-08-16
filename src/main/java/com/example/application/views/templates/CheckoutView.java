package com.example.application.views.templates;

import com.example.application.components.ExpirationDateField;
import com.example.application.components.Layout;
import com.example.application.utilities.*;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Checkout")
@Route(value = "checkout", layout = MainLayout.class)
public class CheckoutView extends Main {

    public CheckoutView() {
        addClassNames(LumoUtility.Display.FLEX, LumoUtility.FlexWrap.WRAP, LumoUtility.JustifyContent.CENTER);
        add(createForm());
    }

    private Component createForm() {
        Layout layout = new Layout(createShippingInformation(), createPaymentInformation());
        layout.addClassNames(LumoUtility.MaxWidth.SCREEN_SMALL, LumoUtility.Padding.LARGE);
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        return layout;
    }

    private Component createShippingInformation() {
        H2 title = new H2("Shipping information");
        title.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.Margin.Bottom.SMALL, LumoUtility.Margin.Top.MEDIUM);

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
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        // Viewport > 1024px
        layout.setDisplay(Breakpoint.LARGE, Display.GRID);
        layout.setColumnGap(Gap.MEDIUM);
        layout.setGridColumns(GridColumns.COLUMNS_4);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_2, city, phone, email);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_FULL, title, address);
        return layout;
    }

    private Component createPaymentInformation() {
        H2 title = new H2("Payment information");
        title.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.Margin.Bottom.SMALL, LumoUtility.Margin.Top.XLARGE);

        RadioButtonGroup method = new RadioButtonGroup("Payment method");
        method.setItems("Credit/debit card", "PayPal", "Apple Pay", "Google Pay", "Bank transfer");

        TextField creditCard = new TextField("Card number");
        ExpirationDateField expiration = new ExpirationDateField("Expiration date");
        TextField securityCode = new TextField("Security code");

        Layout layout = new Layout(title, method, creditCard, expiration, securityCode);
        // Viewport < 1024px
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        // Viewport > 1024px
        layout.setDisplay(Breakpoint.LARGE, Display.GRID);
        layout.setColumnGap(Gap.MEDIUM);
        layout.setGridColumns(GridColumns.COLUMNS_2);
        layout.setGridColumnSpan(GridColumnSpan.COLUMN_SPAN_FULL, title, method, creditCard);
        return layout;
    }


}
