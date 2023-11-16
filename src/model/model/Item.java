package model.model;

import model.service.LibraryModelService;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private int id;
    private String title;
    private String author;
    private int yearPublished;
    private boolean availability;
    private Language language;

    public Item() {
    }

    public Item(String title, String author, int yearPublished, Language language, boolean availability) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.language = language;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Objects.Item{" +
                "id=" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", availability=" + availability +
                ", language=" + language +
                '}';
    }


    public enum Language {
        POLISH,
        ENGLISH,
        GERMAN,
    }

}
