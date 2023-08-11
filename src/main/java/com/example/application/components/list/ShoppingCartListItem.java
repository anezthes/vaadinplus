package com.example.application.components.list;

import com.example.application.components.Layout;
import com.example.application.utilities.Gap;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class ShoppingCartListItem extends ListItem {

    private Image image;
    private H3 title;
    private Paragraph description;
    private Paragraph price;

    public ShoppingCartListItem(String src, String alt, String title, String description, String price) {
        addClassNames(LumoUtility.AlignItems.START, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
                LumoUtility.FlexDirection.Breakpoint.Large.ROW, LumoUtility.Gap.LARGE,
                LumoUtility.Padding.Vertical.LARGE, LumoUtility.Position.RELATIVE);

        this.image = new Image(src, alt);
        this.image.addClassNames(LumoUtility.BorderRadius.LARGE);
        this.image.setWidthFull();

        Layout img = new Layout(this.image);
        img.addClassNames(LumoUtility.Flex.SHRINK_NONE);
        img.setAlignItems(FlexComponent.Alignment.START);
        img.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        img.setWidth(10, Unit.REM);

        this.title = new H3(title);
        this.title.addClassNames(LumoUtility.FontSize.MEDIUM, LumoUtility.LineHeight.MEDIUM);

        this.description = new Paragraph(description);
        this.description.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.TextColor.SECONDARY);

        IntegerField quantity = new IntegerField();
        quantity.setAriaLabel("Quantity");
        quantity.setMax(9);
        quantity.setMin(1);
        quantity.setStepButtonsVisible(true);
        quantity.setValue(1);
        quantity.setWidth(6, Unit.REM);

        Button favourite = new Button(LineAwesomeIcon.HEART.create());
        favourite.addClassNames(LumoUtility.TextColor.SECONDARY);
        favourite.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        favourite.setAriaLabel("Favourite");

        Button delete = new Button(LineAwesomeIcon.TRASH_SOLID.create());
        delete.addClassNames(LumoUtility.TextColor.SECONDARY);
        delete.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        delete.setAriaLabel("Delete");

        Layout controls = new Layout(quantity, favourite, delete);
        controls.addClassNames(LumoUtility.Margin.Top.AUTO);
        controls.setGap(Gap.MEDIUM);

        Layout info = new Layout(this.title, this.description, controls);
        info.addClassNames(LumoUtility.Flex.GROW);
        info.setFlexDirection(FlexLayout.FlexDirection.COLUMN);

        this.price = new Paragraph(price);
        this.price.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.Margin.NONE);
        this.price.setWhiteSpace(WhiteSpace.NOWRAP);

        add(img, info, this.price);
    }

}
