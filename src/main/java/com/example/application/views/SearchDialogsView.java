package com.example.application.views;

import com.example.application.components.SearchDialog;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Search Dialogs")
@Route(value = "search-dialogs", layout = MainLayout.class)
public class SearchDialogsView extends View {

    public SearchDialogsView() {
        addClassNames(LumoUtility.AlignItems.START, LumoUtility.Padding.Top.LARGE);

        createBasicExample();
        createPaddedExample();
        createPreviewExample();
    }

    private void createBasicExample() {
        SearchDialog dialog = new SearchDialog();

        Button button = new Button("Basic Example", e -> dialog.open());
        button.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        add(button);
    }

    private void createPaddedExample() {
        SearchDialog dialog = new SearchDialog();
        dialog.setPadding(true);

        Button button = new Button("Padded Example", e -> dialog.open());
        button.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        add(button);
    }

    private void createPreviewExample() {
        SearchDialog dialog = new SearchDialog();
        dialog.setPadding(true);
        dialog.setPreview(true);
        dialog.setWidth(800, Unit.PIXELS);

        Button button = new Button("Preview Example", e -> dialog.open());
        button.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());
        add(button);
    }

}
