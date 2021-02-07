package week13d05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BillWriter {

    public String writeBills(List<BillItem> billItems, Function<BillItem, String> fn) {
        StringBuilder sb = new StringBuilder();

        for (BillItem b : billItems) {
            sb.append(fn.apply(b) + "\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BillWriter bw = new BillWriter();
        List<BillItem> billItems = new ArrayList<>();
        billItems.add(new BillItem("kenyér", 3, 10));
        billItems.add(new BillItem("tej", 5, 20));
        System.out.println(bw.writeBills(billItems, item ->
                String.format("%d %s, darabja %d Ft", item.getNumber(), item.getName(), item.getUnitPrice())));
        System.out.println(bw.writeBills(billItems, item ->
                String.format("%s %d * %d = %d", item.getName(), item.getNumber(), item.getUnitPrice(), item.getNumber()*item.getUnitPrice())));
    }
}
