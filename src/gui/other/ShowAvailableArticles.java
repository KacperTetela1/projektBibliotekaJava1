package gui.other;

import gui.launch.CustomePage;
import model.service.LibraryService;

public class ShowAvailableArticles extends CustomePage {
    public ShowAvailableArticles() {
        super("AvailableArticles", new LibraryService());
        setSize(400, 500);
    }

}
