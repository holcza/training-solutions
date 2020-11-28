package week05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {
    @Test
    public void addProduct(){
        Product product1=new Product("tej",2020,12,30);
        Product product2=new Product("tej",2020,12,29);
        Product product3=new Product("sajt",2020,11,1);
        Product product4=new Product("túró",2019,12,30);

        Store store =new Store();

        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);



        assertEquals(1,store.productList.size());
        assertEquals(0,store.getNumberOfExpired());
    }
}
