package entities;

import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final List<CartItem> cartitems = new ArrayList<>();

    private long totalPrice;


    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalPrice=" + totalPrice +
                '}';
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}

