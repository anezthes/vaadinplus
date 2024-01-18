package com.example.application.components;

import com.example.application.utilities.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class Header extends Layout implements HasTheme {

    protected Layout actions;

    // Style
    private TextColor headingTextColor;
    private FontSize headingFontSize;
    private FontWeight headingFontWeight;

    // Components
    private Layout row;
    private Layout prefix;
    private Layout column;
    private Breadcrumb breadcrumb;
    private Component heading;
    private Layout details;
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
        this.row.addClassNames(LumoUtility.Margin.Vertical.XSMALL, LumoUtility.Padding.Horizontal.MEDIUM,
                LumoUtility.Padding.Vertical.SMALL);
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
    public void setBreadcrumb(BreadcrumbItem... items) {
        this.breadcrumb.removeAll();
        if (items != null) {
            for (BreadcrumbItem item : items) {
                if (item != null) {
                    this.breadcrumb.add(item);
                }
            }
        }
        this.breadcrumb.setVisible(items != null);
    }

    /**
     * Sets the heading text & level.
     */
    public void setHeading(String title, HeadingLevel level) {
        Component heading = level.getComponent(title);
        if (this.heading != null) {
            this.column.replace(this.heading, heading);
        }
        this.heading = heading;
    }

    public void setHeading(String title) {
        this.heading.getElement().setText(title);
    }

    /**
     * Sets the heading's font size.
     */
    public void setHeadingFontSize(FontSize fontSize) {
        if (this.headingFontSize != null) {
            this.heading.removeClassName(this.headingFontSize.getClassName());
        }
        this.heading.addClassNames(fontSize.getClassName());
        this.headingFontSize = fontSize;
    }

    /**
     * Sets the heading's font weight.
     */
    public void setHeadingFontWeight(FontWeight fontWeight) {
        if (this.headingFontWeight != null) {
            this.heading.removeClassName(this.headingFontWeight.getClassName());
        }
        this.heading.addClassNames(fontWeight.getClassName());
        this.headingFontWeight = fontWeight;
    }

    /**
     * Sets the heading id.
     */
    public void setHeadingId(String id) {
        this.heading.setId(id);
    }

    /**
     * Sets the heading's text color.
     */
    public void setHeadingTextColor(TextColor textColor) {
        if (this.headingTextColor != null) {
            this.heading.removeClassName(this.headingTextColor.getClassName());
        }
        this.heading.addClassNames(textColor.getClassName());
        this.headingTextColor = textColor;
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
     * Adds the specified actions.
     */
    public void addActions(Component... components) {
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
     * Sets the actions.
     */
    public void setActions(Component... components) {
        this.actions.removeAll();
        addActions(components);
    }

    /**
     * Returns the column layout.
     */
    public Layout getColumnLayout() {
        return this.column;
    }

}
