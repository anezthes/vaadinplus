package com.example.application.components.list;

import com.example.application.components.Layout;
import com.example.application.utilities.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ThreeLineListItem extends com.vaadin.flow.component.html.ListItem {

    // Style
    private AlignItems alignItems;
    private FlexDirection flexDirection;
    private ColumnGap colGap;
    private RowGap rowGap;
    private LineClamp contentLineClamp;

    // Components
    private Layout row;
    private Layout prefix;
    private Layout column;
    private Layout primary;
    private Layout secondary;
    private Layout suffix;
    private Layout content;

    public ThreeLineListItem() {
        addClassNames(
                LumoUtility.Background.BASE, LumoUtility.Display.FLEX, LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.Padding.Vertical.SMALL
        );
        setFlexDirection(FlexDirection.COLUMN);

        this.prefix = new Layout();
        this.prefix.setVisible(false);

        this.primary = new Layout();
        this.primary.setAlignItems(Alignment.CENTER);
        this.primary.setGap(Gap.SMALL);
        this.primary.setVisible(false);

        this.secondary = new Layout();
        this.secondary.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);
        this.secondary.setVisible(false);

        this.column = new Layout(this.primary, this.secondary);
        this.column.addClassNames(LumoUtility.Padding.Top.XSMALL);
        this.column.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        this.column.setFlexGrow(1, this.column);

        this.suffix = new Layout();
        this.suffix.setAlignItems(Alignment.CENTER);
        this.suffix.setGap(Gap.SMALL);
        this.suffix.setVisible(false);

        this.row = new Layout(this.prefix, this.column, this.suffix);
        this.row.setAlignItems(Alignment.CENTER);
        this.row.setColumnGap(Gap.MEDIUM);
        this.row.setFlexWrap(FlexWrap.WRAP);
        this.row.setRowGap(Gap.SMALL);

        this.content = new Layout();
        this.content.addClassNames(LumoUtility.Padding.Bottom.XSMALL);
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

    /**
     * Sets the line clamp for the content layout.
     */
    public void setContentLineClap(LineClamp lineClamp) {
        removeContentLineClamp();
        this.content.addClassNames(lineClamp.getClassName());
        this.contentLineClamp = lineClamp;
    }

    /**
     * Removes the line clamp.
     */
    public void removeContentLineClamp() {
        if (this.contentLineClamp != null) {
            this.content.removeClassName(this.contentLineClamp.getClassName());
        }
        this.contentLineClamp = null;
    }

    /**
     * Sets the item alignment.
     */
    public void setAlignItems(AlignItems alignItems) {
        if (this.alignItems != null) {
            removeClassNames(this.alignItems.getClassName());
        }
        addClassNames(alignItems.getClassName());
        this.alignItems = alignItems;
    }

    /**
     * Sets the flex direction.
     */
    public void setFlexDirection(FlexDirection flexDirection) {
        if (this.flexDirection != null) {
            removeClassNames(this.flexDirection.getClassName());
        }
        addClassNames(flexDirection.getClassName());
        this.flexDirection = flexDirection;
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

}
