package com.example.application.components.list;

import com.example.application.components.Layout;
import com.example.application.utilities.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class ListItem extends com.vaadin.flow.component.html.ListItem {

    // Style
    private AlignItems alignItems;
    private FlexDirection flexDirection;
    private ColumnGap colGap;
    private RowGap rowGap;

    // Components
    private Component mainLayout;
    private Layout prefix;
    private Layout column;
    private Layout primary;
    private Layout secondary;
    private Layout suffix;

    public ListItem() {
        this.mainLayout = this;
        addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.Background.BASE, LumoUtility.Display.FLEX,
                LumoUtility.Gap.MEDIUM, LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Padding.Vertical.SMALL,
                LumoUtility.Position.RELATIVE);

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
        this.column.addClassNames(LumoUtility.Padding.Vertical.XSMALL);
        this.column.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        this.column.setFlexGrow(1, this.column);

        this.suffix = new Layout();
        this.suffix.setGap(Gap.SMALL);
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
        addClassNames(gap.getColumnGap().getClassName());
        this.colGap = gap.getColumnGap();
    }

    /**
     * Sets the row (vertical) gap between components.
     */
    public void setRowGap(Gap gap) {
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
            this.mainLayout.removeClassName(this.colGap.getClassName());
        }
        this.colGap = null;
    }

    /**
     * Removes the row (vertical) gap between components.
     */
    public void removeRowGap() {
        if (this.rowGap != null) {
            this.mainLayout.removeClassName(this.rowGap.getClassName());
        }
        this.rowGap = null;
    }

    /**
     * Creates a router link and makes it the main layout.
     */
    public void setRoute(Class<? extends Component> navigationTarget) {
        if (navigationTarget != null) {
            // Move the content to the router link.
            RouterLink link = new RouterLink(navigationTarget);
            link.add(this.prefix, this.column, this.suffix);

            moveClassNames(link);
            add(link);

        } else {
            // Move the content to the list item.
            removeAll();
            add(this.prefix, this.column, this.suffix);

            moveClassNames(this);
        }
    }

    /**
     * Moves the class names from the old to the new main layout.
     */
    private void moveClassNames(Component mainLayout) {
        if (this.mainLayout != null) {
            for (String className : this.mainLayout.getClassNames()) {
                mainLayout.addClassName(className);
            }
        }
        this.mainLayout.getClassNames().clear();
        this.mainLayout = mainLayout;
    }

    @Override
    public void addClassName(String className) {
        this.mainLayout.getElement().getClassList().add(className);
    }

    @Override
    public void addClassNames(String... classNames) {
        for (String className : classNames) {
            this.mainLayout.getElement().getClassList().add(className);
        }
    }

    @Override
    public boolean removeClassName(String className) {
        return this.mainLayout.getElement().getClassList().remove(className);
    }

    @Override
    public void removeClassNames(String... classNames) {
        for (String className : classNames) {
            this.mainLayout.getElement().getClassList().remove(className);
        }
    }
}
