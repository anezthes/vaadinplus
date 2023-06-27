package com.example.application.views.components;

import com.example.application.components.CreditCardField;
import com.example.application.components.InputGroup;
import com.example.application.components.PriceField;
import com.example.application.themes.ButtonTheme;
import com.example.application.themes.InputTheme;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Input Groups")
@Route(value = "input-groups", layout = MainLayout.class)
public class InputGroupsView extends ComponentView {

    public InputGroupsView() {
        addClassNames(LumoUtility.AlignItems.START);

        addH2("Theme: Inset Label");
        add(createTextField(InputTheme.INSET_LABEL));
        add(createTextFieldWithoutLabel(InputTheme.INSET_LABEL));

        addH2("Theme: Outline");
        add(createTextFields(InputTheme.OUTLINE));

        addH2("Theme: Inset Label & Outline");
        add(createTextField(InputTheme.INSET_LABEL, InputTheme.OUTLINE));

        addH2("Example: Input with Button");
        add(createInputWithButton(false));
        add(createInputWithButton(true));

        addH2("Example: Price");
        add(createPriceExample(false));
        add(createPriceExample(true));

        addH2("Example: Vertical Group");
        add(createVerticalGroupExample());

        addH2("Example: Credit Card");
        add(createCreditCardExample());
    }

    private TextField createTextField(String... themeNames) {
        TextField textField = new TextField("Label");
        textField.addThemeNames(themeNames);
        return textField;
    }

    private TextField createTextField(LineAwesomeIcon icon, String... themeNames) {
        TextField textField = createTextField(themeNames);
        textField.setPrefixComponent(icon.create());
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

        Button button = new Button("Advanced", LineAwesomeIcon.SEARCH_SOLID.create());
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
        startDate.setAriaLabel("Start Date");
        startDate.addThemeNames(InputTheme.OUTLINE);

        DatePicker endDate = new DatePicker();
        endDate.setAriaLabel("End Date");
        endDate.addThemeNames(InputTheme.OUTLINE);

        InputGroup inputGroup = new InputGroup(startDate, endDate);
        inputGroup.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        return inputGroup;
    }

    private Component createCreditCardExample() {
        return new CreditCardField("Credit Card");
    }
}
