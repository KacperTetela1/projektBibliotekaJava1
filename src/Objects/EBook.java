package Objects;

public class EBook extends LiteraryArt{
    private boolean isPDF;
    private int fileSize;

    public EBook() {}
    public EBook(String title, String author, int yearPublished, Language language, boolean isPDF, int fileSize) {
        super(title, author, yearPublished, language);
        this.isPDF = isPDF;
        this.fileSize = fileSize;
    }

    public boolean isPDF() {
        return isPDF;
    }

    public void setPDF(boolean PDF) {
        isPDF = PDF;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
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
