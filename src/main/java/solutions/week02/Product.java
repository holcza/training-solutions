package solutions.week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product product) {
        boolean nameEqual = name.equals(product.getName());
        boolean codeCompare = (code.length() - product.getCode().length()) <= 1 || (code.length() - product.getCode().length()) >= -1;
        return nameEqual && codeCompare;
    }

    public static void main(String[] args) {
        Product product1= new Product("kkk","aaaaaaa");
        Product product2= new Product("kkk","aaaaaa");
        Product product3= new Product("aaa","aaaaaaa");
        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));
    }
}
