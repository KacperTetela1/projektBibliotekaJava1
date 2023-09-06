import objects.AudioBook;
import objects.Book;
import objects.LiteraryArt;
import tools.Input;
import tools.Label;

public class ConsoleController {
    private LibraryManager libraryManager;

    public ConsoleController(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public void runConsoleMenu() {
        //Tworzenie i wypelnianie jednej biblioteki(naszej bazy danych) w celu symulacji dzialania programu, pozniej mozna zastapic wczytaniem w przypadku serializacji

        //Wyswietla przywitanie
        Label.printHelloLabel();

        //Pyta uzytkownika co chce zrobic
        switchAsker();

        //Wyswietla pozegnalny komunikat
        Label.printGoodByeLabel();

    }

    private void serialization() {
        libraryManager.serial();
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
                    serialization();

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
        System.out.println(libraryManager.addArt(book));

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
        System.out.println(libraryManager.addArt(eBook));

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
        System.out.println(libraryManager.addArt(audioBook));

    }

    private void deleteBook() {
        System.out.println("Select the book you want to delete by Key number");
        libraryManager.printAllArts();

        try {
            int deleteKeyValue = Input.intScanner();
            System.out.println(libraryManager.deleteArt(deleteKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    private void printAllArts() {
        String[] newArray = libraryManager.printAllArts();

        for (int i = 0; i < newArray.length; i++)
            System.out.println(newArray[i]);

    }

    private void borrowBook() {
        System.out.println("Select the art you want to borrow by Key number");
        libraryManager.printAllArts();

        try {
            int borrowKeyValue = Input.intScanner();
            System.out.println(libraryManager.rentAnArt(borrowKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

    private void returnBook() {
        System.out.println("Select the art you want to return by Key number");
        libraryManager.printAllArts();

        try {
            int returnKeyValue = Input.intScanner();
            System.out.println(libraryManager.returnAnArt(returnKeyValue));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

}
