package com.example.application.components;

import com.example.application.themes.InputTheme;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;

import java.util.Optional;

public class PriceRange extends CustomField {

    public PriceRange(String label) {
        setLabel(label);

        TextField minimum = new TextField();
        minimum.addThemeName(InputTheme.OUTLINE);
        minimum.setAriaLabel("Minimum price");
        minimum.setPlaceholder("Min");
        minimum.setTooltipText("Minimum price");

        TextField maximum = new TextField();
        maximum.addThemeName(InputTheme.OUTLINE);
        maximum.setAriaLabel("Maximum price");
        maximum.setPlaceholder("Max");
        maximum.setTooltipText("Maximum price");

        add(new InputGroup(minimum, maximum));
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

    @Override
    public Optional getOptionalValue() {
        return super.getOptionalValue();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
