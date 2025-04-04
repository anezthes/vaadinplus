package com.example.application.component.field;

import com.example.application.component.Layout;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.shared.Registration;

public class ExpirationDateField extends CustomField {

    public ExpirationDateField(String label) {
        setLabel(label);

        ComboBox<String> month = new ComboBox<>();
        month.setAriaLabel("Month");
        month.setItems("01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12");
        month.setPlaceholder("MM");

        ComboBox<String> year = new ComboBox<>();
        year.setAriaLabel("Year");
        year.setItems("25", "26", "27", "28",
                "29", "30", "31", "32", "33", "34", "35");
        year.setPlaceholder("YY");

        // Workaround for responsiveness
        month.getStyle().set("--vaadin-field-default-width", "auto");
        year.getStyle().set("--vaadin-field-default-width", "auto");

        Layout layout = new Layout(month, year);
        layout.setFlexGrow(month, year);
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
