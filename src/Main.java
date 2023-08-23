import entities.Product;
import service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService.taoDanhSachSanPham();
        ProductService.inRaSanPham();
        ProductService.displayPage(2,30);
    }
}