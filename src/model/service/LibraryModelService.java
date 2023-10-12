package model.service;

import model.model.AudioBook;
import model.model.Book;
import model.model.EBook;
import model.model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryModelService {
    private static List<Item> libraryMap; // !!! PO DODANIU TUTAJ STATIC PROBLEM Z SERILIAZACJA ZOSTAL NAPRAWIONY, NIE ROZUMIEM DLACZEGO ALE BARDZO SIE CIESZE

    public LibraryModelService() {

        libraryMap = new ArrayList<>();
        //System.out.println(libraryMap.size());
        libraryMap = deserialization();
        //System.out.println(libraryMap.size());

        if (libraryMap.isEmpty())
            fillMapTemp();

    }

    private void fillMapTemp() {
        Item ogniemIMieczem = new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1884, Item.Language.POLISH, Book.CoverType.HARD, 588);
        Item stonesForTheRampart = new Book("Stones for the Rampart", "Aleksander Kamiński", 1943, Item.Language.ENGLISH, Book.CoverType.SOFT, 244);
        Item javaPodstawyhorstmann = new Book("Java Podstawy Horstmann", "Cay'a Horstmanna", 2008, Item.Language.POLISH, Book.CoverType.HARD, 768);
        Item panTadeusz = new EBook("Pan Tadeusz", "Adam Mickiewicz", 1834, Item.Language.POLISH, true, 11);
        Item pelnaMożliwości = new AudioBook("Pełna MOC możliwości","Jacek Walkiewicz",2014, Item.Language.POLISH,21600);

        addItem(ogniemIMieczem);
        addItem(stonesForTheRampart);
        addItem(javaPodstawyhorstmann);
        addItem(panTadeusz);
        addItem(pelnaMożliwości);
    }

    public void addItem(Item item) {

        System.out.println(item);
        libraryMap.add(item);

    }

    public String deleteItem(int keyValue) {

        if (libraryMap.contains(keyValue)) {
            libraryMap.remove(keyValue);
            return "The art has been deleted";
        } else {
            throw new RuntimeException("The art is not exist");
        }

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

    public void serialization() {

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("hashmap.ser"));
            outputStream.writeObject(libraryMap);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Item> deserialization() {

        List<Item> deserializedMap = new ArrayList<>();

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("hashmap.ser"));
            deserializedMap = (List<Item>) inputStream.readObject();
            inputStream.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Problem z odczytem pliku zapisu");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserializedMap;

    }

    public List<Item> getLibraryMap() {

        return libraryMap;

    }

    public List<Item> getLibraryMap(boolean available) {

        List<Item> availableList = new ArrayList<>();

        for (Item item : getLibraryMap()) {
            if (available && item.isAvailability()) {
                availableList.add(item);
            } else if (available && !item.isAvailability()){
                availableList.add(item);
            }
        }

        return availableList;

    }


}
