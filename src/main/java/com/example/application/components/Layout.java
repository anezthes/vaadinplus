package com.example.application.components;

import com.example.application.utilities.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import java.util.HashMap;

public class Layout extends FlexLayout {

    private com.example.application.utilities.AlignItems alignItems;
    private BoxSizing boxSizing;
    private Display display;
    private HashMap<Breakpoint, Display> responsiveDisplay;
    private com.example.application.utilities.FlexDirection flexDirection;
    private GridColumns gridColumns;
    private HashMap<Breakpoint, GridColumns> responsiveGridColumns;
    private HashMap<HasStyle, GridColumnSpan> gridColumnSpans;
    private ColumnGap colGap;
    private RowGap rowGap;
    private Overflow overflow;
    private Position position;

    public Layout(Component... components) {
        super(components);

        // Say "no" to inline styles! :)
        getStyle().remove("display");

        setDisplay(Display.FLEX);

        this.responsiveDisplay = new HashMap<>();
        this.responsiveGridColumns = new HashMap<>();
        this.gridColumnSpans = new HashMap<>();
    }

    public void setDisplay(Display display) {
        if (this.display != null) {
            removeClassNames(this.display.getClassName());
        }
        addClassNames(display.getClassName());
        this.display = display;
    }

    public void setDisplay(Breakpoint breakpoint, Display display) {
        if (this.responsiveDisplay.get(breakpoint) != null) {
            removeClassName(breakpoint.getPrefix() + ":" + this.responsiveDisplay.get(breakpoint).getClassName());
        }
        addClassNames(breakpoint.getPrefix() + ":" + display.getClassName());
        this.responsiveDisplay.put(breakpoint, display);
    }

    @Override
    public void setAlignItems(Alignment alignment) {
        // Say "no" to inline styles! :)
        setAlignItems(AlignItems.valueOf(alignment.name()));
    }

    private void setAlignItems(AlignItems alignItems) {
        if (this.alignItems != null) {
            removeClassNames(this.alignItems.getClassName());
        }
        addClassNames(alignItems.getClassName());
        this.alignItems = alignItems;
    }

    public void setBoxSizing(BoxSizing boxSizing) {
        if (this.boxSizing != null) {
            removeClassNames(this.boxSizing.getClassName());
        }
        addClassNames(boxSizing.getClassName());
        this.boxSizing = boxSizing;
    }

    @Override
    public void setFlexDirection(FlexDirection flexDirection) {
        // Say "no" to inline styles! :)
        setFlexDirection(com.example.application.utilities.FlexDirection.valueOf(flexDirection.name()));
    }

    private void setFlexDirection(com.example.application.utilities.FlexDirection flexDirection) {
        if (this.flexDirection != null) {
            removeClassNames(this.flexDirection.getClassName());
        }
        addClassNames(flexDirection.getClassName());
        this.flexDirection = flexDirection;
    }

    /**
     * Sets the default number of grid columns.
     */
    public void setGridColumns(GridColumns gridColumns) {
        if (this.gridColumns != null) {
            removeClassNames(this.gridColumns.getClassName());
        }
        addClassNames(gridColumns.getClassName());
        this.gridColumns = gridColumns;
    }

    /**
     * Sets the number of grid columns for a given breakpoint.
     */
    public void setGridColumns(Breakpoint breakpoint, GridColumns gridColumns) {
        if (this.responsiveGridColumns.get(breakpoint) != null) {
            removeClassName(breakpoint.getPrefix() + ":" + this.responsiveGridColumns.get(breakpoint).getClassName());
        }
        addClassNames(breakpoint.getPrefix() + ":" + gridColumns.getClassName());
        this.responsiveGridColumns.put(breakpoint, gridColumns);
    }

    public void setGridColumnSpan(GridColumnSpan gridColumnSpan, HasStyle... components) {
        for (HasStyle component : components) {
            if (this.gridColumnSpans.get(component) != null) {
                component.removeClassName(this.gridColumnSpans.get(component).getClassName());
            }
            component.addClassNames(gridColumnSpan.getClassName());
            this.gridColumnSpans.put(component, gridColumnSpan);
        }
    }

    /**
     * Sets both the column (horizontal) and row (vertical) gap between components.
     */
    public void setGap(Gap gap) {
        setColumnGap(gap);
        setRowGap(gap);
    }

    /**
     * Sets the column (horizontal) gap between components.
     */
    public void setColumnGap(Gap gap) {
        removeColumnGap();
        this.addClassNames(gap.getColumnGap().getClassName());
        this.colGap = gap.getColumnGap();
    }

    /**
     * Sets the row (vertical) gap between components.
     */
    public void setRowGap(Gap gap) {
        removeRowGap();
        this.addClassNames(gap.getRowGap().getClassName());
        this.rowGap = gap.getRowGap();
    }

    /**
     * Removes both the column (horizontal) and row (vertical) gap between components.
     */
    public void removeGap() {
        removeColumnGap();
        removeRowGap();
    }

    /**
     * Removes the column (horizontal) gap between components.
     */
    public void removeColumnGap() {
        if (this.colGap != null) {
            this.removeClassName(this.colGap.getClassName());
        }
        this.colGap = null;
    }

    /**
     * Removes the row (vertical) gap between components.
     */
    public void removeRowGap() {
        if (this.rowGap != null) {
            this.removeClassName(this.rowGap.getClassName());
        }
        this.rowGap = null;
    }

    /**
     * Sets the overflow property.
     */
    public void setOverflow(Overflow overflow) {
        if (this.overflow != null) {
            removeClassNames(this.overflow.getClassName());
        }
        addClassNames(overflow.getClassName());
        this.overflow = overflow;
    }

    public void setPosition(Position position) {
        if (this.position != null) {
            this.removeClassName(this.position.getClassName());
        }
        addClassNames(position.getClassName());
        this.position = position;
    }

}
