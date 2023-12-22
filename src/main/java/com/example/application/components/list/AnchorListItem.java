package com.example.application.components.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.RouterLink;

public class AnchorListItem extends ListItem {

    private RouterLink link;

    public AnchorListItem() {
        this.link = new RouterLink();
    }

    public AnchorListItem(String primary, String secondary) {
        super(null, new Text(primary), new Text(secondary), null);
    }

    public AnchorListItem(Component primary, Component secondary) {
        super(null, primary, secondary, null);
    }

    public AnchorListItem(Component prefix, String primary, String secondary) {
        super(prefix, new Text(primary), new Text(secondary), null);
    }

    public AnchorListItem(String primary, String secondary, Component suffix) {
        super(null, new Text(primary), new Text(secondary), suffix);
    }

    public AnchorListItem(Component prefix, String primary, String secondary, Component suffix) {
        super(prefix, new Text(primary), new Text(secondary), suffix);
    }

    public AnchorListItem(Component prefix, Component primary, Component secondary, Component suffix) {
        super(prefix, primary, secondary, suffix);
    }


}
