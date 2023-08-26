package entities;

import service.ProductService;

import java.util.List;
import service.CartService;

public class Customer extends User{
    private long balance;
    private final CartService cartService= new CartService();

    public Customer(String username, String password, long balance) {
        super(username, password);
        this.balance = balance;
    }


    public Customer(long balance) {
        this.balance = balance;
    }

    public Customer() {
    }
}

