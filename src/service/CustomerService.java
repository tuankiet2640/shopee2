package service;

import entities.Cart;
import entities.CartItem;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final static List<Product> products = ProductService.getList();
    private static final Cart cart= new Cart();

    private static final Scanner scanner= new Scanner(System.in);


    public static void displayPage(){

        System.out.println("nhap so trang= ");
        int pageNumber= scanner.nextInt();
        scanner.nextLine();

        System.out.println("nhap size cua trang");
        int pageSize= scanner.nextInt();
        scanner.nextLine();


        int indexStart;
        int indexEnd;

        indexStart= (pageNumber-1)*pageSize;
        indexEnd= indexStart+pageSize;

        if(indexStart>products.size()-1){
            System.out.println("nhap khong hop le");
        }
        if (indexStart<products.size()){
            for (int index=indexStart;index<indexEnd;index++){
                System.out.println(products.get(index));
            }
        }
    }

}
