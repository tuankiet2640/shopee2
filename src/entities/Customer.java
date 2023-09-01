package entities;

import service.ProductService;

import java.util.List;
import service.CartService;

public class Customer extends User{
    private long balance;
    private Cart cart;
    public Customer(int userId, String username, String password, long balance) {
        super(userId, username, password);
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer(long balance) {
        this.balance = balance;
    }

    public Customer() {
    }
}

