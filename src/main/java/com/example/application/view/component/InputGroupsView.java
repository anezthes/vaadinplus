package com.example.application.view.component;

import com.example.application.component.InputGroup;
import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.component.field.CreditCardField;
import com.example.application.component.field.PriceField;
import com.example.application.theme.ButtonTheme;
import com.example.application.theme.InputTheme;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;


@PageTitle("Input groups")
@Route(value = "input-groups", layout = MainLayout.class)
public class InputGroupsView extends ComponentView {

    public InputGroupsView() {
        addClassNames(AlignItems.START);

        addH2("Theme: inset label");
        add(createTextField(InputTheme.INSET_LABEL));
        add(createTextFieldWithoutLabel(InputTheme.INSET_LABEL));

        addH2("Theme: outline");
        add(createTextFields(InputTheme.OUTLINE));

        addH2("Theme: inset label & outline");
        add(createTextField(InputTheme.INSET_LABEL, InputTheme.OUTLINE));

        addH2("Example: input with button");
        add(createInputWithButton(false));
        add(createInputWithButton(true));

        addH2("Example: price");
        add(createPriceExample(false));
        add(createPriceExample(true));

        addH2("Example: vertical group");
        add(createVerticalGroupExample());

        addH2("Example: credit card");
        add(createCreditCardExample());
    }

    private TextField createTextField(String... themeNames) {
        TextField textField = new TextField("Label");
        textField.addThemeNames(themeNames);
        return textField;
    }

    private TextField createTextField(MaterialSymbol symbol, String... themeNames) {
        TextField textField = createTextField(themeNames);
        textField.setPrefixComponent(symbol.create());
        return textField;
    }

    private TextField createTextFieldWithoutLabel(String... themeNames) {
        /* Demo purposes only; always use labels! */
        TextField textField = new TextField();
        textField.addThemeNames(themeNames);
        return textField;
    }

    private Component[] createTextFields(String... themeNames) {
        TextField enabled = createTextField(themeNames);

        TextField disabled = createTextField(themeNames);
        disabled.setEnabled(false);

        TextField readonly = createTextField(themeNames);
        readonly.setReadOnly(true);

        TextField invalid = createTextField(themeNames);
        invalid.setInvalid(true);

        return new Component[]{enabled, disabled, readonly, invalid};
    }

    private Component createInputWithButton(boolean outline) {
        TextField textField = new TextField("Search");
        textField.addThemeNames(outline ? InputTheme.OUTLINE : "");

        Button button = new Button("Advanced", MaterialSymbol.SEARCH.create());
        button.addThemeNames(outline ? ButtonTheme.OUTLINE : "");

        return new InputGroup(textField, button);
    }

    private Component createPriceExample(boolean outline) {
        PriceField priceField = new PriceField("Price");
        priceField.addThemeNames(outline ? InputTheme.OUTLINE : "");
        return priceField;
    }

    private Component createVerticalGroupExample() {
        DatePicker startDate = new DatePicker();
        startDate.setAriaLabel("Start date");
        startDate.addThemeNames(InputTheme.OUTLINE);

        DatePicker endDate = new DatePicker();
        endDate.setAriaLabel("End date");
        endDate.addThemeNames(InputTheme.OUTLINE);

        InputGroup inputGroup = new InputGroup(startDate, endDate);
        inputGroup.setFlexDirection(Layout.FlexDirection.COLUMN);
        return inputGroup;
    }

    private Component createCreditCardExample() {
        return new CreditCardField("Credit Card");
    }
}
