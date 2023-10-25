package controller;

import model.model.AudioBook;
import model.model.Book;
import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

import java.util.List;

public class LibraryController {
    private LibraryModelService libraryModelService;

    public LibraryController(LibraryModelService libraryModelService) {
        this.libraryModelService = libraryModelService;
    }

    public void createItem(String title, String author, int publicationYear, int numberOfPages, Item.Language language, Book.CoverType coverType) {
        libraryModelService.addItem(new Book(title, author, publicationYear, language, coverType, numberOfPages,true));
    }

    public void createItem(String title, String author, int publicationYear, int fileSize, Item.Language language, boolean isPDF) {
        libraryModelService.addItem(new EBook(title, author, publicationYear, language, isPDF, fileSize,true));
    }

    public void createItem(String title, String author, int publicationYear, int duration, Item.Language language) {
        libraryModelService.addItem(new AudioBook(title, author, publicationYear, language, duration,true));
    }

}
