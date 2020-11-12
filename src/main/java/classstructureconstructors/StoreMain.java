package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store1 =new Store("szék");
        Store store2 =new Store("asztal");
        store1.store(3);
        store2.dispatch(5);
        System.out.println(store1.getProduct()+" : "+store1.getStock()+" , "+store2.getProduct()+" : "+store2.getStock());

    }
}
