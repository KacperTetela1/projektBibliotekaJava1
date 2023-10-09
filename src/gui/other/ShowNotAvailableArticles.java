package gui.other;

import gui.launch.CustomePage;
import model.service.LibraryService;

public class ShowNotAvailableArticles extends CustomePage {
    public ShowNotAvailableArticles() {
        super("Not Available Articles", new LibraryService());
        setSize(400, 500);
    }

}
