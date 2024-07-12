package com.example.application.components.list;

import com.example.application.components.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ProductListItem extends com.vaadin.flow.component.html.ListItem {

    // Components
    private Layout image;
    private Layout row;
    private Layout column;
    private Layout primary;
    private Layout secondary;
    private Layout actions;

    public ProductListItem(String src, String alt, String primary, String secondary, Component... actions) {
        this(new Image(src, alt), new Text(primary), new Text(secondary), actions);
    }

    public ProductListItem(Image image, Component primary, Component secondary, Component... actions) {
        addClassNames(Background.BASE, Border.BOTTOM, Border.RIGHT, Display.FLEX, FlexDirection.COLUMN, Gap.MEDIUM,
                Padding.Bottom.MEDIUM, Padding.Horizontal.LARGE, Padding.Top.LARGE);

        this.image = new Layout(image);
        this.image.addClassNames("aspect-video", BorderRadius.MEDIUM);
        this.image.setAlignItems(Layout.AlignItems.CENTER);
        this.image.setJustifyContent(Layout.JustifyContent.CENTER);
        this.image.setOverflow(Layout.Overflow.HIDDEN);
        setImage(image);

        this.primary = new Layout();
        this.primary.addClassNames(FontSize.SMALL);
        setPrimary(primary);

        this.secondary = new Layout();
        this.secondary.addClassNames(FontWeight.BOLD);
        setSecondary(secondary);

        this.column = new Layout(this.primary, this.secondary);
        this.column.setFlexDirection(Layout.FlexDirection.COLUMN);
        this.column.setFlexGrow();

        this.actions = new Layout();
        setActions(actions);

        this.row = new Layout(this.column, this.actions);
        this.row.setAlignItems(Layout.AlignItems.CENTER);

        add(this.image, this.row);
    }

    /**
     * Sets the image.
     */
    public void setImage(Image image) {
        this.image.removeAll();
        if (image != null) {
            image.addClassNames(MaxWidth.FULL);
            this.image.add(image);
        }
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
     * Sets the actions.
     */
    public void setActions(Component... components) {
        this.actions.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.actions.add(component);
                }
            }
        }
        this.actions.setVisible(this.actions.getComponentCount() > 0);
    }

}
