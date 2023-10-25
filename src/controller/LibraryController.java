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

    public Item findItem(int id) {
        return libraryModelService.getLibraryMap().stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

/*    public Book downloadDetailsBook(int id, String type) {
        Item item = findItem(id);
        Book itemToReturn = null;
        if (type.equals("Book"))
            itemToReturn = new Book(item.getTitle(), item.getAuthor(), item.getYearPublished(), item.getLanguage(), ((Book) item).getCoverType(), ((Book) item).getNumberOfPages(),true);
        return itemToReturn;
    }

    public EBook downloadDetailsEBook(int id, String type) {
        Item item = findItem(id);
        EBook itemToReturn = null;
        if (type.equals("EBook"))
            itemToReturn = new EBook(item.getTitle(), item.getAuthor(), item.getYearPublished(), item.getLanguage(), ((EBook) item).isPDF(), ((EBook) item).getFileSize());
        return itemToReturn;
    }

    public AudioBook downloadDetailsAudioBook(int id, String type) {
        Item item = findItem(id);
        AudioBook itemToReturn = null;
        if (type.equals("AudioBook"))
            itemToReturn = new AudioBook(item.getTitle(), item.getAuthor(), item.getYearPublished(), item.getLanguage(), ((AudioBook) item).getDuration());
        return itemToReturn;
    }*/

}
