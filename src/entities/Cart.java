package entities;

import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static  List<CartItem> cartitems = new ArrayList<>();
    private int cartId;
    private long totalPrice;

    public static List<CartItem> getCart() {
        return cartitems;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                cartitems +
                "totalPrice=" + totalPrice +
                '}';
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public static List<CartItem> getCartitems() {
        return cartitems;
    }

    public static void setCartitems(List<CartItem> cartitems) {
        Cart.cartitems = cartitems;
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

