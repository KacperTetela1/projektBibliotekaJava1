import java.util.ArrayList;

public class Library {
    private ArrayList<LiteraryArt> literaryArts;
    public Library() {
        literaryArts = new ArrayList<>();
    }
    public void addArt(LiteraryArt literaryArt){
        literaryArts.add(literaryArt);
    }
    public void deleteArt(LiteraryArt literaryArt){
        literaryArt = null;
    }
    public void printAllArts() {
        int tmpVal = 1;
        for (LiteraryArt literaryArt : literaryArts) {
            System.out.print("Index: " + tmpVal + " ");
            System.out.println(literaryArt.toString());
        }
    }
    public void rentAnArt(LiteraryArt literaryArt){
        if (literaryArt.isAvailability() == true){
            literaryArt.setAvailability(false);
            System.out.println("The art '" + literaryArt.getTitle() + "' has been rented");
        }
        else{
            System.out.println("The art '" + literaryArt.getTitle() + "' has NOT been rented due to no availability");
        }
    }

}
