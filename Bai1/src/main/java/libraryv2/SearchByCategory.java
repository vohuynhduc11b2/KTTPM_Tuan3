package libraryv2;

import java.util.List;

public class SearchByCategory implements SearchStrategy {
    public List<Book> search(List<Book> books, String keyword) {
        return books.stream()
                .filter(b -> b.getCategory().contains(keyword))
                .toList();
    }
}
