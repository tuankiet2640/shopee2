package entities;

import service.ProductService;

public class OrderLine extends CartItem{
    public OrderLine(Product product, int quantity, int variantId){
        super( product, quantity, variantId);
    }

}
