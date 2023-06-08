package com.example.application.views;

import com.example.application.components.AppBar;
import com.example.application.components.Breadcrumb;
import com.example.application.components.Preview;
import com.example.application.themes.InputTheme;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Breadcrumbs")
@Route(value = "breadcrumbs", layout = MainLayout.class)
public class BreadcrumbsView extends View {

    public BreadcrumbsView() {
        addClassNames(LumoUtility.Padding.Top.LARGE);

        add(new Breadcrumb(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Breadcrumbs", BreadcrumbsView.class)
        ));
    }

}
