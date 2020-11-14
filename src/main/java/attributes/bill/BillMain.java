package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill= new Bill();

        bill.addItem(new Item("termék1",10,120));
        bill.addItem(new Item("termék2",1,10));
        bill.addItem(new Item("termék3",3,1200));
        bill.addItem(new Item("termék4",100,10));

        System.out.println(bill.calculateTotalPrice());
    }
}
