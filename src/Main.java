import entities.CartItem;
import entities.Customer;
import entities.Product;
import entities.Seller;
import service.CartService;
import service.CustomerService;
import service.ProductService;
import service.SellerService;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        ProductService.taoDanhSachSanPham();
//      ProductService.inRaSanPham();

//      SellerService.addProduct();
        CustomerService.run();
    }
}