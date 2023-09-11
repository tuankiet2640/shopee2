package entities;

import service.ProductService;

import java.io.Serializable;
import java.util.List;
import service.CartService;

public class Customer extends User implements Serializable {
    private long balance;
    private Cart cart;
    private Address address;
    public Customer(int userId, String username, String password, long balance, Address address) {
        super(userId, username, password);
        this.balance = balance;
        this.address=address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword(){
        return this.password;
    }
    public String getUsername(){
        return this.username;
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

