package com.example.application.components;

import com.example.application.utilities.Breakpoint;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.util.HashMap;

public class Layout extends Div {

    private AlignItems alignItems;
    private AlignSelf alignSelf;
    private BoxSizing boxSizing;
    private Display display;
    private HashMap<Breakpoint, Display> responsiveDisplay;
    private FlexDirection flexDirection;
    private FlexWrap flexWrap;
    private HashMap<Breakpoint, FlexDirection> responsiveFlexDirection;
    private ColumnGap colGap;
    private RowGap rowGap;
    private GridColumns gridColumns;
    private HashMap<Breakpoint, GridColumns> responsiveColumns;
    private HashMap<Component, ColumnSpan> columnSpans;
    private JustifyContent justifyContent;
    private LineClamp lineClamp;
    private Overflow overflow;
    private Position position;

    public Layout(Component... components) {
        super(components);

        setDisplay(Display.FLEX);

        this.responsiveDisplay = new HashMap<>();
        this.responsiveFlexDirection = new HashMap<>();
        this.responsiveColumns = new HashMap<>();
        this.columnSpans = new HashMap<>();
    }

    public void setAlignItems(AlignItems alignItems) {
        if (this.alignItems != null) {
            removeClassNames(this.alignItems.getClassName());
        }
        addClassNames(alignItems.getClassName());
        this.alignItems = alignItems;
    }

    public void setAlignSelf(AlignSelf alignSelf) {
        if (this.alignSelf != null) {
            removeClassNames(this.alignSelf.getClassName());
        }
        addClassNames(alignSelf.getClassName());
        this.alignSelf = alignSelf;
    }

    public void setBoxSizing(BoxSizing boxSizing) {
        if (this.boxSizing != null) {
            removeClassNames(this.boxSizing.getClassName());
        }
        addClassNames(boxSizing.getClassName());
        this.boxSizing = boxSizing;
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

    public void setFlexDirection(FlexDirection flexDirection) {
        if (this.flexDirection != null) {
            removeClassNames(this.flexDirection.getClassName());
        }
        addClassNames(flexDirection.getClassName());
        this.flexDirection = flexDirection;
    }

    public void setFlexDirection(Breakpoint breakpoint, FlexDirection flexDirection) {
        if (this.responsiveFlexDirection.get(breakpoint) != null) {
            removeClassName(breakpoint.getPrefix() + ":" + this.responsiveFlexDirection.get(breakpoint).getClassName());
        }
        addClassNames(breakpoint.getPrefix() + ":" + flexDirection.getClassName());
        this.responsiveFlexDirection.put(breakpoint, flexDirection);
    }

    public void setFlexBasis(String flexBasis, Component... components) {
        for (Component component : components) {
            component.getStyle().setFlexBasis(flexBasis);
        }
    }

    public void setFlexGrow() {
        addClassNames(LumoUtility.Flex.GROW);
    }

    public void setFlexGrow(Component... components) {
        for (Component component : components) {
            component.addClassNames(LumoUtility.Flex.GROW);
        }
    }

    public void setFlexWrap(FlexWrap flexWrap) {
        if (this.flexWrap != null) {
            removeClassNames(this.flexWrap.getClassName());
        }
        addClassNames(flexWrap.getClassName());
        this.flexWrap = flexWrap;
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
     * Sets the default number of grid columns.
     */
    public void setColumns(GridColumns gridColumns) {
        if (this.gridColumns != null) {
            removeClassNames(this.gridColumns.getClassName());
        }
        addClassNames(gridColumns.getClassName());
        this.gridColumns = gridColumns;
    }

    /**
     * Sets the number of grid columns for a given breakpoint.
     */
    public void setColumns(Breakpoint breakpoint, GridColumns gridColumns) {
        if (this.responsiveColumns.get(breakpoint) != null) {
            removeClassName(breakpoint.getPrefix() + ":" + this.responsiveColumns.get(breakpoint).getClassName());
        }
        addClassNames(breakpoint.getPrefix() + ":" + gridColumns.getClassName());
        this.responsiveColumns.put(breakpoint, gridColumns);
    }

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
     * Sets the justify content property.
     */
    public void setJustifyContent(JustifyContent justifyContent) {
        if (this.justifyContent != null) {
            removeClassName(this.justifyContent.getClassName());
        }
        addClassNames(justifyContent.getClassName());
        this.justifyContent = justifyContent;
    }

    /**
     * Sets the line clamp property.
     */
    public void setLineClamp(LineClamp lineClamp) {
        if (this.lineClamp != null) {
            removeClassName(this.lineClamp.getClassName());
        }
        addClassNames(lineClamp.getClassName());
        this.lineClamp = lineClamp;
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

    public enum AlignItems {
        BASELINE(LumoUtility.AlignItems.BASELINE),
        CENTER(LumoUtility.AlignItems.CENTER),
        END(LumoUtility.AlignItems.END),
        START(LumoUtility.AlignItems.START),
        STRETCH(LumoUtility.AlignItems.STRETCH);

        private final String className;

        private AlignItems(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum AlignSelf {
        AUTO(LumoUtility.AlignSelf.AUTO),
        BASELINE(LumoUtility.AlignSelf.BASELINE),
        CENTER(LumoUtility.AlignSelf.CENTER),
        END(LumoUtility.AlignSelf.END),
        START(LumoUtility.AlignSelf.START),
        STRETCH(LumoUtility.AlignSelf.STRETCH);

        private final String className;

        private AlignSelf(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum BoxSizing {
        BORDER(LumoUtility.BoxSizing.BORDER),
        CONTENT(LumoUtility.BoxSizing.CONTENT);

        private final String className;

        private BoxSizing(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum ColumnGap {
        PIXEL("gap-x-px"),
        XSMALL(LumoUtility.Gap.Column.XSMALL),
        SMALL(LumoUtility.Gap.Column.SMALL),
        MEDIUM(LumoUtility.Gap.Column.MEDIUM),
        LARGE(LumoUtility.Gap.Column.LARGE),
        XLARGE(LumoUtility.Gap.Column.XLARGE);

        private final String className;

        private ColumnGap(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum ColumnSpan {
        COLUMN_SPAN_1(LumoUtility.Grid.Column.COLUMN_SPAN_1),
        COLUMN_SPAN_2(LumoUtility.Grid.Column.COLUMN_SPAN_2),
        COLUMN_SPAN_3(LumoUtility.Grid.Column.COLUMN_SPAN_3),
        COLUMN_SPAN_4(LumoUtility.Grid.Column.COLUMN_SPAN_4),
        COLUMN_SPAN_5(LumoUtility.Grid.Column.COLUMN_SPAN_5),
        COLUMN_SPAN_6(LumoUtility.Grid.Column.COLUMN_SPAN_6),
        COLUMN_SPAN_7(LumoUtility.Grid.Column.COLUMN_SPAN_7),
        COLUMN_SPAN_8(LumoUtility.Grid.Column.COLUMN_SPAN_8),
        COLUMN_SPAN_9(LumoUtility.Grid.Column.COLUMN_SPAN_9),
        COLUMN_SPAN_10(LumoUtility.Grid.Column.COLUMN_SPAN_10),
        COLUMN_SPAN_11(LumoUtility.Grid.Column.COLUMN_SPAN_11),
        COLUMN_SPAN_12(LumoUtility.Grid.Column.COLUMN_SPAN_12),
        COLUMN_SPAN_FULL("col-span-full");

        private final String className;

        private ColumnSpan(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum Display {
        FLEX(LumoUtility.Display.FLEX),
        GRID(LumoUtility.Display.GRID);

        private final String className;

        private Display(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum FlexDirection {
        COLUMN(LumoUtility.FlexDirection.COLUMN),
        COLUMN_REVERSE(LumoUtility.FlexDirection.COLUMN_REVERSE),
        ROW(LumoUtility.FlexDirection.ROW),
        ROW_REVERSE(LumoUtility.FlexDirection.ROW_REVERSE);

        private final String className;

        private FlexDirection(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum FlexWrap {
        NOWRAP(LumoUtility.FlexWrap.NOWRAP),
        WRAP(LumoUtility.FlexWrap.WRAP),
        WRAP_REVERSE(LumoUtility.FlexWrap.WRAP_REVERSE);

        private final String className;

        private FlexWrap(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum Gap {
        PIXEL("gap-px"),
        XSMALL(LumoUtility.Gap.XSMALL),
        SMALL(LumoUtility.Gap.SMALL),
        MEDIUM(LumoUtility.Gap.MEDIUM),
        LARGE(LumoUtility.Gap.LARGE),
        XLARGE(LumoUtility.Gap.XLARGE);

        private final String className;

        private Gap(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }

        public ColumnGap getColumnGap() {
            return ColumnGap.valueOf(this.name());
        }

        public RowGap getRowGap() {
            return RowGap.valueOf(this.name());
        }
    }

    public enum GridColumns {
        COLUMNS_1(LumoUtility.Grid.Column.COLUMNS_1),
        COLUMNS_2(LumoUtility.Grid.Column.COLUMNS_2),
        COLUMNS_3(LumoUtility.Grid.Column.COLUMNS_3),
        COLUMNS_4(LumoUtility.Grid.Column.COLUMNS_4),
        COLUMNS_5(LumoUtility.Grid.Column.COLUMNS_5),
        COLUMNS_6(LumoUtility.Grid.Column.COLUMNS_6),
        COLUMNS_7(LumoUtility.Grid.Column.COLUMNS_7),
        COLUMNS_8(LumoUtility.Grid.Column.COLUMNS_8),
        COLUMNS_9(LumoUtility.Grid.Column.COLUMNS_9),
        COLUMNS_10(LumoUtility.Grid.Column.COLUMNS_10),
        COLUMNS_11(LumoUtility.Grid.Column.COLUMNS_11),
        COLUMNS_12(LumoUtility.Grid.Column.COLUMNS_12);

        private final String className;

        private GridColumns(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }


    public enum LineClamp {
        LINE_CLAMP_1("line-clamp-1"),
        LINE_CLAMP_2("line-clamp-2"),
        LINE_CLAMP_3("line-clamp-3"),
        LINE_CLAMP_4("line-clamp-4");

        private final String className;

        private LineClamp(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum RowGap {
        PIXEL("gap-y-px"),
        XSMALL(LumoUtility.Gap.Row.XSMALL),
        SMALL(LumoUtility.Gap.Row.SMALL),
        MEDIUM(LumoUtility.Gap.Row.MEDIUM),
        LARGE(LumoUtility.Gap.Row.LARGE),
        XLARGE(LumoUtility.Gap.Row.XLARGE);

        private final String className;

        private RowGap(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum JustifyContent {
        AROUND(LumoUtility.JustifyContent.AROUND),
        BETWEEN(LumoUtility.JustifyContent.BETWEEN),
        CENTER(LumoUtility.JustifyContent.CENTER),
        END(LumoUtility.JustifyContent.END),
        EVENLY(LumoUtility.JustifyContent.EVENLY),
        START(LumoUtility.JustifyContent.START);

        private final String className;

        private JustifyContent(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum Overflow {
        AUTO(LumoUtility.Overflow.AUTO),
        HIDDEN(LumoUtility.Overflow.HIDDEN);

        private final String className;

        private Overflow(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

    public enum Position {
        ABSOLUTE(LumoUtility.Position.ABSOLUTE),
        FIXED(LumoUtility.Position.FIXED),
        RELATIVE(LumoUtility.Position.RELATIVE),
        STATIC(LumoUtility.Position.STATIC),
        STICKY(LumoUtility.Position.STICKY);

        private final String className;

        private Position(String className) {
            this.className = className;
        }

        public String getClassName() {
            return this.className;
        }
    }

}
