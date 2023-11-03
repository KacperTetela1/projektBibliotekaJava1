package gui.launch;

import model.model.Book;
import model.model.EBook;
import model.model.Item;

import java.awt.*;

public class DetailsPanel extends Panel {
    private Label key;
    private Label type;
    private Label title;
    private String[] labelNames = new String[]{"Key", "Type", "Title", "Author", "Year", "Language",
            "Available", "Cover type", "Pages", "Is PDF", "File size", "Duration"};
    private Label[] labels = new Label[labelNames.length];
    private Label[] labelsValue = new Label[labelNames.length];
    private Item item;

    public DetailsPanel(Item item) {
        this.item = item;
        GridLayout gridLayout = new GridLayout(12, 2);
        setLayout(gridLayout);
        createLabel(gridLayout);
        setValues();
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

    private void setValues() {
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
            labelsValue[6].setText("Available");
        } else {
            labelsValue[6].setText("Not available");
        }

/*        labelsValue[7].setText(item.getCoverType().);
        labelsValue[8].setText(item.getPages());
        labelsValue[9].setText(item.getIsPDF());
        labelsValue[10].setText(item.getFileSize());
        labelsValue[11].setText(item.getDuration());*/

    }

}
