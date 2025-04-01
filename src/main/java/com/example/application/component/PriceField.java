package com.example.application.component;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoUtility.IconSize;

public class PriceField extends CustomField<PriceField.Price> {

    public static final String EUR = "EUR";
    public static final String GBP = "GBP";
    public static final String USD = "USD";

    private final TextField amount;
    private final Select<String> currency;

    public PriceField(String label) {
        this();
        setLabel(label);
    }

    public PriceField() {
        amount = new TextField();
        amount.setAriaLabel("Amount");

        currency = new Select<>();
        currency.addValueChangeListener(e -> updateAmountPrefix());
        currency.setAriaLabel("Currency");
        currency.setItems(EUR, GBP, USD);
        currency.setValue(EUR);
        currency.setWidth("6em");

        InputGroup inputGroup = new InputGroup(amount, currency);
        add(inputGroup);
    }

    @Override
    public void addThemeName(String themeName) {
        super.addThemeName(themeName);
        amount.addThemeName(themeName);
        currency.addThemeName(themeName);
    }

    @Override
    public void addThemeNames(String... themeNames) {
        super.addThemeNames(themeNames);
        amount.addThemeNames(themeNames);
        currency.addThemeNames(themeNames);
    }

    private void updateAmountPrefix() {
        Span prefix;
        if (currency.getValue().equals(EUR)) {
            prefix = MaterialSymbol.EURO.create(IconSize.SMALL);
        } else if (currency.getValue().equals(GBP)) {
            prefix = MaterialSymbol.CURRENCY_POUND.create(IconSize.SMALL);
        } else {
            prefix = MaterialSymbol.ATTACH_MONEY.create(IconSize.SMALL);
        }
        amount.setPrefixComponent(prefix);
    }

    @Override
    protected Price generateModelValue() {
        return new Price(amount.getValue(), currency.getValue());
    }

    @Override
    protected void setPresentationValue(Price price) {
        amount.setValue(price.getAmount());
        currency.setValue(price.getCurrency());
    }

    public static class Price {
        private String amount;
        private String currency;

        public Price(String amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
