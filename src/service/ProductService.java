package service;

import entities.CartItem;
import entities.Product;
import entities.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class ProductService {
    protected static List<Product> products = new ArrayList<>();
    private static int productIdSetter = 20000;
    private static int productNumber = 0;
    private static int variantId=30000;

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
        createListVariant(product);
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
    public static void createListVariant(Product product) {

        List<Variant> variants = product.getVariants();

        final String[] size = {"S", "M", "L", "XL"};

        final String[] color = {"black", "white", "red","gray","blue", "green"};

        int randomColorSize =ThreadLocalRandom.current().nextInt(1, color.length);
        int variantId;

        for (int sizeIndex=0;sizeIndex<size.length;sizeIndex++){
            for (int colorIndex=0;colorIndex<randomColorSize;colorIndex++){

                variantId=variantIdSetter();
                Variant variant= new Variant(variantId,size[sizeIndex],color[colorIndex]);
                variant.setVariantPrice(randomPriceForVariants());
                variants.add(variant);
            }
        }
        product.setVariants(variants);
    }

    //random price for variant
    private static long randomPriceForVariants(){
        return ThreadLocalRandom.current().nextLong(-10, 10);
    }

    private static int variantIdSetter(){
        return variantId++;
    }

    //lấy product có thuộc tính productName là productName
    public static Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    //display Variant
    public static void displayVariant(String productName){
        Product product = getProductByName(productName);

        ArrayList<String> sizeList= new ArrayList<>();
        ArrayList<String> colorList= new ArrayList<>();

        if(product != null) {

            List<Variant> variants= product.getVariants();

            sizeList.add(variants.get(0).getSize());
            colorList.add(variants.get(0).getColor());

            for (int index=1; index<variants.size();index++){

                if (!sizeList.contains(variants.get(index).getSize())) {
                    sizeList.add(variants.get(index).getSize());
                }
                if (!colorList.contains(variants.get(index).getColor())){
                    colorList.add(variants.get(index).getColor());
                }

            }
        }
        System.out.println(sizeList);
        System.out.println(colorList);
    }

    //tim variant va hien thi
    public static Variant findVariant(String productName, String size, String color){
        Product product = getProductByName(productName);
        assert product != null;
        List<Variant> variants= product.getVariants();

        for (Variant variant: variants){
            if ((Objects.equals(variant.getSize(), size))&&(Objects.equals(variant.getColor(), color))){
                return variant;
            }
        }
        return null;
    }
    public static String displayProductVariant(int variantId){

        Product product = findProductByVariantId(variantId);
        List<Variant> variants = product.getVariants();

        for (Variant variant: variants){
            if (variant.getVariantId()==variantId){
                return variant.getSize()+ " "+ variant.getColor();
            }
        }
        return "";
    }

    //find product by variant id
    public static Product findProductByVariantId(int variantId) {
        for (Product product : products) {
            List<Variant> variants = product.getVariants();
            for (Variant variant : variants) {
                if (variant.getVariantId() == variantId) {
                    return product;
                }
            }
        }
        return null;
    }

    //find variant by variant ID
    public static Variant findVariantByVariantId(Product product, int variantId){
        List<Variant> variants = product.getVariants();
        for (Variant variant: variants){
            if (variant.getVariantId()==variantId){
                return variant;
            }
        }
        return null;
    }

    //random price
    public static long setPrice() {
        return ThreadLocalRandom.current().nextLong(100, 10000);
    }
}
