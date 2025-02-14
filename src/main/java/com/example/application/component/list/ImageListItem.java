package com.example.application.component.list;

import com.example.application.component.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ImageListItem extends com.vaadin.flow.component.html.ListItem {

    private final Layout image;
    private final Layout primary;
    private final Layout secondary;
    private final Layout actions;

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

        Layout column = new Layout(this.primary, this.secondary);
        column.addClassNames(Padding.Start.XSMALL);
        column.setFlexDirection(Layout.FlexDirection.COLUMN);
        column.setFlexGrow();

        this.actions = new Layout();
        setActions(actions);

        Layout row = new Layout(column, this.actions);
        row.addClassNames(Padding.End.XSMALL, Padding.Start.SMALL, Padding.Vertical.SMALL);
        row.setAlignItems(Layout.AlignItems.CENTER);

        add(this.image, row);
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
        set(this.primary, components);
    }

    /**
     * Sets the secondary content.
     */
    public void setSecondary(Component... components) {
        set(this.secondary, components);
    }

    /**
     * Sets the actions.
     */
    public void setActions(Component... components) {
        set(this.actions, components);
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

}
