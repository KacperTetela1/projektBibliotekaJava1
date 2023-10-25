package model.model;

public class EBook extends Item {
    private boolean isPDF;
    private int fileSize;

    public EBook() {
    }

    public EBook(String title, String author, int yearPublished, Language language, boolean isPDF, int fileSize, boolean availability) {
        super(title, author, yearPublished, language, availability);
        this.isPDF = isPDF;
        this.fileSize = fileSize;
    }

    public EBook(String title, String author, int yearPublished, int fileSize, boolean availability) {
        super(title, author, yearPublished, Language.POLISH, availability);
        this.isPDF = isPDF;
        this.fileSize = fileSize;
    }

    public int getFileSize() {
        return fileSize;
    }

    public boolean isPDF() {
        return isPDF;
    }

    @Override
    public String toString() {
        return "Objects.EBook{" +
                "isPDF=" + isPDF +
                ", fileSize=" + fileSize +
                "} " + super.toString();
    }

}
