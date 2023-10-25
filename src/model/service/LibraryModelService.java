package model.service;

import model.model.AudioBook;
import model.model.Book;
import model.model.EBook;
import model.model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryModelService {
    private List<Item> libraryMap;


    //w programowaniu obiektowy przez static trcimy kontrolę gdzie które narzedzia mamy dostepne
            //- (diargamy uml, warstwy aplikacji, separacja modulow)
    //uniemozliwia nam korzystanie z narzedzi obiektowych (interfejsy, polimorfizm, dziedziczeni,a abstrakcja, wzorce projketowe)
            //w klasach serwisów (te ktorych potrzebujesz jeden)

    //roznica miedzy polami a zmiennymi kokalnymi polega na tym że pola dostaja domyslna wartość a zmienne lokalne nie

    public LibraryModelService() {
        System.out.println("create library model");
        libraryMap = new ArrayList<>();
        //System.out.println(libraryMap.size());
        libraryMap = deserialization();
        //System.out.println(libraryMap.size());

        if (libraryMap.isEmpty())
            fillMapTemp();

    }

    private  int libraryIdCounter() {
        int maxVal;

        if (libraryMap.isEmpty()) {
            maxVal = 0;
        } else {
            maxVal = libraryMap.stream().map(Item::getId).max(Integer::compare).get()+1;
        }
        return maxVal;
    }

    private void fillMapTemp() {
        Item ogniemIMieczem = new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1884, Item.Language.POLISH, Book.CoverType.HARD, 588,false);
        Item stonesForTheRampart = new Book("Stones for the Rampart", "Aleksander Kamiński", 1943, Item.Language.ENGLISH, Book.CoverType.SOFT, 244,false);
        Item javaPodstawyhorstmann = new Book("Java Podstawy Horstmann", "Cay'a Horstmanna", 2008, Item.Language.POLISH, Book.CoverType.HARD, 768,true);
        Item panTadeusz = new EBook("Pan Tadeusz", "Adam Mickiewicz", 1834, Item.Language.POLISH, true, 11,false);
        Item pelnaMozliwosci = new AudioBook("Pełna MOC możliwości","Jacek Walkiewicz",2014, Item.Language.POLISH,21600,true);

        addItem(ogniemIMieczem);
        addItem(stonesForTheRampart);
        addItem(javaPodstawyhorstmann);
        addItem(panTadeusz);
        addItem(pelnaMozliwosci);
    }

    public void addItem(Item item) {

        item.setId(libraryIdCounter());

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
            } else if (!available && !item.isAvailability()) {
                availableList.add(item);
            }
        }

        System.out.println(availableList.size());
        return availableList;
    }


}
