package service;

import entities.Product;

import java.util.List;
import java.util.Scanner;


public class SellerService {

    private final static Scanner scanner = new Scanner(System.in);
    private final static List<Product> products = ProductService.getList();


    public static void addProduct(){

        System.out.println("nhap ten san pham moi ");
        String productName= scanner.nextLine();

        System.out.println("nhap gia san pham moi ");
        long price = scanner.nextLong();
        scanner.nextLine();


        Product product = new Product(productName,price);

        products.add(product);
    }
}
