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
public class InputGroupsView extends Main {

	public InputGroupsView() {
		addClassNames(
				LumoUtility.AlignItems.START, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
				LumoUtility.Padding.Bottom.LARGE, LumoUtility.Padding.Horizontal.LARGE
		);

		add(new H2("Input with Button"));
		add(createInputWithButton(false));
		add(createInputWithButton(true));

		add(new H2("Example: Price"));
		add(createPriceExample(false));
		add(createPriceExample(true));

		add(new H2("Theme: Inset Label"));
		add(createTextField(InputTheme.INSET_LABEL));

		add(new H2("Theme: Outline"));
		add(createTextField(InputTheme.OUTLINE));

		add(new H2("Theme: Inset Label & Outline"));
		add(createTextField(InputTheme.INSET_LABEL, InputTheme.OUTLINE));

		add(new H2("Example: Vertical Group"));
		add(createVerticalGroupExample());

		add(new H2("Example: Credit Card"));
		add(createCreditCardExample());
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

	private Component createTextField(String... themeNames) {
		TextField textField = new TextField("Label");
		textField.addThemeNames(themeNames);
		return textField;
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
