package service;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final static List<Customer> customers = new ArrayList<>();
    private final static List<Product> products = ProductService.getList();
    private static final List<CartItem> cart= Cart.getCart();
    private static final Scanner scanner= new Scanner(System.in);


    public static void register(){
        int customerId= 1999;
        String username= "kiet";
        String password= "123456";
        long balance = 100000;
        Customer customer = new Customer(customerId,username,password,balance);
        customers.add(customer);
    }

    public static void displayPage(){

        char displayPage='Y';
        while (displayPage=='Y') {

            System.out.println("nhap so trang= ");
            int pageNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("nhap size cua trang");
            int pageSize = scanner.nextInt();
            scanner.nextLine();


            int indexStart;
            int indexEnd;

            indexStart = (pageNumber - 1) * pageSize;
            indexEnd = indexStart + pageSize;

            if (indexStart > products.size() - 1) {
                System.out.println("nhap khong hop le");
            }
            if (indexStart < products.size()) {
                if (indexEnd > products.size()) {
                    indexEnd = products.size();
                }
                for (int index = indexStart; index < indexEnd; index++) {
                    System.out.println(products.get(index));
                }
            }

            System.out.println("ban co xem tiep? Y/N");
            displayPage=scanner.next().charAt(0);
            scanner.nextLine();
        }
    }

    public static void addToCart(){

            System.out.println("nhap san pham can them vao gio hang ");
            String productName = scanner.nextLine();

        System.out.println("san pham nay bao gom cac size va mau sau:");
        ProductService.displayVariant(productName);

       System.out.println("chọn một size: ");
       String size= scanner.nextLine();

        System.out.println("chọn một màu: ");
        String color= scanner.nextLine();

        Variant variant = ProductService.findVariant(productName, size,color);

        System.out.println("nhap so luong ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            CartItem cartitem = new CartItem(productName,variant, quantity);
            cart.add(cartitem);

    }



}
