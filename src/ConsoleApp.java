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
            System.out.println("2. Delete a book");
            System.out.println("3. Display book list");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("0. Exit the library");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    String name = scanner.nextLine();
                    Book book = new Book();
                    book.setAuthor(name);
                    break;
                case 2:
                    //displayBooks();
                    break;
                case 3:
                    //borrowBook();
                    break;
                case 4:
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