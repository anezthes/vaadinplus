package com.example.application.components;

import com.example.application.themes.SideNavTheme;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.sidenav.SideNav;

public class NavRail extends SideNav implements HasTheme {

    private boolean showSubItemsOnFocus;

    public NavRail() {
        super();
        addThemeName(SideNavTheme.RAIL);
        setShowSubItemsOnFocus(true);
    }

    public NavRail(String label) {
        this();
        setLabel(label);
    }

    public void addItem(NavRailItem... items) {
        super.addItem(items);
        for (NavRailItem item : items) {
            item.setShowSubItemsOnFocus(this.showSubItemsOnFocus);
        }
    }

    /**
     * Sets the flag indicating whether to show navigation sub-items when their parent item gains focus.
     */
    public void setShowSubItemsOnFocus(boolean showSubItemsOnFocus) {
        this.showSubItemsOnFocus = showSubItemsOnFocus;
    }
}
