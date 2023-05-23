package com.example.application.views;

import com.example.application.components.CreditCardField;
import com.example.application.components.InputGroup;
import com.example.application.components.PriceField;
import com.example.application.themes.ButtonTheme;
import com.example.application.themes.InputTheme;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Input Groups")
@Route(value = "input-groups", layout = MainLayout.class)
public class InputGroupsView extends View {

	public InputGroupsView() {
		addClassNames(LumoUtility.AlignItems.START);

		addH2("Theme: Inset Label");
		add(createTextField(InputTheme.INSET_LABEL));
		// add(createTextField(VaadinIcon.SEARCH, InputTheme.INSET_LABEL));
		add(createTextFieldWithoutLabel(InputTheme.INSET_LABEL));

		addH2("Theme: Outline");
		add(createTextFields(InputTheme.OUTLINE));

		addH2("Theme: Hide & Inset Label");
		add(createTextField(InputTheme.HIDE_LABEL, InputTheme.INSET_LABEL));

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

	private TextField createTextField(VaadinIcon icon, String... themeNames) {
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

		Button button = new Button("Advanced", VaadinIcon.SEARCH.create());
		button.addThemeNames(outline ? ButtonTheme.OUTLINE : "");

		return new InputGroup(textField, button);
	}

	private Component createPriceExample(boolean outline) {
		PriceField priceField = new PriceField("Price");
		priceField.addThemeNames(outline ? InputTheme.OUTLINE : "");
		return priceField;
	}

	private Component createVerticalGroupExample() {
		DatePicker startDate = new DatePicker("Start Date");
		startDate.addThemeNames(InputTheme.HIDE_LABEL, InputTheme.OUTLINE);

		DatePicker endDate = new DatePicker("End Date");
		endDate.addThemeNames(InputTheme.HIDE_LABEL, InputTheme.OUTLINE);

		InputGroup inputGroup = new InputGroup(startDate, endDate);
		inputGroup.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
		return inputGroup;
	}

	private Component createCreditCardExample() {
		return new CreditCardField("Credit Card");
	}
}
