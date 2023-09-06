package tools;

public class Label {
    public static void printHelloLabel() {

        System.out.println("Welcome to the library!");

    }

    public static void printListOfChoices() {

        System.out.println();
        System.out.println("Select an option:");
        System.out.println("1. Add a book");
        System.out.println("2. Add a e-book");
        System.out.println("3. Add a audio-book");
        System.out.println("4. Delete a book");
        System.out.println("5. Display book list");
        System.out.println("6. Borrow a book");
        System.out.println("7. Return a book");
        System.out.println("0. Exit the library");
        System.out.println();

    }

    public static void printGoodByeLabel() {
        System.out.println();
        System.out.println("Thank you for using the library. Goodbye!");
        System.out.println();
    }

    public static void printEntryTitle() {
        System.out.println("\nPlease enter the title\n");
    }

    public static void printEntryAuthor() {
        System.out.println("\nPlease enter the author\n");
    }

    public static void printEntryPublicationYear() {
        System.out.println("\nPlease enter the year of publication\n");
    }

    public static void printEntryLanguage() {
        System.out.println("\nPlease enter the language of book" +
                "\n1. Polish" +
                "\n2. English" +
                "\n3. German\n");
    }

    public static void printEntryPagesAmount() {
        System.out.println("\nPlease enter the number of pages\n");
    }

}
