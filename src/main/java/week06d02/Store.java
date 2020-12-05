package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();


    public Store(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getProductByCategory(Category category) {
        int count = 0;
        for (Product p : products) {
            if (p.getCategory() == category) {
                count++;
            }
        }
        return count;
    }

    public List<CountByCategory> getCountProductByCategories() {
        List<CountByCategory> countByCategories = new ArrayList<>();
        for (Category category : Category.values()) {
            countByCategories.add(new CountByCategory(category, getProductByCategory(category)));

        }
        return countByCategories;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("szék",Category.OTHER,10000));
        products.add(new Product("kalács",Category.BAKEDGOODS,100));
        products.add(new Product("jégkérm",Category.FROZEN,1000));
        products.add(new Product("asztal",Category.OTHER,100000));
        Store store = new Store(products);
        List<CountByCategory> countByCategories = store.getCountProductByCategories();
        System.out.println(countByCategories.size());
        System.out.println(countByCategories.get(0).getCategory());
        System.out.println(countByCategories.get(1).getCategory());
        System.out.println(countByCategories.get(2).getCategory());
        System.out.println(countByCategories.get(3).getCategory());
        System.out.println(countByCategories.get(0).getCount());
        System.out.println(countByCategories.get(1).getCount());
        System.out.println(countByCategories.get(2).getCount());
        System.out.println(countByCategories.get(3).getCount());
    }
}
