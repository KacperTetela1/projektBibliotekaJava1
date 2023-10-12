package model.model;

public class Book extends Item {
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

    public CoverType getCoverType() {
        return coverType;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Objects.Book{" +
                "coverType=" + coverType +
                ", numberOfPages=" + numberOfPages +
                "} " + super.toString();
    }

}
