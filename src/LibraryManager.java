import objects.LiteraryArt;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


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

    protected void rentAnArt(int keyValue) {
        if (LibraryMap.get(keyValue).isAvailability() == true){
            LibraryMap.get(keyValue).setAvailability(false);
            System.out.println("The art '" + LibraryMap.get(keyValue).getTitle() + "' has been rented");
        }
        else
            System.out.println("The art '" + LibraryMap.get(keyValue).getTitle() + "' has not been rented due to no availability");

    }

    protected void returnAnArt(int keyValue) {
                if (LibraryMap.get(keyValue).isAvailability() == false){
            LibraryMap.get(keyValue).setAvailability(true);
            System.out.println("The art '" + LibraryMap.get(keyValue).getTitle() + "' has been returned");
        }
        else {
            System.out.println("The art '" + LibraryMap.get(keyValue).getTitle() + "' has never been rented");
        }

    }

    protected void defragOfMap() {

    }

    protected void listSorter(Map<Integer, String> map) {
        Map<Integer, String> tmpMap = new TreeMap<>();
        int incrementValue = 1;
        for (String value : map.values())
            tmpMap.put(incrementValue++, value);

        map.clear();
        map.putAll(tmpMap);
    }

}
