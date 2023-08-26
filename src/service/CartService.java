package service;
import entities.Product;
import entities.CartItem;
import entities.Cart;
import entities.User;
import entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    private static final List<CartItem> cartItem = new ArrayList<>();

    private final Customer customer = new Customer();


    public static long getTotalPrice(){
        long sum=0L;
        for (CartItem cartitem : cartItem){
            sum+= cartitem.getSubtotal();
        }

        return sum;
    }

}
