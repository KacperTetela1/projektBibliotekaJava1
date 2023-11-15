package gui.launch;

import model.model.AudioBook;
import model.model.Book;
import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends Panel {
    JButton rentButton;
    JButton deleteButton;
    private Label key;
    private Label type;
    private Label title;
    private String[] labelNames = new String[]{"Key", "Type", "Title", "Author", "Year", "Language",
            "Available", "Cover type", "Pages", "Is PDF", "File size (MB)", "Duration (min)"};
    private Label[] labels = new Label[labelNames.length];
    private Label[] labelsValue = new Label[labelNames.length];
    private Item item;
    LibraryModelService libraryModelService;

    public DetailsPanel(LibraryModelService libraryModelService) {
        this.libraryModelService = libraryModelService;
        //this.item = item;
        GridLayout gridLayout = new GridLayout(labelNames.length + 2, 2);
        setLayout(gridLayout);
        createLabel(gridLayout);
        //setValues();
        createFunctionsButtons();
    }

    private void createLabel(LayoutManager layout) {
        for (int i = 0; i < labels.length; i++) {
            Label label = new Label();
            label.setText(labelNames[i] + ": ");
            labels[i] = label;
            add(label);

            Label labelValue = new Label();
            labelsValue[i] = labelValue;
            add(labelValue);

        }

    }

    public void setValues(Item item) {
        String keyId = Integer.toString(item.getId());
        labelsValue[0].setText(keyId);

        if (item instanceof Book) labelsValue[1].setText("Book");
        else if (item instanceof EBook) labelsValue[1].setText("EBook");
        else labelsValue[1].setText("AudioBook");

        labelsValue[2].setText(item.getTitle());
        labelsValue[3].setText(item.getAuthor());

        String year = Integer.toString(item.getYearPublished());
        labelsValue[4].setText(year);
        labelsValue[5].setText(item.getLanguage().toString());

        if (item.isAvailability()) {
            labelsValue[6].setText("Yes");
        } else {
            labelsValue[6].setText("No");
        }

        if (item instanceof Book) {
            labelsValue[7].setText(((Book) item).getCoverType().toString());
            String pages = Integer.toString(((Book) item).getNumberOfPages());
            labelsValue[8].setText(pages);
            labelsValue[9].setText("");
            labelsValue[10].setText("");
            labelsValue[11].setText("");
        } else if (item instanceof EBook) {
            if (((EBook) item).isPDF()) {
                labelsValue[9].setText("Yes");
            } else {
                labelsValue[9].setText("No");
            }
            labelsValue[7].setText("");
            labelsValue[8].setText("");
            labelsValue[11].setText("");
            String fileSize = Integer.toString(((EBook) item).getFileSize());
            labelsValue[10].setText(fileSize);
        } else {
            String duration = Integer.toString((((AudioBook) item).getDuration())/60);
            labelsValue[11].setText(duration);
            labelsValue[7].setText("");
            labelsValue[8].setText("");
            labelsValue[9].setText("");
            labelsValue[10].setText("");
        }
    }

    public void setFunctionsButtons(Item item) {

        rentButton.setVisible(true);
        deleteButton.setVisible(true);

        if (item.isAvailability()) {
            rentButton.setText("Rent");
        } else {
            rentButton.setText("Return");
        }

        rentButton.addActionListener(e -> {
            if (item.isAvailability()) {
                item.setAvailability(false);
                rentButton.setText("Return");
                LaunchPage launchPage = new LaunchPage(libraryModelService);
            } else {
                item.setAvailability(true);
                rentButton.setText("Rent");
                LaunchPage launchPage = new LaunchPage(libraryModelService);
            }
        });

        deleteButton.addActionListener(e -> {
            libraryModelService.deleteItem(item.getId());
            //setVisible(false);
            setValuesToNull();
            LaunchPage launchPage = new LaunchPage(libraryModelService);
        });

    }

    private void createFunctionsButtons() {

        rentButton = new JButton("Rent/Return");
        deleteButton = new JButton("Delete");

        rentButton.setFocusable(false);
        deleteButton.setFocusable(false);

        rentButton.setVisible(false);
        deleteButton.setVisible(false);

        add(rentButton);
        add(deleteButton);

    }

    private void setValuesToNull() {
        for (int i = 0; i < labelsValue.length; i++) {
            labelsValue[i].setText("");
        }
        rentButton.setVisible(false);
        deleteButton.setVisible(false);
    }

}
