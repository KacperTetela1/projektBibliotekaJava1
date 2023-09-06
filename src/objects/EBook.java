package objects;

public class EBook extends LiteraryArt {
    private boolean isPDF;
    private int fileSize;

    public EBook() {
    }

    public EBook(String title, String author, int yearPublished, Language language, boolean isPDF, int fileSize) {
        super(title, author, yearPublished, language);
        this.isPDF = isPDF;
        this.fileSize = fileSize;
    }

    public EBook(String title, String author, int yearPublished, int fileSize) {
        super(title, author, yearPublished, Language.POLISH);
        this.isPDF = isPDF;
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "Objects.EBook{" +
                "isPDF=" + isPDF +
                ", fileSize=" + fileSize +
                "} " + super.toString();
    }
}
