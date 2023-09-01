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
    private static final List<CartItem> cart = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayCart(){
        for (CartItem cartitem : cart){
            System.out.println(cartitem);
        }
    }
    public static void getTotalPriceForCart(){
        long sum=0L;
        for (CartItem cartitem : cart){
            sum+= cartitem.getSubtotal();
        }
        System.out.println("tong gia cua cart la: " + sum);
    }
}
