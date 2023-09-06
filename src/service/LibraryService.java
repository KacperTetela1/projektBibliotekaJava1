package service;

import model.Book;
import model.EBook;
import model.libraryItemPatern;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private int integerCounter;

    private Map<Integer, libraryItemPatern> libraryMap;

    public LibraryService() {
        libraryMap = new HashMap<>();

        libraryMap = deserialization();
        if (libraryMap.isEmpty())
            fillMapTMP();

        integerCounter = libraryMap.size();

    }

    private void fillMapTMP() {
        libraryItemPatern ogniemIMieczem = new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1884, libraryItemPatern.Language.POLISH, Book.CoverType.HARD, 588);
        libraryItemPatern stonesForTheRampart = new Book("Stones for the Rampart", "\tAleksander Kamiński", 1943, libraryItemPatern.Language.ENGLISH, Book.CoverType.SOFT, 256);
        libraryItemPatern javaPodstawyhorstmann = new Book("Java Podstawy Horstmann", "Cay'a Horstmanna", 1995, libraryItemPatern.Language.POLISH, Book.CoverType.HARD, 785);
        libraryItemPatern panTadeusz = new EBook("Pan Tadeusz", "Adam Mickiewicz", 1834, libraryItemPatern.Language.POLISH, true, 48);
        addItem(ogniemIMieczem);
        addItem(stonesForTheRampart);
        addItem(javaPodstawyhorstmann);
        addItem(panTadeusz);
    }

    public String addItem(libraryItemPatern libraryItemPatern) {
        libraryMap.put(integerCounter++, libraryItemPatern);
        return "The art '" + libraryItemPatern.getTitle() + "' has been added to the library";
    }

    public String deleteItem(int keyValue) {
        if (libraryMap.containsKey(keyValue)) {
            libraryMap.remove(keyValue);
            return "The art has been deleted";
        } else {
            throw new RuntimeException("The art is not exist");
        }

    }

    public String[] printAllItems() {
        String arr[] = new String[libraryMap.size()];

        int incrementValue = 0;
        for (Integer key : libraryMap.keySet()) {
            libraryItemPatern value = libraryMap.get(key);

            arr[incrementValue] = "Key: " + key + ", Value: " + value;
            incrementValue++;
        }
        return arr;

    }

    public String rentAnItem(int keyValue) {
        if (libraryMap.get(keyValue).isAvailability()) {
            libraryMap.get(keyValue).setAvailability(false);
            return "The art '" + libraryMap.get(keyValue).getTitle() + "' has been rented";
        } else
            throw new RuntimeException("The art '" + libraryMap.get(keyValue).getTitle() + "' has not been rented due to no availability");
    }

    public String returnAnItem(int keyValue) {
        if (!libraryMap.get(keyValue).isAvailability()) {
            libraryMap.get(keyValue).setAvailability(true);
            return "The art '" + libraryMap.get(keyValue).getTitle() + "' has been returned";
        } else {
            throw new RuntimeException("The art '" + libraryMap.get(keyValue).getTitle() + "' has never been rented");
        }

    }

    public void defragOfMap() {
        //TODO
    }

    public void serialization() {

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("hashmap.ser"));
            outputStream.writeObject(libraryMap);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HashMap deserialization() {

        HashMap<String, Integer> deserializedMap = new HashMap<>();

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("hashmap.ser"));
            deserializedMap = (HashMap<String, Integer>) inputStream.readObject();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            //System.out.println("Problem z plikiem zapisu");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserializedMap;

    }

}
