package com.example.application.components.list;

import com.example.application.components.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ImageListItem extends com.vaadin.flow.component.html.ListItem {

    private Layout image;
    private Layout row;
    private Layout column;
    private Layout primary;
    private Layout secondary;
    private Layout actions;

    public ImageListItem(String src, String alt, String primary, String secondary, Component... actions) {
        this(new Image(src, alt), new Text(primary), new Text(secondary), actions);
    }

    public ImageListItem(Image image, Component primary, Component secondary, Component... actions) {
        addClassNames(Background.BASE, BorderRadius.MEDIUM, Display.FLEX, FlexDirection.COLUMN, Overflow.HIDDEN);

        this.image = new Layout();
        this.image.setFlexGrow();
        setImage(image);

        this.primary = new Layout();
        setPrimary(primary);

        this.secondary = new Layout();
        this.secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
        setSecondary(secondary);

        this.column = new Layout(this.primary, this.secondary);
        this.column.addClassNames(Padding.Start.XSMALL);
        this.column.setFlexDirection(Layout.FlexDirection.COLUMN);
        this.column.setFlexGrow();

        this.actions = new Layout();
        setActions(actions);

        this.row = new Layout(this.column, this.actions);
        this.row.setAlignItems(Layout.AlignItems.CENTER);
        this.row.addClassNames(Padding.End.XSMALL, Padding.Start.SMALL, Padding.Vertical.SMALL);

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
