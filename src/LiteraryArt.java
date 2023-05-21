public abstract class LiteraryArt {
    private String title;
    private String author;
    private int yearPublished;
    private boolean availability;
    private Language language;
    protected enum Language {
        POLISH,
        ENGLISH,
        GERMAN,
        FRENCH,
        SPANISH,
    }
    public LiteraryArt(){}
    public LiteraryArt(String title, String author, int yearPublished, Language language) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        availability = true;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "LiteraryArt{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", availability=" + availability +
                ", language=" + language +
                '}';
    }
}
