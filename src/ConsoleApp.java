import objects.AudioBook;
import objects.Book;
import objects.EBook;
import objects.LiteraryArt;
import tools.Input;
import tools.Label;

public class ConsoleApp {

    public static void main(String[] args) {
        runConsoleMenu();
    }

    public static void runConsoleMenu() {

        //Tworzenie i wypelnianie jednej biblioteki(naszej bazy danych) w celu symulacji dzialania programu, pozniej mozna zastapic wczytaniem w przypadku serializacji
        LibraryManager schoolLibrary = new LibraryManager();
        recordsFillerTMP(schoolLibrary);

        //Wyswietla przywitanie
        Label.printHelloLabel();

        //Pyta uzytkownika co chce zrobic
        switchAsker(schoolLibrary);

        //Wyswietla pozegnalny komunikat
        Label.printGoodByeLabel();

    }

    private static void switchAsker(LibraryManager nameOfLibrary) {

        // tworzy boolean ktory jest ustawiony na true, w momencie zmiany na false aplikacja sie zamyka poniewaz petla while nie dostanie true
        boolean running = true;
        while (running == true) {

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
                    //print all Art from hashMap, method to rebuild by seperate frontend and backend
                    nameOfLibrary.printAllArts();
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
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

    }

    private static void deleteBook(LibraryManager nameOfLibrary) {
        System.out.println("Select the book you want to delete by Key number");
        nameOfLibrary.printAllArts();

        int deleteKeyValue = Input.intScanner();
        nameOfLibrary.deleteArt(deleteKeyValue);

        System.out.println("The book has been deleted from library");

    }

    private static void borrowBook(LibraryManager nameOfLibrary) {
            System.out.println("Select the art you want to borrow by Key number");
            nameOfLibrary.printAllArts();

            int borrowKeyValue = Input.intScanner();
            nameOfLibrary.rentAnArt(borrowKeyValue);

    }

    private static void returnBook(LibraryManager nameOfLibrary) {
        System.out.println("Select the art you want to return by Key number");
        nameOfLibrary.printAllArts();

        int returnKeyValue = Input.intScanner();
        nameOfLibrary.returnAnArt(returnKeyValue);

        //System.out.println("The book has been returned from library");
    }

    private static void addBook(LibraryManager nameOfLibrary) {

        Book book = new Book();

        Label.printEntryTitle();
        book.setTitle(Input.StringScanner());

        Label.printEntryAuthor();
        book.setAuthor(Input.StringScanner());

        Label.printEntryPublicationYear();
        book.setYearPublished(Input.intScanner());

        Label.printEntryLanguage();
        switch (Input.intScanner()){
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

        switch (Input.intScanner()){
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
        book.setNumberOfPages(Input.intScanner());

        //Setting availability to true because every first time added book is not rented yet
        book.setAvailability(true);

        nameOfLibrary.addArt(book);

    }

    private static void addEBook(LibraryManager nameOfLibrary) {

        EBook eBook = new EBook();

        Label.printEntryTitle();
        eBook.setTitle(Input.StringScanner());

        Label.printEntryAuthor();
        eBook.setAuthor(Input.StringScanner());

        Label.printEntryPublicationYear();
        eBook.setYearPublished(Input.intScanner());

        Label.printEntryLanguage();
        switch (Input.intScanner()){
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
        eBook.setFileSize(Input.intScanner());

        //Setting availability to true because every first time added book is not rented yet
        eBook.setAvailability(true);

        nameOfLibrary.addArt(eBook);

    }

    private static void addAudioBook(LibraryManager nameOfLibrary) {

        AudioBook audioBook = new AudioBook();

        Label.printEntryTitle();
        audioBook.setTitle(Input.StringScanner());

        Label.printEntryAuthor();
        audioBook.setAuthor(Input.StringScanner());

        Label.printEntryPublicationYear();
        audioBook.setYearPublished(Input.intScanner());

        Label.printEntryLanguage();
        switch (Input.intScanner()){
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
        audioBook.setDuration(Input.intScanner());

        //Setting availability to true because every first time added book is not rented yet
        audioBook.setAvailability(true);

        nameOfLibrary.addArt(audioBook);

    }

    public static void recordsFillerTMP(LibraryManager nameOfLibrary) {
        LiteraryArt ogniemIMieczem = new Book("Ogniem i Mieczem","Henryk Sienkiewicz",1884, LiteraryArt.Language.POLISH, Book.CoverType.HARD,588);
        LiteraryArt stonesForTheRampart = new Book("Stones for the Rampart","\tAleksander Kamiński",1943, LiteraryArt.Language.ENGLISH, Book.CoverType.SOFT,256);
        LiteraryArt javaPodstawyhorstmann = new Book("Java Podstawy Horstmann","Cay'a Horstmanna",1995, LiteraryArt.Language.POLISH, Book.CoverType.HARD,785);
        LiteraryArt panTadeusz = new EBook("Pan Tadeusz","Adam Mickiewicz",1834, LiteraryArt.Language.POLISH,true,48);
        nameOfLibrary.addArt(ogniemIMieczem);
        nameOfLibrary.addArt(stonesForTheRampart);
        nameOfLibrary.addArt(javaPodstawyhorstmann);
        nameOfLibrary.addArt(panTadeusz);
    }

    public static void opimalizeRecords(LibraryManager nameOfLibrary) {

    }

}