package com.example.application.components.list;

import com.example.application.components.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ThreeLineListItem extends com.vaadin.flow.component.html.ListItem {

    // Style
    private Layout.AlignItems alignItems;
    private Layout.FlexDirection flexDirection;
    private Layout.ColumnGap colGap;
    private Layout.RowGap rowGap;
    private Layout.LineClamp lineClamp;

    // Components
    private Layout row;
    private Layout prefix;
    private Layout column;
    private Layout primary;
    private Layout secondary;
    private Layout suffix;
    private Layout content;

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

        this.column = new Layout(this.primary, this.secondary);
        this.column.addClassNames(Padding.Top.XSMALL);
        this.column.setFlexDirection(Layout.FlexDirection.COLUMN);
        this.column.setFlexGrow();

        this.suffix = new Layout();
        this.suffix.setAlignItems(Layout.AlignItems.CENTER);
        this.suffix.setGap(Layout.Gap.SMALL);
        this.suffix.setVisible(false);

        this.row = new Layout(this.prefix, this.column, this.suffix);
        this.row.setAlignItems(Layout.AlignItems.CENTER);
        this.row.setColumnGap(Layout.Gap.MEDIUM);
        this.row.setFlexWrap(Layout.FlexWrap.WRAP);
        this.row.setRowGap(Layout.Gap.SMALL);

        this.content = new Layout();
        this.content.addClassNames(Padding.Bottom.XSMALL);
        this.content.setVisible(false);

        add(this.row, this.content);
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
     * Sets the content.
     */
    public void setContent(String text) {
        this.setContent(new Text(text));
    }

    /**
     * Sets the content.
     */
    public void setContent(Component... components) {
        this.content.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.content.add(component);
                }
            }
        }
        this.content.setVisible(this.content.getComponentCount() > 0);
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
