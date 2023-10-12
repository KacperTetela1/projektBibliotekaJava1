package controller;

import model.model.AudioBook;
import model.model.Book;
import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

public class LibraryController {
    LibraryModelService libraryModelService = new LibraryModelService();
    public void createItem(String title, String author, int publicationYear, int numberOfPages, Item.Language language, Book.CoverType coverType) {
        libraryModelService.addItem(new Book(title,author,publicationYear, language, coverType, numberOfPages));
    }

    public void createItem(String title, String author, int publicationYear, int fileSize, Item.Language language, boolean isPDF) {
        libraryModelService.addItem(new EBook(title,author,publicationYear, language, isPDF, fileSize));
    }

    public void createItem(String title, String author, int publicationYear, int duration, Item.Language language) {
        libraryModelService.addItem(new AudioBook(title,author,publicationYear,language, duration));
    }

}
