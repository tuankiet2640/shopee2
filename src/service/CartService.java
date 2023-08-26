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

    private static final List<CartItem> cartitems = new ArrayList<>();

    private final Customer customer = new Customer();
    private static final Scanner scanner = new Scanner(System.in);


    public static void addToCart(){
        String addingToCart="Y";
        while (addingToCart=="Y") {
            System.out.println("nhap san pham can them vao gio hang ");
            String productName = scanner.nextLine();

            System.out.println("nhap so luong ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            CartItem cartitem = new CartItem(productName, quantity);

            System.out.println("ban co them tiep san pham? Y/N");
            addingToCart=scanner.nextLine();
        }
    }
    public static long getTotalPrice(){
        long sum=0L;
        for (CartItem cartitem : cartitems){
            sum+= cartitem.getSubtotal();
        }

        return sum;
    }

}
