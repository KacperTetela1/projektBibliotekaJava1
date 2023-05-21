public abstract class LiteraryArt {
    private String title;
    private String author;
    private int yearPublished;
    private boolean availability;
    private Language language;
    public enum Language {
        ENGLISH,
        POLISH,
        FRENCH,
        GERMAN,
        SPANISH,
    }
}
