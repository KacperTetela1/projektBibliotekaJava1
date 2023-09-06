import objects.Book;
import objects.EBook;
import objects.LiteraryArt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LibraryManager implements Serializable {
    private int integerCounter = 1;

    private Map<Integer, LiteraryArt> LibraryMap;

    protected LibraryManager() {
        LibraryMap = new HashMap<>();
        fillMapTMP();
    }

    private void fillMapTMP() {
        LiteraryArt ogniemIMieczem = new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1884, LiteraryArt.Language.POLISH, Book.CoverType.HARD, 588);
        LiteraryArt stonesForTheRampart = new Book("Stones for the Rampart", "\tAleksander Kamiński", 1943, LiteraryArt.Language.ENGLISH, Book.CoverType.SOFT, 256);
        LiteraryArt javaPodstawyhorstmann = new Book("Java Podstawy Horstmann", "Cay'a Horstmanna", 1995, LiteraryArt.Language.POLISH, Book.CoverType.HARD, 785);
        LiteraryArt panTadeusz = new EBook("Pan Tadeusz", "Adam Mickiewicz", 1834, LiteraryArt.Language.POLISH, true, 48);
        addArt(ogniemIMieczem);
        addArt(stonesForTheRampart);
        addArt(javaPodstawyhorstmann);
        addArt(panTadeusz);
    }

    protected String addArt(LiteraryArt literaryArt) {
        LibraryMap.put(integerCounter++, literaryArt);
        return "The art '" + literaryArt.getTitle() + "' has been added to the library";
    }

    protected String deleteArt(int keyValue) {
        if (LibraryMap.containsKey(keyValue)) {
            LibraryMap.remove(keyValue);
            return "The art has been deleted";
        } else {
            throw new RuntimeException("The art is not exist");
        }

    }

    protected String[] printAllArts() {
        String arr[] = new String[LibraryMap.size()];

        int incrementValue = 0;
        for (Integer key : LibraryMap.keySet()) {
            LiteraryArt value = LibraryMap.get(key);

            arr[incrementValue] = "Key: " + key + ", Value: " + value;
            incrementValue++;
        }
        return arr;

    }

    protected String rentAnArt(int keyValue) {
        if (LibraryMap.get(keyValue).isAvailability()) {
            LibraryMap.get(keyValue).setAvailability(false);
            return "The art '" + LibraryMap.get(keyValue).getTitle() + "' has been rented";
        } else
            throw new RuntimeException("The art '" + LibraryMap.get(keyValue).getTitle() + "' has not been rented due to no availability");
    }

    protected String returnAnArt(int keyValue) {
        if (!LibraryMap.get(keyValue).isAvailability()) {
            LibraryMap.get(keyValue).setAvailability(true);
            return "The art '" + LibraryMap.get(keyValue).getTitle() + "' has been returned";
        } else {
            throw new RuntimeException("The art '" + LibraryMap.get(keyValue).getTitle() + "' has never been rented");
        }

    }

    protected void defragOfMap() {
        //TODO
    }

    protected void serial() {

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("hashmap.ser"));
            outputStream.writeObject(LibraryMap);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected HashMap deserial() {

        HashMap<String, Integer> deserializedMap = null;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("hashmap.ser"));
            deserializedMap = (HashMap<String, Integer>) inputStream.readObject();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserializedMap;

    }

}
