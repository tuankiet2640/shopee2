package service;

import entities.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final static List<Customer> customers;
    private final static List<Product> products;
    private static final Scanner scanner;
    private static int cusId;
    static {
        customers = loadCustomerList();
        products = ProductService.getList();
        scanner= new Scanner(System.in);
        cusId=78000;
    }

    //main run()
    public static void run(){
        char menu;
        while (true) {
            System.out.println("1 dang ky 2 de dang nhap 3 de thoat");

            menu = scanner.next().charAt(0);
            scanner.nextLine();

            switch (menu) {
                case '1':
                    register();
                    break;
                case '2':
                    login();
                    break;
                case '3':
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("nhap khong hop le ");
                    break;
            }
        }

    }
    //dang ky
    public static void register(){
        int customerId= cusId++;

        System.out.println("nhap username can dang ky : ");
        String username=scanner.nextLine();

        System.out.println("nhap mat khau: ");
        String password= scanner.nextLine();

        long balance = 100000;

        Address address= addAddress();

        Customer customer = new Customer(customerId,username,password,balance, address);
        customers.add(customer);
    }


    // dang nhap
    public static List<Customer> loadCustomerList(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/files/customers.txt"));
            ois.readObject();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
    public static void login (){
        System.out.println("moi ban nhap username: ");
        String username= scanner.nextLine();

        System.out.println("moi ban nhap password: ");
        String password= scanner.nextLine();

        Customer customer = loggingIn(username,password);
        if (customer!=null){
            mainMenu(customer);
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
    public static void mainMenu(Customer customer){

            char menu;
            while (true) {
            System.out.println("1 de xem san pham 2 de them vao gio hang 3 de xem lai don hang 4 de chot order 5 de dang xuat 6 de thoat");
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
                    OrderService.order(customer);
                    break;
                case '5':
                    run();
                    break;
                case '6':
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
                    ProductService.displayVariant(products.get(index).getProductName());

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

            Product product = ProductService.getProductByName(productName);
            if (product != null) {
                CartItem cartitem = new CartItem(product, quantity,variantId);
                cartItems.add(cartitem);

            }
            System.out.println("ban co them tiep? Y/N");
            isAddingToCard=scanner.next().charAt(0);
            scanner.nextLine();
        }
        int cartId= CartService.addingCartId();
        long totalPrice = CartService.getTotalPriceForCart(cartItems);
        Cart cart = new Cart(cartId,cartItems,totalPrice);
        customer.setCart(cart);
    }

    public static Address addAddress(){
        Address address= new Address("ho chi minh", "nguyen van troi");
        return address;
    }
    public static Customer getCustomerById(int customerId) {
        for (Customer customer: customers){
            if (customer.getUserId()==customerId) {
                return customer;
            }
        }
        return null;
    }
}
