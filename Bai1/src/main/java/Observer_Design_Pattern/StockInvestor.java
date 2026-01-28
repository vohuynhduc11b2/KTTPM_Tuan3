package Observer_Design_Pattern;

public class StockInvestor implements Investor {
    private String name;

    public StockInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " nhận thông báo: Giá cổ phiếu = " + price);
    }
}
