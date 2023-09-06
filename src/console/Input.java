package console;

import java.util.Scanner;

public class Input {

    private static Scanner importScanner() {
        //pobieranie scannera ktory jest potrzebny metodzie
        return new Scanner(System.in);
    }

    public static int intScanner() {
        Scanner scanner = importScanner();
        return scanner.nextInt();
    }

    public static String StringScanner() {
        Scanner scanner = importScanner();
        return scanner.nextLine();
    }

}
