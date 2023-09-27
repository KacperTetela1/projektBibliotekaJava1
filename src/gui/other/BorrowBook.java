package gui.other;

import gui.basic.CustomePage;
import gui.write.CustomWritePage;
import service.LibraryService;

public class BorrowBook extends CustomePage {

    public BorrowBook(LibraryService libraryService) {
        super("Borrow Book Details", libraryService);

    }

}
