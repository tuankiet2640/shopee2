package service;

import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductService {
    protected static List<Product> products = new ArrayList<Product>();
    private final static String productName = "sanpham";
    private static int productIdSetter = 20000;
    private static int productNumber = 0;

    public static void taoDanhSachSanPham() {
        for (int index = 0; index < 100; index++) {
            themMotSanPham();
        }
    }

    public static void inRaSanPham() {
        for (int index = 0; index < products.size(); index++) {
            System.out.println(products.get(index));
        }
    }

    public static List<Product> getList() {
        return products;
    }

    public static void setList(List<Product> product) {
        products = product;
    }

    private static void themMotSanPham() {

        String productName = addProductName();
        long price = setPrice();
        int productId = productIdSetter();
        Product product = new Product(productId, productName, price);
        products.add(product);
    }

    //productId
    protected static int productIdSetter() {
        return productIdSetter++;
    }

    //cho tên tự tăng
    public static String addProductName() {
        productNumber++;
        return productName + productNumber;
    }

    //create variant
    private static void createVariant() {
        final String[] size = {"S", "M", "'L','X'", "XL", "XXL"};
        final String[] color = {"black", "white", "red",
                "orange", "green", "blue", "maroon", "grey",
                "lime", "yellow"};

        ThreadLocalRandom.current().nextInt(0, 3);

    }

    //random price
    public static long setPrice() {
        return ThreadLocalRandom.current().nextLong(10, 10000);
    }
}
