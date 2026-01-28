package libraryv2;

public class PhysicalBook implements Book {
    private String title, author, category;

    public PhysicalBook(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
}
