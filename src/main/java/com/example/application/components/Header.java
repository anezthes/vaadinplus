package com.example.application.components;

import com.example.application.utilities.BoxSizing;
import com.example.application.utilities.FontSize;
import com.example.application.utilities.Gap;
import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Header extends Layout implements HasTheme {

    // Style
    private FontSize headingFontSize;

    // Components
    private Layout row;
    private Layout prefix;
    private Layout column;
    private Breadcrumb breadcrumb;
    private Component heading;
    private Layout details;
    private Layout actions;
    private Tabs tabs;

    public Header(String title) {
        this(title, HeadingLevel.H2);
    }

    public Header(String title, HeadingLevel level) {
        addClassNames(LumoUtility.Background.BASE, LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10);
        setBoxSizing(BoxSizing.BORDER);
        setFlexDirection(FlexDirection.COLUMN);
        setWidthFull();

        this.prefix = new Layout();
        setPrefix(null);

        this.breadcrumb = new Breadcrumb();
        setBreadcrumb(null);

        setHeading(title, level);
        setHeadingFontSize(FontSize.XLARGE);

        this.details = new Layout();
        this.details.setFlexWrap(FlexWrap.WRAP);
        this.details.setColumnGap(Gap.MEDIUM);
        setDetails(null);

        this.column = new Layout(this.breadcrumb, this.heading, this.details);
        this.column.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        this.column.setFlexGrow(1, this.column);
        this.column.setGap(Gap.SMALL);

        this.actions = new Layout();
        this.actions.setGap(Gap.SMALL);
        setActions(null);

        this.row = new Layout(this.prefix, this.column, this.actions);
        this.row.addClassNames(
                LumoUtility.Margin.Vertical.XSMALL, LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.Padding.Vertical.SMALL
        );
        this.row.setAlignItems(FlexComponent.Alignment.CENTER);
        this.row.setFlexWrap(FlexWrap.WRAP);
        this.row.setGap(Gap.MEDIUM);

        this.tabs = new Tabs();
        setTabs(null);

        add(this.row, this.tabs);
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
     * Sets the content of the breadcrumb.
     */
    public void setBreadcrumb(Component... components) {
        this.breadcrumb.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.breadcrumb.add(component);
                }
            }
        }
        this.breadcrumb.setVisible(this.breadcrumb.getComponentCount() > 0);
    }

    /**
     * Sets the heading text & level.
     */
    public void setHeading(String title, HeadingLevel level) {
        Component heading;
        switch (level) {
            case H1:
                heading = new H1(title);
                break;
            case H2:
            default:
                heading = new H2(title);
                break;
            case H3:
                heading = new H3(title);
                break;
            case H4:
                heading = new H4(title);
                break;
            case H5:
                heading = new H5(title);
                break;
            case H6:
                heading = new H6(title);
                break;
        }
        if (this.heading != null) {
            this.column.replace(this.heading, heading);
        }
        this.heading = heading;
    }

    /**
     * Sets the heading's font size.
     */
    public void setHeadingFontSize(FontSize fontSize) {
        if (this.headingFontSize != null) {
            ((HasStyle) this.heading).removeClassName(this.headingFontSize.getClassName());
        }
        ((HasStyle) this.heading).addClassNames(fontSize.getClassName());
        this.headingFontSize = fontSize;
    }

    /**
     * Sets the details.
     */
    public void setDetails(Component... components) {
        this.details.removeAll();
        if (components != null) {
            for (Component component : components) {
                if (component != null) {
                    this.details.add(component);
                }
            }
        }
        this.details.setVisible(this.details.getComponentCount() > 0);
    }

    /**
     * Sets the tabs.
     */
    public void setTabs(Tab... tabs) {
        this.tabs.removeAll();
        if (tabs != null) {
            for (Tab tab : tabs) {
                if (tab != null) {
                    this.tabs.add(tab);
                }
            }
        }
        if (this.tabs.getComponentCount() > 0) {
            removeClassNames(LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10);
            this.tabs.setVisible(true);
        } else {
            addClassNames(LumoUtility.Border.BOTTOM, LumoUtility.BorderColor.CONTRAST_10);
            this.tabs.setVisible(false);
        }
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

    /**
     * Returns the column layout.
     */
    public Layout getColumnLayout() {
        return this.column;
    }

}
