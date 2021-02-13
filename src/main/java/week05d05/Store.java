package week05d05;

import week05d05.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (!isInList(product.getName()) && !product.isExpired()) {

            productList.add(product);
        }
    }

    public boolean isInList(String name) {
        boolean isInList = false;
        for (Product p : productList) {
            if (name.equals(p.getName())) {
                isInList = true;
            }
        }
        return isInList;
    }

    public int getNumberOfExpired() {
        int count = 0;
        for (Product p : productList) {
            if (p.isExpired()) {
                count++;
            }
        }
        return count;
    }
}
