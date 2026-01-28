package libraryv2;

public class ExtendTimeDecorator extends BorrowDecorator {
    public ExtendTimeDecorator(BorrowService borrowService) {
        super(borrowService);
    }

    public void borrow() {
        borrowService.borrow();
        System.out.println("→ Gia hạn thời gian mượn");
    }
}
