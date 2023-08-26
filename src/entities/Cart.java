package entities;

import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Cart extends CartItem {
    private static final List<CartItem> cartItem = new ArrayList<>();

    private long totalPrice;

    public long getTotalPrice() {
        return totalPrice;
    }
}

