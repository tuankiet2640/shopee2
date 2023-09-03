package entities;

import service.CustomerService;
import service.ProductService;

import java.util.List;

import static service.ProductService.displayProductVariant;

public class CartItem {

    private int cartItemId;
    private Product product = new Product();
    private int quantity;
    private long subtotal;
    private int variantId;
    public CartItem(String productName, Variant variant, int quantity, int variantId) {
        product=ProductService.getProductByName(productName);
        this.quantity=quantity;
        this.subtotal=product.getPrice()*quantity;
        this.variantId=variantId;
    }
    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product.getProductName() +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", variant= "+ ProductService.displayProductVariant(variantId) +
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
