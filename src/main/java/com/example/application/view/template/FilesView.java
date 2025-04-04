package com.example.application.view.template;

import com.example.application.component.Header;
import com.example.application.component.Layout;
import com.example.application.component.MaterialSymbol;
import com.example.application.theme.RadioButtonTheme;
import com.example.application.theme.UploadTheme;
import com.example.application.utility.Breakpoint;
import com.example.application.utility.Font;
import com.example.application.view.HomeView;
import com.example.application.view.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@PageTitle("Files")
@Route(value = "files", layout = MainLayout.class)
public class FilesView extends Main {

    private final Person PERSON_1 = new Person("Ava Smith", "ava.smith@company.com", "https://images.unsplash.com/photo-1530785602389-07594beb8b73?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

    private final Person PERSON_2 = new Person("Emma Johnson", "emma.johnson@company.com", "https://images.unsplash.com/photo-1553514029-1318c9127859?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

    private final Person PERSON_3 = new Person("Mia Williams", "mia.williams@company.com", "https://images.unsplash.com/photo-1580489944761-15a19d654956?&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80");

    public FilesView() {
        addClassNames(Display.FLEX, FlexDirection.COLUMN, Gap.LARGE, Padding.LARGE);
        add(createHeader(), createUpload(), createToolbar(), createContent());
    }

    private Component createHeader() {
        Header header = new Header("Files");
        header.setHeadingFontSize(Font.Size.XXLARGE);
        header.removeClassName(Border.BOTTOM);

        // Tweak the header's row layout
        header.getRowLayout().setAlignItems(Layout.AlignItems.START);
        header.getRowLayout().setFlexWrap(Layout.FlexWrap.NOWRAP);
        header.getRowLayout().setFlexDirection(Layout.FlexDirection.COLUMN);
        header.getRowLayout().setFlexDirection(Breakpoint.MEDIUM, Layout.FlexDirection.ROW);
        header.getRowLayout().removeClassName(Padding.MEDIUM);

        // Prefix
        RouterLink link = new RouterLink(HomeView.class);
        link.add(MaterialSymbol.WEST.create());
        link.addClassNames(AlignItems.CENTER, BorderRadius.MEDIUM, Display.FLEX, Height.MEDIUM, JustifyContent.CENTER,
                Width.MEDIUM);
        link.getElement().setAttribute("aria-label", "Home");
        Tooltip.forComponent(link).setText("Home");
        header.setPrefix(link);

        // Details
        Paragraph description = new Paragraph("Comprehensive list of all files within your organisation. Browse, organize, and manage your stored content here.");
        description.addClassNames(Margin.Vertical.NONE);
        header.setDetails(description);

        // Actions
        Button access = new Button("Access", MaterialSymbol.LOCK_OPEN.create());
        Button create = new Button("Create", MaterialSymbol.ADD.create());
        create.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        header.setActions(access, create);

        return header;
    }

    private Component createUpload() {
        Button button = new Button("Click to upload");
        button.addClassNames(Margin.Bottom.MEDIUM);
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);

        Span icon = MaterialSymbol.UPLOAD.create(AlignItems.CENTER, Border.ALL, BorderRadius.LARGE, Display.FLEX,
                Height.MEDIUM, JustifyContent.CENTER, Margin.Bottom.SMALL, Margin.Horizontal.AUTO, "order-first",
                Padding.SMALL, Width.MEDIUM);

        Span label = new Span("or drag and drop");
        label.addClassNames(Margin.Minus.Start.SMALL);

        Upload upload = new Upload();
        upload.addClassNames(Display.FLEX, FlexDirection.COLUMN, Padding.Bottom.NONE, Padding.Top.MEDIUM);
        upload.getElement().appendChild(icon.getElement());
        upload.getElement().getThemeList().add(UploadTheme.ALT);
        upload.setUploadButton(button);
        upload.setDropLabel(label);
        upload.setDropLabelIcon(MaterialSymbol.HIDE.create(Display.HIDDEN));
        return upload;
    }

    private Component createToolbar() {
        RadioButtonGroup<String> viewMode = new RadioButtonGroup<>();
        viewMode.addClassNames(Padding.NONE, Width.FULL, "md:w-auto");
        viewMode.addThemeNames(RadioButtonTheme.EQUAL_WIDTH, RadioButtonTheme.TOGGLE);

        viewMode.setAriaLabel("View mode");
        viewMode.setTooltipText("View mode");

        viewMode.setItems("List", "Columns", "Gallery");
        viewMode.setRenderer(new ComponentRenderer<>(item -> {
            Span span = new Span(item);
            span.addClassNames(FontWeight.MEDIUM, Margin.Horizontal.AUTO, Padding.Horizontal.SMALL, Whitespace.NOWRAP);
            return span;
        }));
        viewMode.setValue("List");

        Button advanced = new Button(MaterialSymbol.TUNE.create());
        advanced.addClassNames(Margin.Minus.End.XSMALL, Margin.Vertical.NONE);
        advanced.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        advanced.setAriaLabel("Advanced search");
        advanced.setTooltipText("Advanced search");

        TextField search = new TextField();
        search.addClassNames(Flex.GROW, "md:flex-grow-0", MinWidth.NONE, Padding.Vertical.NONE);
        search.setAriaLabel("Search");
        search.setClearButtonVisible(true);
        search.setPlaceholder("Search");
        search.setPrefixComponent(MaterialSymbol.SEARCH.create());
        search.setSuffixComponent(advanced);

        Layout toolbar = new Layout(viewMode, search);
        toolbar.setFlexDirection(Layout.FlexDirection.COLUMN);
        toolbar.setFlexDirection(Breakpoint.MEDIUM, Layout.FlexDirection.ROW);
        toolbar.setGap(Layout.Gap.MEDIUM);
        toolbar.setJustifyContent(Layout.JustifyContent.BETWEEN);
        return toolbar;
    }

    private Component createContent() {
        Grid<DummyItem> grid = new Grid<>();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setAllRowsVisible(true);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setItems(createItems());

        grid.addComponentColumn(this::renderName)
                .setAutoWidth(true)
                .setHeader("Name");
        grid.addColumn(new LocalDateRenderer<>(DummyItem::getDate, () -> DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH)))
                .setAutoWidth(true)
                .setHeader("Date");
        grid.addComponentColumn(this::renderOwner)
                .setAutoWidth(true)
                .setHeader("Owner");
        grid.addComponentColumn(this::renderActions)
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setHeader("Actions");

        Div content = new Div(grid);
        content.addClassNames(Border.ALL, BorderRadius.LARGE, Display.FLEX, FlexDirection.COLUMN, Overflow.HIDDEN);
        return content;
    }

    private List<DummyItem> createItems() {
        List<DummyItem> items = new ArrayList<>();
        items.add(new DummyItem("Annual report.pdf", "7.5 MB", LocalDate.now().minusDays(1), PERSON_1));
        items.add(new DummyItem("Budget spreadsheet.xlsx", "12.7 MB", LocalDate.now().minusDays(2), PERSON_2));
        items.add(new DummyItem("Customer survey results.csv", "1.8 MB", LocalDate.now().minusDays(4), PERSON_1));
        items.add(new DummyItem("Financial forecast.pdf", "3.5 MB", LocalDate.now().minusDays(3), PERSON_3));
        items.add(new DummyItem("Marketing strategy.docx", "6.1 MB", LocalDate.now().minusDays(5), PERSON_2));
        return items;
    }

    private Component renderName(DummyItem item) {
        String fileName = item.getFileName();

        Component fileIcon = createFileIcon(fileName);

        Span primary = new Span(fileName);
        primary.addClassNames(FontWeight.SEMIBOLD);

        Span secondary = new Span(item.getSize());
        secondary.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Layout text = new Layout(primary, secondary);
        text.setFlexDirection(Layout.FlexDirection.COLUMN);

        Layout layout = new Layout(fileIcon, text);
        layout.addClassNames(Padding.Vertical.SMALL);
        layout.setAlignItems(Layout.AlignItems.CENTER);
        layout.setGap(Layout.Gap.MEDIUM);
        return layout;
    }

    private Component createFileIcon(String fileName) {
        Div corner = new Div();
        corner.addClassNames(Background.CONTRAST_50, Display.FLEX, Position.ABSOLUTE, Position.End.NONE,
                Position.Top.NONE);
        corner.setHeight(30, Unit.PERCENTAGE);
        corner.setWidth(30, Unit.PERCENTAGE);

        Div fileIcon = new Div(corner, new Span(fileName.substring(fileName.lastIndexOf(".") + 1)));
        fileIcon.addClassNames(AlignItems.END, Background.PRIMARY, BorderRadius.SMALL, Display.FLEX, FontSize.XXSMALL,
                FontWeight.MEDIUM, Height.LARGE, JustifyContent.CENTER, Padding.XSMALL, Position.RELATIVE,
                TextColor.PRIMARY_CONTRAST, Width.MEDIUM);
        fileIcon.getStyle().set("clip-path", "polygon(0% 0%, 70% 0%, 100% 30%, 100% 100%, 0% 100%)");
        return fileIcon;
    }

    private Component renderOwner(DummyItem item) {
        Person person = item.getOwner();

        Image img = new Image(person.getImage(), person.getName());
        img.addClassNames(BorderRadius.FULL, Height.MEDIUM, Width.MEDIUM);

        Span name = new Span(person.getName());

        Span email = new Span(person.getEmail());
        email.addClassNames(FontSize.SMALL, TextColor.SECONDARY);

        Div nameEmail = new Div(name, email);
        nameEmail.addClassNames(Display.FLEX, FlexDirection.COLUMN);

        Div owner = new Div(img, nameEmail);
        owner.addClassNames(AlignItems.CENTER, Display.FLEX, Gap.MEDIUM);
        return owner;
    }

    private Component renderActions(DummyItem item) {
        Button share = new Button(MaterialSymbol.SHARE.create());
        share.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        share.setAriaLabel("Share " + item.getFileName());
        share.setTooltipText("Share " + item.getFileName());

        Button download = new Button(MaterialSymbol.DOWNLOAD.create());
        download.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        download.setAriaLabel("Download " + item.getFileName());
        download.setTooltipText("Download " + item.getFileName());

        Button rename = new Button(MaterialSymbol.EDIT.create());
        rename.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        rename.setAriaLabel("Rename " + item.getFileName());
        rename.setTooltipText("Rename " + item.getFileName());

        Button favourite = new Button(MaterialSymbol.STAR.create());
        favourite.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        favourite.setAriaLabel("Favourite " + item.getFileName());
        favourite.setTooltipText("Favourite " + item.getFileName());

        Div actions = new Div(share, download, rename, favourite);
        actions.addClassNames(Display.FLEX, Margin.Minus.Horizontal.SMALL);
        return actions;
    }

    private static class DummyItem {
        private String fileName;
        private String size;
        private LocalDate date;
        private Person owner;

        public DummyItem(String fileName, String size, LocalDate date, Person owner) {
            this.fileName = fileName;
            this.size = size;
            this.date = date;
            this.owner = owner;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public Person getOwner() {
            return owner;
        }

        public void setOwner(Person owner) {
            this.owner = owner;
        }
    }

    private static class Person {
        private String name;
        private String email;
        private String image;

        public Person(String name, String email, String image) {
            this.name = name;
            this.email = email;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
