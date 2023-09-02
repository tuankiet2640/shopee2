package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Product {
    private int productId;
    private String productName;
    private  long price;
    private List<Variant> variants = new ArrayList<>();



    public String getProductName() {
        return productName;
    }

    public long getPrice() {
        return price;
    }

    public Product() {
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public Product(int productId, String productName, long price) {
        this.productId= productId;
        this.productName=productName;                     
        this.price=price;
    }

    public Product(long price) {
        this.price = price;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", variants= "+ variants +
                '}';
    }
}
