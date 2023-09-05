package entities;

import service.CartService;
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
    public CartItem(Product product, int quantity, int variantId) {
        this.product=product;
        this.quantity=quantity;
        this.variantId=variantId;
        this.subtotal= CartService.addingPriceToVariant(product, variantId);
    }
    public CartItem() {
    }

    @Override
    public String toString() {
        return "" +
                "product=" + product.getProductName() +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                ", variant= "+ ProductService.displayProductVariant(variantId) +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
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
