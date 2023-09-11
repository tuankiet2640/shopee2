package entities;

import service.ProductService;

import java.io.Serializable;

public class OrderLine extends CartItem implements Serializable {
    public OrderLine(Product product, int quantity, int variantId){
        super( product, quantity, variantId);
    }

}
