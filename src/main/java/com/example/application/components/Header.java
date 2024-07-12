package com.example.application.components;

import com.example.application.utilities.Color;
import com.example.application.utilities.Font;
import com.example.application.utilities.HeadingLevel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.theme.lumo.LumoUtility.*;


public class Header extends Layout implements HasTheme {

    protected Layout actions;

    // Style
    private Color.Text headingTextColor;
    private Font.Size headingFontSize;
    private Font.Weight headingFontWeight;
    private Font.LineHeight headingLineHeight;

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
        addClassNames(Background.BASE, Border.BOTTOM, Width.FULL);
        setBoxSizing(BoxSizing.BORDER);
        setFlexDirection(FlexDirection.COLUMN);

        this.prefix = new Layout();
        setPrefix(null);

        this.breadcrumb = new Breadcrumb();
        this.breadcrumb.addClassNames(Margin.Bottom.MEDIUM);
        setBreadcrumb(null);

        setHeading(title, level);
        setHeadingFontSize(Font.Size.XLARGE);

        this.details = new Layout();
        this.details.addClassNames(Margin.Top.XSMALL);
        this.details.setFlexWrap(FlexWrap.WRAP);
        this.details.setColumnGap(Gap.MEDIUM);
        setDetails(null);

        this.column = new Layout(this.breadcrumb, this.heading, this.details);
        this.column.setFlexDirection(Layout.FlexDirection.COLUMN);
        this.column.setFlexGrow();

        this.actions = new Layout();
        this.actions.setGap(Layout.Gap.SMALL);
        setActions(null);

        this.row = new Layout(this.prefix, this.column, this.actions);
        this.row.addClassNames(Padding.MEDIUM);
        this.row.setAlignItems(Layout.AlignItems.CENTER);
        this.row.setFlexWrap(FlexWrap.WRAP);
        this.row.setGap(Layout.Gap.MEDIUM);

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
    public void setHeadingFontSize(Font.Size fontSize) {
        if (this.headingFontSize != null) {
            this.heading.removeClassName(this.headingFontSize.getClassName());
        }
        this.heading.addClassNames(fontSize.getClassName());
        this.headingFontSize = fontSize;
    }

    /**
     * Sets the heading's font weight.
     */
    public void setHeadingFontWeight(Font.Weight fontWeight) {
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
     * Sets the heading's line height.
     */
    public void setHeadingLineHeight(Font.LineHeight lineHeight) {
        if (this.headingLineHeight != null) {
            this.heading.removeClassName(this.headingLineHeight.getClassName());
        }
        this.heading.addClassNames(lineHeight.getClassName());
        this.headingLineHeight = lineHeight;
    }

    /**
     * Sets the heading's text color.
     */
    public void setHeadingTextColor(Color.Text textColor) {
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
     * Returns the row layout.
     */
    public Layout getRowLayout() {
        return this.row;
    }

    /**
     * Returns the column layout.
     */
    public Layout getColumnLayout() {
        return this.column;
    }

    /**
     * Returns the tabs.
     */
    public Tabs getTabs() {
        return tabs;
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
            removeClassNames(Border.BOTTOM);
            this.tabs.setVisible(true);
        } else {
            addClassNames(Border.BOTTOM);
            this.tabs.setVisible(false);
        }
    }
}
