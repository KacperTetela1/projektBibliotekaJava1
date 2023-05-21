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
}
