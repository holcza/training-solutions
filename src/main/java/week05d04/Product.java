package week05d04;

public class Product {
    private long price;
    private String currency;

    public Product(long price, String currency) {
        this.price = price;
        this.currency = currency;
        isValidCurrency(currency);

    }

    public void isValidCurrency(String currency) {
        if (!("HUF".equals(currency) || "USD".equals(currency))) {
            throw new IllegalArgumentException("Currency can be only HUF or USD");
        }


    }

    public double convertPrice(String currency) {
        isValidCurrency(currency);
        if (currency.equals("USD") && this.currency.equals("HUF")) {
            return price / 300;
        } else if (currency.equals("HUF") && this.currency.equals("USD")) {
            return price * 300;
        }
        return price;
    }


}
