package com.example.application.components.list;

import com.example.application.components.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ListItem extends com.vaadin.flow.component.html.ListItem {

    // Style
    protected Layout.AlignItems alignItems;
    protected Layout.FlexDirection flexDirection;
    protected Layout.ColumnGap colGap;
    protected Layout.RowGap rowGap;

    // Components
    protected Layout prefix;
    protected Layout column;
    protected Layout primary;
    protected Layout secondary;
    protected Layout suffix;

    public ListItem() {
        addClassNames(AlignItems.CENTER, Background.BASE, Display.FLEX, Gap.MEDIUM, Padding.Horizontal.MEDIUM,
                Padding.Vertical.SMALL, Position.RELATIVE);

        this.prefix = new Layout();
        this.prefix.setVisible(false);

        this.primary = new Layout();
        this.primary.setAlignItems(Layout.AlignItems.CENTER);
        this.primary.setGap(Layout.Gap.SMALL);
        this.primary.setVisible(false);

        this.secondary = new Layout();
        this.secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
        this.secondary.setVisible(false);

        this.column = new Layout(this.primary, this.secondary);
        this.column.addClassNames(Padding.Vertical.XSMALL);
        this.column.setFlexDirection(Layout.FlexDirection.COLUMN);
        this.column.setFlexGrow();

        this.suffix = new Layout();
        this.suffix.setGap(Layout.Gap.SMALL);
        this.suffix.setVisible(false);

        add(this.prefix, this.column, this.suffix);
    }

    public ListItem(String primary, String secondary) {
        this(null, new Text(primary), new Text(secondary), null);
    }

    public ListItem(Component primary, Component secondary) {
        this(null, primary, secondary, null);
    }

    public ListItem(Component prefix, String primary, String secondary) {
        this(prefix, new Text(primary), new Text(secondary), null);
    }

    public ListItem(String primary, String secondary, Component suffix) {
        this(null, new Text(primary), new Text(secondary), suffix);
    }

    public ListItem(Component prefix, String primary, String secondary, Component suffix) {
        this(prefix, new Text(primary), new Text(secondary), suffix);
    }

    public ListItem(Component prefix, Component primary, Component secondary, Component suffix) {
        this();
        setPrefix(prefix);
        setPrimary(primary);
        setSecondary(secondary);
        setSuffix(suffix);
    }

    /**
     * Sets the prefix.
     */
    public void setPrefix(Component... components) {
        this.prefix.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.prefix.add(component);
                }
            }
        }
        this.prefix.setVisible(this.prefix.getComponentCount() > 0);
    }

    /**
     * Sets the primary content.
     */
    public void setPrimary(Component... components) {
        this.primary.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.primary.add(component);
                }
            }
        }
        this.primary.setVisible(this.primary.getComponentCount() > 0);
    }

    /**
     * Sets the primary content.
     */
    public void setPrimary(String text) {
        this.setPrimary(new Text(text));
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
        this.secondary.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.secondary.add(component);
                }
            }
        }
        this.secondary.setVisible(this.secondary.getComponentCount() > 0);
    }

    /**
     * Sets the suffix.
     */
    public void setSuffix(Component... components) {
        this.suffix.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.suffix.add(component);
                }
            }
        }
        this.suffix.setVisible(this.suffix.getComponentCount() > 0);
    }

    /**
     * Sets the item alignment.
     */
    public void setAlignItems(Layout.AlignItems alignItems) {
        if (this.alignItems != null) {
            removeClassNames(this.alignItems.getClassName());
        }
        addClassNames(alignItems.getClassName());
        this.alignItems = alignItems;
    }

    /**
     * Sets the flex direction.
     */
    public void setFlexDirection(Layout.FlexDirection flexDirection) {
        if (this.flexDirection != null) {
            removeClassNames(this.flexDirection.getClassName());
        }
        addClassNames(flexDirection.getClassName());
        this.flexDirection = flexDirection;
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
        addClassNames(gap.getColumnGap().getClassName());
        this.colGap = gap.getColumnGap();
    }

    /**
     * Sets the row (vertical) gap between components.
     */
    public void setRowGap(Layout.Gap gap) {
        removeRowGap();
        addClassNames(gap.getRowGap().getClassName());
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

}
