package introinheritance;

import java.util.ArrayList;

public class ShoppingBasket {

    private Basket basket = new Basket();


    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0;
        for (Item i : basket.getItems()) {
            sum += i.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {
        double sum = 0;
        for (Item i : basket.getItems()) {
            sum += i.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        double mostExpensivePrice = 0;
        String mostExpensiveItem = "";
        for (Item i : basket.getItems()) {
            double totalPrice = i.getNettoPrice() + i.getTaxAmount();
            if (totalPrice > mostExpensivePrice) {
                mostExpensivePrice = totalPrice;
                mostExpensiveItem = i.getBarcode();
            }
        }
        basket.removeItem(mostExpensiveItem);
    }
}
