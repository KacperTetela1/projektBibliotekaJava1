package model;

public class Book extends LiteraryArt{
    private CoverType coverType;
    private int numberOfPages;

    public enum CoverType {
        HARD,
        SOFT,
    }

    public Book() {
    }

    public Book(String title, String author, int yearPublished, Language language, CoverType coverType, int numberOfPages) {
        super(title, author, yearPublished, language);
        this.coverType = coverType;
        this.numberOfPages = numberOfPages;
    }

    public Book(String title, String author, int yearPublished, int numberOfPages) {
        super(title, author, yearPublished, Language.POLISH);
        this.numberOfPages = numberOfPages;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "Objects.Book{" +
                "coverType=" + coverType +
                ", numberOfPages=" + numberOfPages +
                "} " + super.toString();
    }
}
