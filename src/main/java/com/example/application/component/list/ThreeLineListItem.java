package com.example.application.component.list;

import com.example.application.component.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ThreeLineListItem extends com.vaadin.flow.component.html.ListItem {

    private final Layout prefix;
    private final Layout primary;
    private final Layout secondary;
    private final Layout suffix;
    private final Layout content;
    // Style
    private Layout.AlignItems alignItems;
    private Layout.FlexDirection flexDirection;
    private Layout.ColumnGap colGap;
    private Layout.RowGap rowGap;
    private Layout.LineClamp lineClamp;

    public ThreeLineListItem() {
        addClassNames(Background.BASE, Display.FLEX, Padding.Horizontal.MEDIUM, Padding.Vertical.SMALL);
        setFlexDirection(Layout.FlexDirection.COLUMN);

        this.prefix = new Layout();
        this.prefix.setVisible(false);

        this.primary = new Layout();
        this.primary.setAlignItems(Layout.AlignItems.CENTER);
        this.primary.setGap(Layout.Gap.SMALL);
        this.primary.setVisible(false);

        this.secondary = new Layout();
        this.secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
        this.secondary.setVisible(false);

        Layout column = new Layout(this.primary, this.secondary);
        column.addClassNames(Padding.Top.XSMALL);
        column.setFlexDirection(Layout.FlexDirection.COLUMN);
        column.setFlexGrow();

        this.suffix = new Layout();
        this.suffix.setAlignItems(Layout.AlignItems.CENTER);
        this.suffix.setGap(Layout.Gap.SMALL);
        this.suffix.setVisible(false);

        // Components
        Layout row = new Layout(this.prefix, column, this.suffix);
        row.setAlignItems(Layout.AlignItems.CENTER);
        row.setColumnGap(Layout.Gap.MEDIUM);
        row.setFlexWrap(Layout.FlexWrap.WRAP);
        row.setRowGap(Layout.Gap.SMALL);

        this.content = new Layout();
        this.content.addClassNames(Padding.Bottom.XSMALL);
        this.content.setVisible(false);

        add(row, this.content);
    }

    public ThreeLineListItem(Component prefix, String primary, String secondary, String content, Component suffix) {
        this(prefix, new Text(primary), new Text(secondary), new Text(content), suffix);
    }

    public ThreeLineListItem(Component prefix, Component primary, Component secondary, Component content, Component suffix) {
        this();
        setPrefix(prefix);
        setPrimary(primary);
        setSecondary(secondary);
        setSuffix(suffix);
        setContent(content);
    }

    /**
     * Sets the prefix.
     */
    public void setPrefix(Component... components) {
        set(this.prefix, components);

    }

    /**
     * Sets the primary content.
     */
    public void setPrimary(Component... components) {
        set(this.primary, components);
    }

    /**
     * Sets the secondary content.
     */
    public void setSecondary(String text) {
        this.setSecondary(new Text(text));
    }

    /**
     * Sets the secondary content.
     */
    public void setSecondary(Component... components) {
        set(this.secondary, components);
    }

    /**
     * Sets the suffix.
     */
    public void setSuffix(Component... components) {
        set(this.suffix, components);
    }

    /**
     * Sets the content.
     */
    public void setContent(String text) {
        this.setContent(new Text(text));
    }

    /**
     * Sets the content.
     */
    public void setContent(Component... components) {
        set(this.content, components);
    }

    private void set(Layout layout, Component... components) {
        layout.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    layout.add(component);
                }
            }
        }
        layout.setVisible(layout.getComponentCount() > 0);
    }

    public void setAlignItems(Layout.AlignItems alignItems) {
        if (this.alignItems != null) {
            removeClassNames(this.alignItems.getClassName());
        }
        addClassNames(alignItems.getClassName());
        this.alignItems = alignItems;
    }

    public void setFlexDirection(Layout.FlexDirection flexDirection) {
        if (this.flexDirection != null) {
            removeClassNames(this.flexDirection.getClassName());
        }
        addClassNames(flexDirection.getClassName());
        this.flexDirection = flexDirection;
    }

    public void setFlexGrow(Component... components) {
        for (Component component : components) {
            component.addClassNames(Flex.GROW);
        }
    }

    /**
     * Sets both the column (horizontal) and row (vertical) gap between components.
     */
    public void setGap(Layout.Gap gap) {
        setColumnGap(gap);
        setRowGap(gap);
    }

    /**
     * Sets the column (horizontal) gap between components.
     */
    public void setColumnGap(Layout.Gap gap) {
        removeColumnGap();
        this.addClassNames(gap.getColumnGap().getClassName());
        this.colGap = gap.getColumnGap();
    }

    /**
     * Sets the row (vertical) gap between components.
     */
    public void setRowGap(Layout.Gap gap) {
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
     * Sets the line clamp property.
     */
    public void setLineClamp(Layout.LineClamp lineClamp) {
        if (this.lineClamp != null) {
            this.content.removeClassName(this.lineClamp.getClassName());
        }
        this.content.addClassNames(lineClamp.getClassName());
        this.lineClamp = lineClamp;
    }

}
