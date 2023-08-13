package objects;

public class Book extends LiteraryArt{
    private CoverType coverType;
    private int numberOfPages;
    public enum CoverType {
        HARD,
        SOFT,
    }

    public Book(){}
    public Book(String title, String author, int yearPublished, Language language, CoverType coverType, int numberOfPages) {
        super(title, author, yearPublished, language);
        this.coverType = coverType;
        this.numberOfPages = numberOfPages;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Objects.Book{" +
                "coverType=" + coverType +
                ", numberOfPages=" + numberOfPages +
                "} " + super.toString();
    }
}
