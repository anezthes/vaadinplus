package com.example.application.components;

import com.example.application.components.Layout.ColumnSpan;
import com.example.application.components.Layout.GridColumns;
import com.example.application.utilities.Breakpoint;
import com.example.application.utilities.Color;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.DescriptionList;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import java.util.HashMap;

public class KeyValuePairs extends DescriptionList implements HasTheme {

    public static final String STRIPES = "stripes";
    private GridColumns columns;
    private HashMap<Component, ColumnSpan> columnSpans;
    private KeyValuePair[] pairs;
    private Color.Background background;

    public KeyValuePairs(KeyValuePair... pairs) {
        addClassNames("key-value-pairs", Display.GRID, Margin.Vertical.NONE);
        setBackground(Color.Background.BASE);

        this.columnSpans = new HashMap<>();
        this.pairs = pairs;
        add(this.pairs);
    }

    /**
     * Sets the background color.
     */
    public void setBackground(Color.Background background) {
        removeBackgroundColor();
        addClassNames(background.getClassName());
        this.background = background;
    }

    /**
     * Removes the background color.
     */
    public void removeBackgroundColor() {
        if (this.background != null) {
            this.removeClassName(this.background.getClassName());
        }
        this.background = null;
    }

    /**
     * Sets the breakpoint for when keys are positioned on top.
     * Only works with KeyPosition.SIDE. Otherwise, keys are always on top.
     */
    public void setBreakpoint(Breakpoint breakpoint) {
        for (KeyValuePair pair : this.pairs) {
            pair.setBreakpoint(breakpoint);
        }
    }

    /**
     * Removes the breakpoint.
     */
    public void removeBreakpoint() {
        for (KeyValuePair pair : this.pairs) {
            pair.removeBreakpoint();
        }
    }

    /**
     * Sets the number of columns.
     */
    public void setColumns(GridColumns columns) {
        if (this.columns != null) {
            removeClassNames(this.columns.getClassName());
        }
        addClassNames(columns.getClassName());
        this.columns = columns;
    }

    /**
     * Sets the column span for the given components.
     */
    public void setColumnSpan(ColumnSpan columnSpan, Component... components) {
        for (Component component : components) {
            if (this.columnSpans.get(component) != null) {
                component.removeClassName(this.columnSpans.get(component).getClassName());
            }
            component.addClassNames(columnSpan.getClassName());
            this.columnSpans.put(component, columnSpan);
        }
    }

    /**
     * Sets the key position of each KeyValuePair.
     */
    public void setKeyPosition(KeyValuePair.KeyPosition keyPosition) {
        for (KeyValuePair pair : this.pairs) {
            pair.setKeyPosition(keyPosition);
        }
    }

    /**
     * Sets the key width for each KeyValuePair.
     */
    public void setKeyWidth(float width, Unit unit) {
        for (KeyValuePair pair : this.pairs) {
            pair.setKeyWidth(width, unit);
        }
    }

    /**
     * Maximises the key's width for each KeyValuePair.
     */
    public void setKeyWidthFull() {
        for (KeyValuePair pair : this.pairs) {
            pair.setKeyWidthFull();
        }
    }

    /**
     * Removes the horizontal padding of each KeyValuePair.
     */
    public void removeHorizontalPadding() {
        for (KeyValuePair pair : this.pairs) {
            pair.removeHorizontalPadding();
        }
    }

    /**
     * Sets a background color on every other KeyValuePair if true.
     */
    public void setStripes(boolean stripes) {
        if (stripes) {
            addThemeName(STRIPES);
        } else {
            removeThemeName(STRIPES);
        }
    }

}
