package entities;
import service.ProductService;
import entities.Product;

import java.util.List;
import java.util.Scanner;

public class Seller {
    private static ProductService productService= new ProductService();
    private final static List<Product> products = productService.getList();
    private static final Scanner scanner = new Scanner(System.in);
    public static void addProduct(){
        System.out.println("nhap gia san pham moi ");
        long price = scanner.nextLong();
        scanner.nextLine();

        String productName= ProductService.addProductName();

        Product product = new Product(productName,price);

        products.add(product);

    }


}
