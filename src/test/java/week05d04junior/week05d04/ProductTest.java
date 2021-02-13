package week05d04junior.week05d04;

import org.junit.jupiter.api.Test;
import week05d04.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    public void convertPriceTest(){
        Product product =new Product(1,"USD");
        Product product2 =new Product(300,"HUF");
        assertEquals(300,product.convertPrice("HUF"));
        assertEquals(1,product.convertPrice("USD"));
        assertEquals(300,product2.convertPrice("HUF"));
        assertEquals(1,product2.convertPrice("USD"));
    }
    @Test
    public void ProductTest() throws IllegalArgumentException{
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Product(1,"ddd"));
        assertEquals("Currency can be only HUF or USD", ex.getMessage());

    }
}
