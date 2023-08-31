package service;

import entities.Product;
import entities.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductService {
    protected static List<Product> products = new ArrayList<>();
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
        return "sanpham" + productNumber;
    }

    //create variant
    private static Product createListVariant(Product product) {

        List<Variant> variants = product.getVariants();

        final String[] size = {"S", "M", "'L','X'", "XL", "XXL"};

        final String[] color = {"black", "white", "red",
                "orange", "green", "blue", "maroon", "grey",
                "lime", "yellow"};
        int randomColorSize =ThreadLocalRandom.current().nextInt(0, color.length);

        for (int sizeIndex=0;sizeIndex<size.length;sizeIndex++){
            for (int colorIndex=0;colorIndex<randomColorSize;colorIndex++){

            }
        }
        ThreadLocalRandom.current().nextInt(0, 3);
        return null;
    }
    public static Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    //random price
    public static long setPrice() {
        return ThreadLocalRandom.current().nextLong(10, 10000);
    }
}
