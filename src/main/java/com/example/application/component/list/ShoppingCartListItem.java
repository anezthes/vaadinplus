package com.example.application.component.list;

import com.example.application.component.Layout;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.theme.lumo.LumoUtility.*;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class ShoppingCartListItem extends ListItem {

    public ShoppingCartListItem(String src, String alt, String title, String description, String price) {
        addClassNames(AlignItems.START, Display.FLEX, FlexDirection.COLUMN, FlexDirection.Breakpoint.Large.ROW,
                Gap.LARGE, Padding.Vertical.LARGE, Position.RELATIVE);

        Image image = new Image(src, alt);
        image.addClassNames(BorderRadius.LARGE);
        image.setWidthFull();

        Layout imageLayout = new Layout(image);
        imageLayout.addClassNames(Flex.SHRINK_NONE);
        imageLayout.setAlignItems(Layout.AlignItems.START);
        imageLayout.setJustifyContent(Layout.JustifyContent.CENTER);
        imageLayout.setWidth(10, Unit.REM);

        H3 h3 = new H3(title);
        h3.addClassNames(FontSize.MEDIUM, LineHeight.MEDIUM);

        Paragraph description1 = new Paragraph(description);
        description1.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        IntegerField quantity = new IntegerField();
        quantity.setAriaLabel("Quantity");
        quantity.setMax(9);
        quantity.setMin(1);
        quantity.setStepButtonsVisible(true);
        quantity.setValue(1);
        quantity.setWidth(6, Unit.REM);

        Button favourite = new Button(LineAwesomeIcon.HEART.create());
        favourite.addClassNames(TextColor.SECONDARY);
        favourite.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        favourite.setAriaLabel("Favourite");

        Button delete = new Button(LineAwesomeIcon.TRASH_SOLID.create());
        delete.addClassNames(TextColor.SECONDARY);
        delete.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        delete.setAriaLabel("Delete");

        Layout controls = new Layout(quantity, favourite, delete);
        controls.addClassNames(Margin.Top.AUTO);
        controls.setGap(Layout.Gap.MEDIUM);

        Layout info = new Layout(h3, description1, controls);
        info.addClassNames(Flex.GROW);
        info.setFlexDirection(Layout.FlexDirection.COLUMN);

        Paragraph paragraph = new Paragraph(price);
        paragraph.addClassNames(FontWeight.SEMIBOLD, Margin.Vertical.NONE);
        paragraph.setWhiteSpace(WhiteSpace.NOWRAP);

        add(imageLayout, info, paragraph);
    }

}
