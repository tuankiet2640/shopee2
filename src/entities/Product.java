package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Product {
    private int productId;
    private String productName;
    private  long price;
    private List<Variant> variants = new ArrayList<>();
    private int variantId;



    public String getProductName() {
        return productName;
    }

    public long getPrice() {
        return price;
    }

    public Product() {
    }

    public Product(int productId,String productName, long price) {
        this.productId= productId;
        this.productName=productName;                     
        this.price=price;
    }

    public Product(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return productName + " " + price;
    }
}
