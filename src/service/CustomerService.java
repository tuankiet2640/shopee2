package service;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final static List<Customer> customers = new ArrayList<>();
    private final static List<Product> products = ProductService.getList();
    private static final Scanner scanner= new Scanner(System.in);
    private static int cusId=78000;

    //dang ky
    public static void register(){
        int customerId= cusId++;

        System.out.println("nhap username can dang ky : ");
        String username=scanner.nextLine();

        System.out.println("nhap mat khau: ");
        String password= scanner.nextLine();

        long balance = 100000;
        Customer customer = new Customer(customerId,username,password,balance);
        customers.add(customer);
    }


    // dang nhap
    public static void login (){
        System.out.println("moi ban nhap username: ");
        String username= scanner.nextLine();

        System.out.println("moi ban nhap password: ");
        String password= scanner.nextLine();

        Customer customer = loggingIn(username,password);
        if (customer!=null){
            menu(customer);
        } else System.out.println("thong tin dang nhap sai!");

    }
    public static Customer loggingIn(String username, String password){
        for (Customer customer: customers){
            if ((customer.getUsername().equals(username))&&
                    (customer.getPassword().equals(password))){
                return customer;
            }
        }
        return null;
    }
    public static void menu(Customer customer){

            char menu;
            while (true) {
            System.out.println("1 de xem san pham 2 de them vao gio hang 3 de xem lai don hang 4 de thoat");
            menu = scanner.next().charAt(0);
            scanner.nextLine();

            switch (menu) {
                case '1':
                    displayPage();
                    break;
                case '2':
                    addToCart(customer);
                    break;
                case '3':
                    CartService.displayCart(customer);
                    break;
                case '4':
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("nhap khong hop le ");
                    break;
            }
        }

    }


    //xem trang
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

    //add to cart
    public static void addToCart(Customer customer){

        List<CartItem> cartItems= new ArrayList<>();
        char isAddingToCard='Y';
        while (isAddingToCard=='Y') {
            System.out.println("nhap ten san pham can them vao gio hang ");
            String productName = scanner.nextLine();

            System.out.println("san pham nay bao gom cac size va mau sau:");
            ProductService.displayVariant(productName);

            System.out.println("chọn một size: ");
            String size= scanner.nextLine();

            System.out.println("chọn một màu: ");
            String color= scanner.nextLine();

            Variant variant = ProductService.findVariant(productName, size,color);
            int variantId= variant.getVariantId();

            System.out.println("nhap so luong ");
            int quantity = scanner.nextInt();
            scanner.nextLine();


            CartItem cartitem = new CartItem(productName,variant, quantity,variantId);
            cartItems.add(cartitem);

            System.out.println("ban co them tiep? Y/N");
            isAddingToCard=scanner.next().charAt(0);
            scanner.nextLine();
        }
        int cartId= CartService.addingCartId();
        long totalPrice = CartService.getTotalPriceForCart(cartItems);
        Cart cart = new Cart(cartId,cartItems,totalPrice);
        customer.setCart(cart);
    }



}
