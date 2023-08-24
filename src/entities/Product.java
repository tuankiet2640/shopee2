package entities;

import java.util.concurrent.ThreadLocalRandom;

public class Product {
    private String productName;
    private  long price;


    public Product() {
    }

    public Product(String productName, long price) {
        this.productName=productName;
        this.price=price;
    }

    public Product(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return productName+" " + price ;
    }
}
