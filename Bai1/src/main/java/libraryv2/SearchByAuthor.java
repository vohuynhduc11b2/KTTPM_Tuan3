package libraryv2;

import java.util.List;

public class SearchByAuthor implements SearchStrategy {
    public List<Book> search(List<Book> books, String keyword) {
        return books.stream()
                .filter(b -> b.getAuthor().contains(keyword))
                .toList();
    }
}
