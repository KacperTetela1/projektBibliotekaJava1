package gui.other;

import gui.launch.CustomePage;
import model.service.LibraryService;

public class Delete extends CustomePage {
    public Delete() {
        super("Delete", new LibraryService());
        setSize(400, 500);
    }

}
