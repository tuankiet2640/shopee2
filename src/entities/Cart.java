package entities;

import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static  List<CartItem> cart = new ArrayList<>();
    private int cartId;
    private long totalPrice;

    public static List<CartItem> getCart() {
        return cart;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                cart +
                "totalPrice=" + totalPrice +
                '}';
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public static List<CartItem> getCartitems() {
        return cart;
    }

    public static void setCartitems(List<CartItem> cartitems) {
        Cart.cart = cartitems;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}

