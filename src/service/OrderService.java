package service;

import entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService implements Serializable {
    private static int orderId=2400;
    private static final Scanner scanner = new Scanner(System.in);
    private static final File ORDER_FILE= new File("src/files/order.txt");

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
                printOrder(order);
                orderDone(customer);
                break;
            case'N':
                CustomerService.mainMenu(customer);
                break;
            default:
                System.out.println("nhap khong hop le ");
                break;
        }
    }

    private static void printOrder(Order order) {
        try {
            FileWriter fileWriter= new FileWriter(ORDER_FILE);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(order.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void orderDone(Customer customer){
        Cart cart = new Cart(customer.getCart().getCartId(), new ArrayList<>(),0);
        customer.setCart(cart);
        CustomerService.mainMenu(customer);

    }
    private static int orderIdSetter(){
        return orderId++;
    }

}

