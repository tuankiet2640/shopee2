package service;

import entities.Cart;
import entities.CartItem;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static ProductService productService= new ProductService();
    private final static List<Product> products = productService.getList();
    private static Cart cart= new Cart();


    public static void displayPage(int pageNumber, int pageSize){

        int indexStart;
        int indexEnd;

        indexStart= (pageNumber-1)*pageSize;
        indexEnd= indexStart+pageSize;

        if(indexStart>products.size()-1){
            System.out.println("nhap khong hop le");
        }
        if (indexStart<products.size()){
            indexEnd=products.size();
            for (int index=indexStart;index<indexEnd;index++){
                System.out.println(products.get(index));
            }
        }
    }

}
