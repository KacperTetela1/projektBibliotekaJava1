import objects.AudioBook;
import objects.Book;
import objects.EBook;
import objects.LiteraryArt;
import tools.Input;
import tools.Label;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConsoleApp {

    public static void main(String[] args) {
        runConsoleMenu();
    }

    public static void runConsoleMenu() {

        //Tworzenie i wypelnianie jednej biblioteki(naszej bazy danych) w celu symulacji dzialania programu, pozniej mozna zastapic wczytaniem w przypadku serializacji
        LibraryManager schoolLibrary = new LibraryManager();
        Map<Integer,String> tmp = new HashMap<>();
        tmp = schoolLibrary.deserial();


        //System.exit(0);

        //Wyswietla przywitanie
        Label.printHelloLabel();

        //Pyta uzytkownika co chce zrobic
        switchAsker(schoolLibrary);

        //Wyswietla pozegnalny komunikat
        Label.printGoodByeLabel();

    }

    private static void serialization(LibraryManager nameOfLibrary) {
        nameOfLibrary.serial();
    }

    private static void deserialization(LibraryManager nameOfLibrary) {
        //nameOfLibrary.deserial();
    }

    private static void switchAsker(LibraryManager nameOfLibrary) {

        // tworzy boolean ktory jest ustawiony na true, w momencie zmiany na false aplikacja sie zamyka poniewaz petla while nie dostanie true
        boolean running = true;
        while (running) {

            Label.printListOfChoices();

            switch (Input.intScanner()) {
                case 1:
                    //add book
                    addBook(nameOfLibrary);
                    break;
                case 2:
                    //add ebook
                    addEBook(nameOfLibrary);
                    break;
                case 3:
                    //add audioBook
                    addAudioBook(nameOfLibrary);
                    break;
                case 4:
                    //delete book
                    deleteBook(nameOfLibrary);
                    break;
                case 5:
                    //print all Arts
                    printAllArts(nameOfLibrary);
                    break;
                case 6:
                    //borrow a book()
                    borrowBook(nameOfLibrary);
                    break;
                case 7:
                    //returnBook()
                    returnBook(nameOfLibrary);
                    break;
                case 0:
                    //zamkniecie programu
                    serialization(nameOfLibrary);

                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

    }

    private static void addBook(LibraryManager nameOfLibrary) {

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
                book.setLanguage(LiteraryArt.Language.POLISH);
                break;
            case 2:
                book.setLanguage(LiteraryArt.Language.ENGLISH);
                break;
            case 3:
                book.setLanguage(LiteraryArt.Language.GERMAN);
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

        book.setAvailability(true);
        System.out.println(nameOfLibrary.addArt(book));

    }

    private static void addEBook(LibraryManager nameOfLibrary) {

        Label.printEntryTitle();
        String title = Input.StringScanner();

        Label.printEntryAuthor();
        String author = Input.StringScanner();

        Label.printEntryPublicationYear();
        int publicationYear = Input.intScanner();

        System.out.println("Please enter the size of eBook file (MB)");
        int fileSize = Input.intScanner();

        Book eBook = new Book(title, author, publicationYear, fileSize);

        Label.printEntryLanguage();
        switch (Input.intScanner()) {
            case 1:
                eBook.setLanguage(LiteraryArt.Language.POLISH);
                break;
            case 2:
                eBook.setLanguage(LiteraryArt.Language.ENGLISH);
                break;
            case 3:
                eBook.setLanguage(LiteraryArt.Language.GERMAN);
                break;
            default:
                System.out.println("Language has not been set");
        }

        eBook.setAvailability(true);
        System.out.println(nameOfLibrary.addArt(eBook));

    }

    private static void addAudioBook(LibraryManager nameOfLibrary) {

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
                audioBook.setLanguage(LiteraryArt.Language.POLISH);
                break;
            case 2:
                audioBook.setLanguage(LiteraryArt.Language.ENGLISH);
                break;
            case 3:
                audioBook.setLanguage(LiteraryArt.Language.GERMAN);
                break;
            default:
                System.out.println("Language has not been set");
        }

        audioBook.setAvailability(true);
        System.out.println(nameOfLibrary.addArt(audioBook));

    }

    private static void deleteBook(LibraryManager nameOfLibrary) {
        System.out.println("Select the book you want to delete by Key number");
        nameOfLibrary.printAllArts();

        try {
            int deleteKeyValue = Input.intScanner();
            System.out.println(nameOfLibrary.deleteArt(deleteKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    private static void printAllArts(LibraryManager nameOfLibrary) {
        String[] newArray = nameOfLibrary.printAllArts();

        for (int i = 0; i < newArray.length; i++)
            System.out.println(newArray[i]);

    }

    private static void borrowBook(LibraryManager nameOfLibrary) {
        System.out.println("Select the art you want to borrow by Key number");
        nameOfLibrary.printAllArts();

        try {
            int borrowKeyValue = Input.intScanner();
            System.out.println(nameOfLibrary.rentAnArt(borrowKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

    private static void returnBook(LibraryManager nameOfLibrary) {
        System.out.println("Select the art you want to return by Key number");
        nameOfLibrary.printAllArts();

        try {
            int returnKeyValue = Input.intScanner();
            System.out.println(nameOfLibrary.returnAnArt(returnKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

}