public class AudioBook extends LiteraryArt{
    private int duration;

    public AudioBook(){}
    public AudioBook(String title, String author, int yearPublished, Language language, int duration) {
        super(title, author, yearPublished, language);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "duration=" + duration +
                "} " + super.toString();
    }
}
