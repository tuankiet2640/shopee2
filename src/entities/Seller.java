package entities;
import service.ProductService;
import entities.Product;

import java.util.List;
import java.util.Scanner;

public class Seller extends User {
    private int userId;
    public Seller(int userId, String username, String password) {
        super(userId, username, password);
    }

}
