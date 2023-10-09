package gui.other;

import gui.launch.CustomePage;
import model.service.LibraryService;

public class BorrowBook extends CustomePage {
    public BorrowBook(LibraryService libraryService) {
        super("Borrow Book Details", libraryService);
        setSize(400, 500);
    }

}
