package service;

import entities.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;


public class SellerService implements Serializable {

    private final static Scanner scanner = new Scanner(System.in);
    private final static List<Product> products = ProductService.getList();


    public static void addProduct() {
        try {
            System.out.println("nhap ten san pham moi ");
            String productName = scanner.nextLine();

            System.out.println("nhap gia san pham moi ");
            long price = scanner.nextLong();
            scanner.nextLine();

            int productId= ProductService.productIdSetter();
            Product product = new Product(productId, productName, price);
            ProductService.createListVariant(product);
            products.add(product);
        } catch (Exception e) {
            System.out.println("nhap  ko hop le");
        }
    }
}
