import Objects.AudioBook;
import Objects.Book;
import Objects.EBook;
import Objects.LiteraryArt;

import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        runConsoleMenu();
    }

    public static void runConsoleMenu() {
        Scanner scanner = importScanner();

        //tworzenie i wypelnianie jednej biblioteki(naszej bazy danych) w celu symulacji dzialania programu, pozniej mozna zastapic wczytaniem w przypadku serializacji
        LibraryManager schoolLibrary = new LibraryManager();
        LiteraryArt ogniemIMieczem = new Book("Ogniem i Mieczem","Henryk Sienkiewicz",1884, LiteraryArt.Language.POLISH, Book.CoverType.HARD,588);
        LiteraryArt stonesForTheRampart = new Book("Stones for the Rampart","\tAleksander Kamiński",1943, LiteraryArt.Language.ENGLISH, Book.CoverType.SOFT,256);
        LiteraryArt javaPodstawyhorstmann = new Book("Java Podstawy Horstmann","Cay'a Horstmanna",1995, LiteraryArt.Language.POLISH, Book.CoverType.HARD,785);
        LiteraryArt panTadeusz = new EBook("Pan Tadeusz","Adam Mickiewicz",1834, LiteraryArt.Language.POLISH,true,48);
        schoolLibrary.addArt(ogniemIMieczem);
        schoolLibrary.addArt(stonesForTheRampart);
        schoolLibrary.addArt(javaPodstawyhorstmann);
        schoolLibrary.addArt(panTadeusz);

        ///////////////////////////////////////////////////////
        //Aplikacja przechodzi do dzialania
        //////////////////////////////////////////////////////

        printHelloLabel();

        // tworzy boolean ktory jest ustawiony na true, w momencie zmiany na false aplikacja sie zamyka poniewaz petla while nie dostanie true
        boolean running = true;
        while (running == true) {

            printListOfChoices();

            //pobiera int ktory jest potrzebny do wybrania pozycji w menu
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    //add book
                    addBook(schoolLibrary);
                    break;
                case 2:
                    //add ebook
                    addEBook(schoolLibrary);
                    break;
                case 3:
                    //add audioBook
                    addAudioBook(schoolLibrary);
                    break;
                case 4:
                    //delete a book();
                    break;
                case 5:
                    schoolLibrary.printAllArts();
                    break;
                case 6:
                    //borrow a book();
                    break;
                case 7:
                    //returnBook();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        printGoodByeLabel();

    }

    private static int intScanner() {
        Scanner scanner = importScanner();
        return scanner.nextInt();
    }
    private static Scanner importScanner() {
        //pobieranie scannera ktory jest potrzebny metodzie
        return new Scanner(System.in);
    }

    private static void printHelloLabel() {
        System.out.println("Welcome to the library!");
    }

    private static void printListOfChoices() {
        System.out.println("Select an option:");
        System.out.println("1. Add a book");
        System.out.println("2. Add a e-book");
        System.out.println("3. Add a audio-book");
        System.out.println("4. Delete a book");
        System.out.println("5. Display book list");
        System.out.println("6. Borrow a book");
        System.out.println("7. Return a book");
        System.out.println("0. Exit the library");
    }

    private static void printGoodByeLabel() {
        System.out.println("Thank you for using the library. Goodbye!");
    }

    private static void addBook(LibraryManager nameOfLibrary) {
        Scanner scanner = importScanner();

        Book book = new Book();

        System.out.println("Please enter the title\n");
        String title = scanner.nextLine();
        book.setTitle(title);

        System.out.println("Please enter the author\n");
        String author = scanner.nextLine();
        book.setAuthor(author);

        System.out.println("Please enter the year of publication\n");
        int yearPublished = scanner.nextInt();
        book.setYearPublished(yearPublished);

        System.out.println("Please enter the language of book" +
                "\n1. Polish" +
                "\n2. English" +
                "\n3. German");
        int tmpVal = scanner.nextInt();
        switch (tmpVal){
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
        int temVal2 = scanner.nextInt();
        switch (temVal2){
            case 1:
                book.setCoverType(Book.CoverType.HARD);
                break;
            case 2:
                book.setCoverType(Book.CoverType.SOFT);
                break;
            default:
                System.out.println("Type of cover has not been set");
        }

        System.out.println("Please enter the number of pages");
        int numberOfPages = scanner.nextInt();
        book.setNumberOfPages(numberOfPages);

        nameOfLibrary.addArt(book);

    }

    private static void addEBook(LibraryManager nameOfLibrary) {
        Scanner scanner = importScanner();

        EBook eBook = new EBook();

        System.out.println("Please enter the title\n");
        String titleOfEBook = scanner.nextLine();
        eBook.setTitle(titleOfEBook);

        System.out.println("Please enter the author\n");
        String authorOfEbook = scanner.nextLine();
        eBook.setAuthor(authorOfEbook);

        System.out.println("Please enter the year of publication\n");
        int yearPublishedOfTheEbook = scanner.nextInt();
        eBook.setYearPublished(yearPublishedOfTheEbook);

        System.out.println("Please enter the language of ebook" +
                "\n1. Polish" +
                "\n2. English" +
                "\n3. German");
        int tmpValOfEbook = scanner.nextInt();
        switch (tmpValOfEbook){
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

        System.out.println("Please enter the size of eBook file (MB)");
        int size = scanner.nextInt();
        eBook.setFileSize(size);

        nameOfLibrary.addArt(eBook);

    }

    private static void addAudioBook(LibraryManager nameOfLibrary) {
        Scanner scanner = importScanner();

        AudioBook audioBook = new AudioBook();

        System.out.println("Please enter the title\n");
        String titleOfAudiobook = scanner.nextLine();
        audioBook.setTitle(titleOfAudiobook);

        System.out.println("Please enter the author\n");
        String authorOfAudiobook = scanner.nextLine();
        audioBook.setAuthor(authorOfAudiobook);

        System.out.println("Please enter the year of publication\n");
        int yearPublishedOfAudioBook = scanner.nextInt();
        audioBook.setYearPublished(yearPublishedOfAudioBook);

        System.out.println("Please enter the language of audiobook" +
                "\n1. Polish" +
                "\n2. English" +
                "\n3. German");
        int tmpValOfAudioBook = scanner.nextInt();
        switch (tmpValOfAudioBook){
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
        System.out.println("Please enter the duration of audiobook (seconds)");
        int duration = scanner.nextInt();
        audioBook.setDuration(duration);

        nameOfLibrary.addArt(audioBook);

    }
}