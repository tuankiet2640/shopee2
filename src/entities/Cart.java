package entities;

import service.ProductService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private static  List<CartItem> cartItems = new ArrayList<>();
    private int cartId ;
    private long totalPrice;

    public Cart(int cartId,List<CartItem> cartItems, long totalPrice) {
        this.cartId = cartId;
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
    }


    public static List<CartItem> getCart() {
        return cartItems;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                cartItems +
                "totalPrice=" + totalPrice +
                '}';
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public static List<CartItem> getCartItems() {
        return cartItems;
    }

    public static void setCartitems(List<CartItem> cartitems) {
        Cart.cartItems = cartitems;
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

