package libraryv2;

public class PhysicalBookFactory extends BookFactory {
    @Override
    public Book createBook(String title, String author, String category) {
        return new PhysicalBook(title, author, category);
    }
}
