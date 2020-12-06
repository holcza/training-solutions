package week06d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(String name, int quantity) {
        int index = findByName(name);
        if (index == -1) {
            items.add(new Item(name, quantity));
        } else {
            items.get(index).addQuantity(quantity);
        }
    }

    private int findByName(String name) {

        for (int i = 0;i<items.size();i++) {
            if (items.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int getItem (String name){
        int index = findByName(name);
        if (index == -1) {
            return 0;
        } else {

            return items.get(findByName(name)).getQuantity();
        }
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("szék",1);
        shoppingCart.addItem("szék",1);
        System.out.println(shoppingCart.getItem("szék"));
    }


}
