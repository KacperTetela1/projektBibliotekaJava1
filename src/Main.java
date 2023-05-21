public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Book ogniemIMieczem = new Book("Ogniem i Mieczem","Henryk Sienkiewicz",1884, LiteraryArt.Language.POLISH, Book.CoverType.HARD,588);
        System.out.println(ogniemIMieczem);
    }
}