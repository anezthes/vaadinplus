package com.example.application.view.component;

import com.example.application.component.GridHeader;
import com.example.application.component.Item;
import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.theme.MenuBarTheme;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Grids")
@Route(value = "grids", layout = MainLayout.class)
public class GridsView extends ComponentView {

    String[] names = {
            "Alice Smith", "Bob Johnson", "Charlie Brown", "David Davis", "Eve Lee",
            "Frank Wilson", "Grace Clark", "Hannah Anderson", "Isaac Harris", "Julia Moore",
            "Kevin Taylor", "Linda Jackson", "Michael White", "Nancy Martin", "Oliver Thompson",
            "Peggy Walker", "Quincy Allen", "Rachel Young", "Samuel Wright", "Tina Lewis",
            "Ulysses Hall", "Victoria Hill", "Walter Adams", "Xena Carter", "Yasmine Robinson",
            "Zachary Turner", "Ava Parker", "Emily King", "Henry Hughes", "Sophia Scott",
            "Jackson Bennett", "Sophie Bell", "Noah Green", "Liam Reed", "Aria Carter",
            "Olivia Hall", "Ethan Adams", "Mia Turner", "Liam Brown", "Emma Wilson",
            "Jacob Harris", "Isabella Martin"
    };

    public GridsView() {
        addH2("Grid header");
        addPreview(createGridHeaderExample());
    }

    private Component createGridHeaderExample() {
        Grid<Employee> grid = new Grid<>();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setItems(createEmployees());
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Employee::getFirstName).setHeader("First name");
        grid.addColumn(Employee::getLastName).setHeader("Last name");

        GridHeader header = new GridHeader("Employees (42)", grid);
        header.setDefaultActions(createDefaultMenuBar(grid));
        header.setContextActions(createContextMenuBar());

        Layout layout = new Layout(header, grid);
        layout.addClassNames(Background.BASE);
        layout.setFlexDirection(Layout.FlexDirection.COLUMN);
        return layout;
    }

    private MenuBar createDefaultMenuBar(Grid<Employee> grid) {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeNames(MenuBarTheme.ROUNDED, MenuBarTheme.GAP_MEDIUM);

        MenuItem add = menuBar.addItem(new Item("New employee", MaterialSymbol.ADD));
        add.addThemeNames(MenuBarVariant.LUMO_PRIMARY.getVariantName());

        MenuItem columns = menuBar.addItem(MaterialSymbol.VIEW_COLUMN.create());
        columns.addThemeNames(MenuBarVariant.LUMO_ICON.getVariantName(), MenuBarVariant.LUMO_TERTIARY.getVariantName());
        columns.setAriaLabel("Columns");
        Tooltip.forComponent(columns).setText("Columns");

        List<Grid.Column<Employee>> cols = grid.getColumns();
        for (Grid.Column<Employee> col : cols) {
            MenuItem menuItem = columns.getSubMenu().addItem(col.getHeaderText(), e -> col.setVisible(!col.isVisible()));
            menuItem.setCheckable(true);
            menuItem.setChecked(true);
        }

        MenuItem more = menuBar.addItem(MaterialSymbol.MORE_VERT.create());
        more.addThemeNames(MenuBarVariant.LUMO_ICON.getVariantName(), MenuBarVariant.LUMO_TERTIARY.getVariantName());
        more.setAriaLabel("More");

        more.getSubMenu().addItem(new Item("Search", MaterialSymbol.SEARCH));
        more.getSubMenu().addItem(new Item("Filter", MaterialSymbol.FILTER_LIST));

        return menuBar;
    }

    private MenuBar createContextMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeNames(MenuBarTheme.ROUNDED, MenuBarTheme.GAP_MEDIUM);

        MenuItem delete = menuBar.addItem(new Item("Delete", MaterialSymbol.DELETE));
        delete.addThemeNames(MenuBarVariant.LUMO_ICON.getVariantName(), MenuBarVariant.LUMO_TERTIARY.getVariantName());

        MenuItem more = menuBar.addItem(MaterialSymbol.MORE_VERT.create());
        more.setAriaLabel("More");
        more.addThemeNames(MenuBarVariant.LUMO_ICON.getVariantName(), MenuBarVariant.LUMO_TERTIARY.getVariantName());

        more.getSubMenu().addItem(new Item("Favourite", MaterialSymbol.FAVORITE));
        more.getSubMenu().addItem(new Item("Label", MaterialSymbol.LABEL));
        more.getSubMenu().addItem(new Item("Print", MaterialSymbol.PRINT));
        more.getSubMenu().addItem(new Item("Export", MaterialSymbol.FILE_EXPORT));

        return menuBar;
    }

    private ArrayList<Employee> createEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        for (String name : names) {
            employees.add(new Employee(name.split(" ")[0], name.split(" ")[1]));
        }
        return employees;
    }


    private static class Employee {
        private String firstName;
        private String lastName;

        public Employee(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
