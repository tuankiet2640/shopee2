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

    private static final List<CartItem> cart = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void addToCart(){
        char addingToCart='Y';
        while (addingToCart=='Y') {
            System.out.println("nhap san pham can them vao gio hang ");
            String productName = scanner.nextLine();

            System.out.println("nhap so luong ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            CartItem cartitem = new CartItem(productName, quantity);
            cart.add(cartitem);

            System.out.println("ban co them tiep san pham? Y/N");
            addingToCart=scanner.next().charAt(0);
            scanner.nextLine();
        }
    }
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
