package model;

import java.io.Serializable;

public abstract class LibraryItemPatern implements Serializable { //patern niepotrzebne slowo w nazwie klasy
    private String title;
    private String author;
    private int yearPublished;
    private boolean availability;
    private Language language;

    public enum Language {
        POLISH,
        ENGLISH,
        GERMAN,
    }

    public LibraryItemPatern() {
    }

    public LibraryItemPatern(String title, String author, int yearPublished, Language language) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        availability = true;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Objects.LibraryItemPatern{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", availability=" + availability +
                ", language=" + language +
                '}';
    }

}
