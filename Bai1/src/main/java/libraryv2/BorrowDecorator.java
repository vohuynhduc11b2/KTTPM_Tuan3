package libraryv2;

public abstract class BorrowDecorator implements BorrowService {
    protected BorrowService borrowService;

    public BorrowDecorator(BorrowService borrowService) {
        this.borrowService = borrowService;
    }
}
