import entities.Customer;
import entities.Product;
import entities.Seller;
import service.CustomerService;
import service.ProductService;

public class Main {
    public static void main(String[] args) {

        ProductService.taoDanhSachSanPham();
        ProductService.inRaSanPham();
        Seller.addProduct();
//        ProductService.inRaSanPham();
        CustomerService.displayPage(3,40);
    }
}