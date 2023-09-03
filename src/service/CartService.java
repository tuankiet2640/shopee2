package service;
import entities.Product;
import entities.CartItem;
import entities.Cart;
import entities.User;
import entities.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartService {
    private final static List<Product> products = ProductService.getList();
    private static final Scanner scanner = new Scanner(System.in);
    private static  List<CartItem> cartItems= new ArrayList<>();

    private static int cartId= 4200;

    public static int addingCartId(){
        return cartId++;
    }
    public static void displayCart(Customer customer){

        Cart cart = customer.getCart();
        List<CartItem> cartItems= Cart.getCartItems();
        for (CartItem cartitem : cartItems){
            System.out.println(cartitem);
        }
        System.out.println("tong tien la "+ getTotalPriceForCart(cart.getCartItems()));
    }
    public static long getTotalPriceForCart(List<CartItem> cartItems){
        long sum=0L;
        for (CartItem cartitem : cartItems){
            sum+= cartitem.getSubtotal();
        }
        return + sum;
    }

}
