package finalmodifier;

public class TaxCalculator {

    public final static double TAX = 0.27;

    public double tax (double price){
        return price*TAX;
    }

    public double priceWithTax (double price){

        return price*TAX + price;
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println(taxCalculator.tax(100));
        System.out.println(taxCalculator.priceWithTax(100));
    }
}
