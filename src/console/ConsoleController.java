package console;

import model.model.AudioBook;
import model.model.Book;
import model.model.EBook;
import model.model.Item;
import model.service.LibraryModelService;

public class ConsoleController {
    private LibraryModelService libraryModelService;

    public ConsoleController(LibraryModelService libraryModelService) {
        this.libraryModelService = libraryModelService;
    }

    public void runConsoleMenu() {

        //Wyswietla przywitanie
        Label.printHelloLabel();

        //Pyta uzytkownika co chce zrobic
        switchAsker();

        //Wyswietla pozegnalny komunikat
        Label.printGoodByeLabel();

    }

    private void switchAsker() {

        // tworzy boolean ktory jest ustawiony na true, w momencie zmiany na false aplikacja sie zamyka poniewaz petla while nie dostanie true
        boolean running = true;
        while (running) {

            Label.printListOfChoices();

            switch (Input.intScanner()) {
                case 1:
                    //add book
                    addBook();
                    break;
                case 2:
                    //add ebook
                    addEBook();
                    break;
                case 3:
                    //add audioBook
                    addAudioBook();
                    break;
                case 4:
                    //delete book
                    deleteBook();
                    break;
                case 5:
                    //print all Arts
                    printAllArts();
                    break;
                case 6:
                    //borrow a book()
                    borrowBook();
                    break;
                case 7:
                    //returnBook()
                    returnBook();
                    break;
                case 0:
                    //zamkniecie programu
                    libraryModelService.serialization(); // activate serialization

                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

    }

    private void addBook() {

        Label.printEntryTitle();
        String title = Input.StringScanner();

        Label.printEntryAuthor();
        String author = Input.StringScanner();

        Label.printEntryPublicationYear();
        int publicationYear = Input.intScanner();

        Label.printEntryPagesAmount();
        int numberOfPages = Input.intScanner();

        Book book = new Book(title, author, publicationYear, numberOfPages);


        Label.printEntryLanguage();
        switch (Input.intScanner()) {
            case 1:
                book.setLanguage(Item.Language.POLISH);
                break;
            case 2:
                book.setLanguage(Item.Language.ENGLISH);
                break;
            case 3:
                book.setLanguage(Item.Language.GERMAN);
                break;
            default:
                System.out.println("Language has not been set");
        }

        System.out.println("Does the book is in hard cover?" +
                "\n1. Yes" +
                "\n2. No");

        switch (Input.intScanner()) {
            case 1:
                book.setCoverType(Book.CoverType.HARD);
                break;
            case 2:
                book.setCoverType(Book.CoverType.SOFT);
                break;
            default:
                System.out.println("Type of cover has not been set");
        }

        //System.out.println(libraryModelService.addItem(book));

    }

    private void addEBook() {

        Label.printEntryTitle();
        String title = Input.StringScanner();

        Label.printEntryAuthor();
        String author = Input.StringScanner();

        Label.printEntryPublicationYear();
        int publicationYear = Input.intScanner();

        System.out.println("Please enter the size of eBook file (MB)");
        int fileSize = Input.intScanner();

        EBook eBook = new EBook(title, author, publicationYear, fileSize);

        Label.printEntryLanguage();
        switch (Input.intScanner()) {
            case 1:
                eBook.setLanguage(Item.Language.POLISH);
                break;
            case 2:
                eBook.setLanguage(Item.Language.ENGLISH);
                break;
            case 3:
                eBook.setLanguage(Item.Language.GERMAN);
                break;
            default:
                System.out.println("Language has not been set");
        }

        //System.out.println(libraryModelService.addItem(eBook));

    }

    private void addAudioBook() {

        Label.printEntryTitle();
        String title = Input.StringScanner();

        Label.printEntryAuthor();
        String author = Input.StringScanner();

        Label.printEntryPublicationYear();
        int publicationYear = Input.intScanner();

        System.out.println("Please enter the duration of audiobook (seconds)");
        int duration = Input.intScanner();

        AudioBook audioBook = new AudioBook(title, author, publicationYear, duration);

        Label.printEntryLanguage();
        switch (Input.intScanner()) {
            case 1:
                audioBook.setLanguage(Item.Language.POLISH);
                break;
            case 2:
                audioBook.setLanguage(Item.Language.ENGLISH);
                break;
            case 3:
                audioBook.setLanguage(Item.Language.GERMAN);
                break;
            default:
                System.out.println("Language has not been set");
        }

        //System.out.println(libraryModelService.addItem(audioBook));

    }

    private void deleteBook() {
        System.out.println("Select the book you want to delete by Key number");
        //libraryModelService.printAllItems();

        try {
            int deleteKeyValue = Input.intScanner();
            System.out.println(libraryModelService.deleteItem(deleteKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    private void printAllArts() {
        //String[] newArray = libraryModelService.printAllItems();

/*        for (int i = 0; i < newArray.length; i++)
            System.out.println(newArray[i]);*/

    }

    private void borrowBook() {
        System.out.println("Select the art you want to borrow by Key number");
        //libraryModelService.printAllItems();

        try {
            int borrowKeyValue = Input.intScanner();
            System.out.println(libraryModelService.rentAnItem(borrowKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

    private void returnBook() {
        System.out.println("Select the art you want to return by Key number");
        //libraryModelService.printAllItems();

        try {
            int returnKeyValue = Input.intScanner();
            System.out.println(libraryModelService.returnAnItem(returnKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

}
