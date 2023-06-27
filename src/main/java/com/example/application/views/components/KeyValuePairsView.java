package com.example.application.views.components;

import com.example.application.components.KeyValuePair;
import com.example.application.components.KeyValuePairs;
import com.example.application.utilities.GridColumnSpan;
import com.example.application.utilities.GridColumns;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;

@PageTitle("Key-Value Pairs")
@Route(value = "key-value-pairs", layout = MainLayout.class)
public class KeyValuePairsView extends ComponentView {

    public KeyValuePairsView() {
        addH2("Horizontal with Breakpoint");
        addPreview(createKeyValuePairs());

        addH2("Horizontal without Breakpoint");
        addPreview(createKeyValuePairsWithoutBreakpoint());

        addH2("Vertical");
        addPreview(createVerticalKeyValuePairs());

        addH2("Column Span");
        addPreview(createKeyValuePairsWithColumnSpan());

        addH2("Theme: Dividers");
        addPreview(createKeyValuePairsWithDividers());

        addH2("Theme: Stripes");
        addPreview(createKeyValuePairsWithStripes());
    }

    private KeyValuePairs createKeyValuePairs() {
        return new KeyValuePairs(
                new KeyValuePair("Name", "John Smith"),
                new KeyValuePair("Email", "john.smith@company.com"),
                new KeyValuePair("About", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
                new KeyValuePair("Actions", new Button("Edit", LineAwesomeIcon.EDIT.create()))
        );
    }

    private KeyValuePairs createKeyValuePairsWithoutBreakpoint() {
        KeyValuePairs pairs = createKeyValuePairs();
        pairs.removeBreakpoint();
        return pairs;
    }

    private KeyValuePairs createVerticalKeyValuePairs() {
        KeyValuePairs pairs = createKeyValuePairs();
        pairs.setKeyPosition(KeyValuePair.KeyPosition.TOP);
        return pairs;
    }

    private KeyValuePairs createKeyValuePairsWithColumnSpan() {
        KeyValuePairs pairs = createKeyValuePairs();
        pairs.setColumns(GridColumns.COLUMNS_2);
        pairs.setColumnSpan(
                GridColumnSpan.COLUMN_SPAN_2,
                // Just beautiful...
                pairs.getChildren().skip(2).findFirst().get()
        );
        pairs.setKeyPosition(KeyValuePair.KeyPosition.TOP);
        return pairs;
    }

    private KeyValuePairs createKeyValuePairsWithDividers() {
        KeyValuePairs pairs = createKeyValuePairs();
        pairs.setDividers(true);
        return pairs;
    }

    private KeyValuePairs createKeyValuePairsWithStripes() {
        KeyValuePairs pairs = createKeyValuePairs();
        pairs.setStripes(true);
        return pairs;
    }

}
