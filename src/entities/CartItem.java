package entities;

import service.ProductService;

import java.util.List;

public class CartItem {

    private static final ProductService productService= new ProductService();
    private final static List<Product> products = productService.getList();

    private Product product = new Product();
    private int quantity;
    private final long subtotal =  product.getPrice()*quantity;

    public CartItem(String productName, int quantity) {
        product=getProductByName(productName);
        this.quantity=quantity;
    }
    public CartItem() {

    }

    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getSubtotal() {
        return subtotal;
    }
}
