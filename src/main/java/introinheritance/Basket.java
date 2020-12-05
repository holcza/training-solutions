package introinheritance;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items = new ArrayList<>();


    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(String barcode){
        for (int i = 0; i < items.size();i++){
            if (items.get(i).getBarcode().equals(barcode)){
                items.remove(i);
            }
        }
    }

    public void clearBasket(){
        items.clear();
    }

    public List<Item> getItems(){
        List<Item> itemsCopy = new ArrayList<>();
        itemsCopy = items;
        return itemsCopy;
    }
}
