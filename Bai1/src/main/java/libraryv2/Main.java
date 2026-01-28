package libraryv2;

public class Main {
    public static void main(String[] args) {

        // ===== 1. Singleton: chỉ có 1 Library =====
        Library library = Library.getInstance();
        Library sameLibrary = Library.getInstance();

        System.out.println("Library có phải 1 instance không? "
                + (library == sameLibrary)); // true


        // ===== 2. Observer: đăng ký người nhận thông báo =====
        LibraryNotifier notifier = new LibraryNotifier();

        Observer librarianA = new Librarian("An");
        Observer librarianB = new Librarian("Bình");

        notifier.attach(librarianA);
        notifier.attach(librarianB);


        // ===== 3. Factory Method: tạo nhiều loại sách =====
        BookFactory physicalFactory = new PhysicalBookFactory();
        BookFactory ebookFactory = new EBookFactory();

        Book book1 = physicalFactory.createBook(
                "Clean Code", "Robert C. Martin", "IT");

        Book book2 = physicalFactory.createBook(
                "Design Patterns", "GoF", "IT");

        Book book3 = ebookFactory.createBook(
                "Harry Potter", "J.K. Rowling", "Fantasy");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Thông báo có sách mới
        notifier.notifyObservers("Có sách mới được thêm vào thư viện");


        // ===== 4. Strategy: tìm kiếm theo nhiều cách =====
        SearchContext searchContext = new SearchContext();

        System.out.println("\n--- Tìm theo tên ---");
        searchContext.setStrategy(new SearchByTitle());
        searchContext.executeSearch(library.getBooks(), "Clean")
                .forEach(b -> System.out.println(b.getTitle()));

        System.out.println("\n--- Tìm theo tác giả ---");
        searchContext.setStrategy(new SearchByAuthor());
        searchContext.executeSearch(library.getBooks(), "GoF")
                .forEach(b -> System.out.println(b.getTitle()));

        System.out.println("\n--- Tìm theo thể loại ---");
        searchContext.setStrategy(new SearchByCategory());
        searchContext.executeSearch(library.getBooks(), "IT")
                .forEach(b -> System.out.println(b.getTitle()));


        // ===== 5. Decorator: mượn sách với nhiều tuỳ chọn =====
        System.out.println("\n--- Mượn sách cơ bản ---");
        BorrowService basicBorrow = new BasicBorrow();
        basicBorrow.borrow();

        System.out.println("\n--- Mượn + gia hạn ---");
        BorrowService extendBorrow =
                new ExtendTimeDecorator(new BasicBorrow());
        extendBorrow.borrow();

        System.out.println("\n--- Mượn + gia hạn + bản đặc biệt ---");
        BorrowService fullOptionBorrow =
                new ExtendTimeDecorator(
                        new SpecialEditionDecorator(
                                new BasicBorrow()));
        fullOptionBorrow.borrow();


        // ===== 6. Observer: sách quá hạn =====
        notifier.notifyObservers("Có sách đã quá hạn mượn");
    }
}
