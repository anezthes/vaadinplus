package com.example.application.components.list;

import com.example.application.components.Layout;
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

    private Image image;
    private H3 title;
    private Paragraph description;
    private Paragraph price;

    public ShoppingCartListItem(String src, String alt, String title, String description, String price) {
        addClassNames(AlignItems.START, Display.FLEX, FlexDirection.COLUMN, FlexDirection.Breakpoint.Large.ROW,
                Gap.LARGE, Padding.Vertical.LARGE, Position.RELATIVE);

        this.image = new Image(src, alt);
        this.image.addClassNames(BorderRadius.LARGE);
        this.image.setWidthFull();

        Layout img = new Layout(this.image);
        img.addClassNames(Flex.SHRINK_NONE);
        img.setAlignItems(Layout.AlignItems.START);
        img.setJustifyContent(Layout.JustifyContent.CENTER);
        img.setWidth(10, Unit.REM);

        this.title = new H3(title);
        this.title.addClassNames(FontSize.MEDIUM, LineHeight.MEDIUM);

        this.description = new Paragraph(description);
        this.description.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

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

        Layout info = new Layout(this.title, this.description, controls);
        info.addClassNames(Flex.GROW);
        info.setFlexDirection(Layout.FlexDirection.COLUMN);

        this.price = new Paragraph(price);
        this.price.addClassNames(FontWeight.SEMIBOLD, Margin.Vertical.NONE);
        this.price.setWhiteSpace(WhiteSpace.NOWRAP);

        add(img, info, this.price);
    }

}
