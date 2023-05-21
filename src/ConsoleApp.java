import java.util.Scanner;

public class ConsoleApp {
    private Library library;
    private Scanner scanner;

    public ConsoleApp() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void run() {
        Library szkolna = new Library();
        System.out.println("Welcome to the library!");

        boolean running = true;
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Add a e-book");
            System.out.println("3. Add a audio-book");
            System.out.println("4. Delete a book");
            System.out.println("5. Display book list");
            System.out.println("6. Borrow a book");
            System.out.println("7. Return a book");
            System.out.println("0. Exit the library");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
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

                    szkolna.addArt(book);
                    break;
                case 2:
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

                    szkolna.addArt(eBook);
                    break;
                case 3:
                    AudioBook audioBook = new AudioBook();










                    break;
                case 4:
                    //Delete a book();
                    break;
                case 5:
                    //display book list();
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

        System.out.println("Thank you for using the library. Goodbye!");
        szkolna.printAllArts();
    }
}