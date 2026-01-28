package Observer_Design_Pattern;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        Investor a = new StockInvestor("Alice");
        Investor b = new StockInvestor("Bob");

        stock.attach(a);
        stock.attach(b);

        stock.setPrice(120.5);
        stock.setPrice(130.0);
    }
}
