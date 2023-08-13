import objects.LiteraryArt;

import java.util.HashMap;
import java.util.Map;


public class LibraryManager {
    private int integerCounter = 1;

    private Map<Integer,LiteraryArt> LibraryMap;

    protected LibraryManager() {
        LibraryMap = new HashMap<>();
    }

    protected void addArt(LiteraryArt literaryArt) {
        LibraryMap.put(integerCounter++,literaryArt);
        System.out.println("The art '" + literaryArt.getTitle() +  "' has been added to the library");
    }

    protected void deleteArt(int keyValue){
        LibraryMap.remove(keyValue);
    }

    protected void printAllArts() {
        for (Integer key : LibraryMap.keySet()) {
            LiteraryArt value = LibraryMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

    }

    protected void rentAnArt(LiteraryArt literaryArt){
        if (literaryArt.isAvailability() == true){
            literaryArt.setAvailability(false);
            System.out.println("The art '" + literaryArt.getTitle() + "' has been rented");
        }
        else {
            System.out.println("The art '" + literaryArt.getTitle() + "' has NOT been rented due to no availability");
        }

    }

}
