package service;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Order;
import entities.OrderLine;

public class CartService {
    private final static List<Product> products = ProductService.getList();
    private static final Scanner scanner = new Scanner(System.in);
    private static  List<CartItem> cartItems= new ArrayList<>();

    private static int cartId= 4200;
    private static int orderId=2400;

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
        return sum;
    }

    //order
    public static void order(Customer customer){

        int orderId=orderIdSetter();
        long total = customer.getCart().getTotalPrice()+30;
        Cart cart = customer.getCart();
        List<CartItem> cartItems= cart.getCartItems();

        List<OrderLine> orderLines= new ArrayList<>();

        for (CartItem cartItem: cartItems){
            OrderLine orderLine= new OrderLine(cartItem.getProduct(), cartItem.getQuantity(), cartItem.getVariantId());
            orderLines.add(orderLine);
        }
        Order order = new Order(customer.getAddress(),orderLines, total,customer.getUserId(),orderId);

        System.out.println("order cua ban la: "+ order);
        System.out.println("chốt đơn? Y?");
        char isFinished='Y';
        isFinished=scanner.next().charAt(0);
            scanner.nextLine();
        switch (isFinished){
            case 'Y':
                orderDone(customer);
                break;
            case'N':
                CustomerService.menu(customer);
                break;
            default:
                System.out.println("nhap khong hop le ");
                break;
        }
    }
    private static void orderDone(Customer customer){
        Cart cart = new Cart(customer.getCart().getCartId(), new ArrayList<>(),0);
        customer.setCart(cart);
        CustomerService.menu(customer);
    }
    private static int orderIdSetter(){
        return orderId++;
    }

}
