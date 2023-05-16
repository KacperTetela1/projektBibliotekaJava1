public class Book {
    private String title;
    private String author;
    private int publicationDate;
    private boolean availability;
    public void rent(){
        this.availability = false;
    }
    public void rentReturn(){
        this.availability = true;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ", availability=" + availability +
                '}';
    }
}
