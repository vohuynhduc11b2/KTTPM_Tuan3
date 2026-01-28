package libraryv2;

public class SpecialEditionDecorator extends BorrowDecorator {
    public SpecialEditionDecorator(BorrowService borrowService) {
        super(borrowService);
    }

    public void borrow() {
        borrowService.borrow();
        System.out.println("→ Yêu cầu phiên bản đặc biệt");
    }
}
