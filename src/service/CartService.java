package service;
import entities.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import entities.Order;
import entities.OrderLine;

public class CartService implements Serializable {
    private static int cartId = 4200;

    public static int addingCartId() {
        return cartId++;
    }

    public static void displayCart(Customer customer) {

        Cart cart = customer.getCart();
        List<CartItem> cartItems = Cart.getCartItems();

        for (CartItem cartitem : cartItems) {
            System.out.println(cartitem);
        }
        System.out.println("tong tien la " + getTotalPriceForCart(cart.getCartItems()));
    }

    public static long getTotalPriceForCart(List<CartItem> cartItems) {
        long sum = 0L;
        for (CartItem cartitem : cartItems) {
            sum += cartitem.getSubtotal();
        }
        return sum;
    }

    //adding price to variant
    public static long addingPriceToVariant(Product product, int variantId) {
        Variant variant = ProductService.findVariantByVariantId(product, variantId);
        if (variant != null) {
            long variantPrice = variant.getVariantPrice() + product.getPrice();
            return variantPrice;
        }
        return product.getPrice();
    }
}

