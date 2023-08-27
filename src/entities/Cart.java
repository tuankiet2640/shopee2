package entities;

import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static final List<CartItem> cartitems = new ArrayList<>();
    private long totalPrice;
    CartItem cartItem = new CartItem();

    public CartItem getCartItem() {
        return cartItem;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                cartItem +
                "totalPrice=" + totalPrice +
                '}';
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}

