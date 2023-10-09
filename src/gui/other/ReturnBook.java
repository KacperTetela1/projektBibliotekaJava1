package gui.other;

import gui.launch.CustomePage;
import model.service.LibraryService;

public class ReturnBook extends CustomePage {
    public ReturnBook() {
        super("Return book",new LibraryService());
        setSize(400, 500);
    }

}
