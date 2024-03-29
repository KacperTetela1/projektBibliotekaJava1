package model.model;

public class AudioBook extends Item {
    private final int duration;

    public AudioBook(String title, String author, int yearPublished, Language language, int duration, boolean availability) {
        super(title, author, yearPublished, language, availability);
        this.duration = duration;
    }

    public AudioBook(String title, String author, int yearPublished, int duration, boolean availability) {
        super(title, author, yearPublished, Language.POLISH, availability);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Objects.AudioBook{" +
                "duration=" + duration +
                "} " + super.toString();
    }

}
