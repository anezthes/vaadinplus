package com.example.application.components;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.shared.Registration;

public class ExpirationDateField extends CustomField {

    private ComboBox month;
    private ComboBox year;

    public ExpirationDateField(String label) {
        setLabel(label);

        this.month = new ComboBox();
        this.month.setAriaLabel("Month");
        this.month.setItems("01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12");
        this.month.setPlaceholder("MM");

        this.year = new ComboBox();
        this.year.setAriaLabel("Year");
        this.year.setItems("23", "24", "25", "26", "27", "28",
                "29", "30", "31", "32", "33");
        this.year.setPlaceholder("YY");

        // Workaround for responsiveness
        this.month.getStyle().set("--vaadin-field-default-width", "auto");
        this.year.getStyle().set("--vaadin-field-default-width", "auto");

        Layout layout = new Layout(this.month, this.year);
        layout.setFlexGrow(this.month, this.year);
        layout.setGap(Layout.Gap.SMALL);
        add(layout);
    }

    @Override
    protected Object generateModelValue() {
        return null;
    }

    @Override
    protected void setPresentationValue(Object o) {

    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener valueChangeListener) {
        return null;
    }
}
