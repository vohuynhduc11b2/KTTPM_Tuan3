package libraryv2;

public class EBookFactory extends BookFactory {
    @Override
    public Book createBook(String title, String author, String category) {
        return new EBook(title, author, category);
    }
}
