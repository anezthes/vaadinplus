package com.example.application.component.list;

import com.example.application.component.Layout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

public class ProductListItem extends com.vaadin.flow.component.html.ListItem {

    // Components
    private final Layout image;
    private final Layout primary;
    private final Layout secondary;
    private final Layout actions;

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

        Layout column = new Layout(this.primary, this.secondary);
        column.setFlexDirection(Layout.FlexDirection.COLUMN);
        column.setFlexGrow();

        this.actions = new Layout();
        setActions(actions);

        Layout row = new Layout(column, this.actions);
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
