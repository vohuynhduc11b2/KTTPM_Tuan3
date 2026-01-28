package Observer_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Investor> investors = new ArrayList<>();
    private double price;

    public void attach(Investor investor) {
        investors.add(investor);
    }

    public void detach(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    private void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(price);
        }
    }
}
