package model;

public class AudioBook extends LibraryItemPatern {
    private int duration;

    public AudioBook() {
    }

    public AudioBook(String title, String author, int yearPublished, Language language, int duration) {
        super(title, author, yearPublished, language);
        this.duration = duration;
    }

    public AudioBook(String title, String author, int yearPublished, int duration) {
        super(title, author, yearPublished, Language.POLISH);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Objects.AudioBook{" +
                "duration=" + duration +
                "} " + super.toString();
    }

}
