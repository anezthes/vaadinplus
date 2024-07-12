package com.example.application.components;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.textfield.TextField;

public class CreditCardField extends CustomField<CreditCardField.CreditCard> {

    private TextField number;
    private TextField expiration;
    private TextField csc;

    public CreditCardField(String label) {
        this();
        setLabel(label);
    }

    public CreditCardField() {
        number = new TextField();
        number.setAriaLabel("Card number");
        number.setPlaceholder("Card number");

        expiration = new TextField();
        expiration.setAriaLabel("Expiration date");
        expiration.setPlaceholder("Expiration date");

        csc = new TextField();
        csc.addThemeName("Security code");
        csc.setPlaceholder("Security code");

        InputGroup row = new InputGroup(expiration, csc);
        InputGroup col = new InputGroup(number, row);
        col.setFlexDirection(Layout.FlexDirection.COLUMN);
        add(col);
    }

    @Override
    protected CreditCard generateModelValue() {
        return new CreditCard(number.getValue(), expiration.getValue(), csc.getValue());
    }

    @Override
    protected void setPresentationValue(CreditCard creditCard) {
        creditCard.setNumber(number.getValue());
        creditCard.setExpiration(expiration.getValue());
        creditCard.setCSC(csc.getValue());
    }

    public class CreditCard {
        private String number;
        private String expiration;
        private String csc;

        public CreditCard(String number, String expiration, String csc) {
            this.number = number;
            this.expiration = expiration;
            this.csc = csc;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getExpiration() {
            return expiration;
        }

        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        public String getCSC() {
            return csc;
        }

        public void setCSC(String csc) {
            this.csc = csc;
        }
    }
}
