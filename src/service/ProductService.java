package service;

import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductService {
    protected static List<Product> products = new ArrayList<Product>();
    private static int productNumber=0;
    private final static String productName="sanpham";

    public static void taoDanhSachSanPham(){

        for (int index=0; index<100; index++){
            themMotSanPham();
        }
    }
    public static void inRaSanPham(){
        for (int index=0;index<products.size();index++){
        System.out.println(products.get(index));
        }
    }



    public static List<Product> getList() {
        return products;
    }

    public static void setList(List<Product> product) {
        products = product;
    }

    private static void themMotSanPham(){
        String productName= addProductName();
        long price = setPrice();
        Product product = new Product(productName,price);
        products.add(product);
    }
    public static String addProductName() {
        productNumber++;
        return productName+productNumber;
    }


    public static long setPrice() {
        return randomPrice();
    }

    private static long randomPrice(){
        return nextLongBetween(10, 1000);
    }
    public static long nextLongBetween(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }


}
