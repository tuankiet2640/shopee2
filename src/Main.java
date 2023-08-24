import entities.Product;
import entities.Seller;
import service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService.taoDanhSachSanPham();
        ProductService.inRaSanPham();

        Seller.addProduct();
//        ProductService.inRaSanPham();

        ProductService.displayPage(3,40);
    }
}