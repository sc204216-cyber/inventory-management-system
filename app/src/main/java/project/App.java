package project;

import java.util.List;
import java.util.Scanner;

import project.dao.ProductDAO;
import project.model.Product;

public class App {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=================================");
            System.out.println(" INVENTORY MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. Add Product ");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product (Price & Stock)");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
        
           
        int choice=sc.nextInt();
        sc.nextLine();

        switch(choice){
            case 1:
            System.out.println("Enter product name");
            String name=sc.nextLine();
            System.out.println("Enter price");
            double price = sc.nextDouble();
            System.out.print("Enter Stock Quantity: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    Product newProduct = new Product(0, name, price, stock, category);
                    if (dao.addProduct(newProduct)) {
                        System.out.println("--> Product Added Successfully!");
                    } else {
                        System.out.println("--> Failed to Add Product.");
                    }
                    break;

            
           case 2:

               List<Product> products = dao.getAllProducts();
               
               System.out.println("Here is the all product");
               if(products.isEmpty()){
                System.out.println("There is no product so try again");


               }else{
                   for (Product p : products) {
                            System.out.println("ID: " + p.getId() + 
                                               " | Name: " + p.getName() + 
                                               " | Price: " + p.getPrice() + 
                                               " | Stock: " + p.getStock_quantity() + 
                                               " | Category: " + p.getCategory());
                }
               }
             break;
         
          
          
             case 3:
        System.out.println("Enter id for update");
        int updateId = sc.nextInt();
        System.out.println("Enter New price");
        double newPrice = sc.nextDouble();
        System.out.println("Enter your new stock_quantity");
        int newStock_quantity = sc.nextInt();
          Product updateProduct = new Product(updateId, "", newPrice, newStock_quantity, "");
                    if (dao.updateProduct(updateProduct)) {
                        System.out.println("--> Product Added Successfully!");
                    } else {
                        System.out.println("--> Failed to Add Product.");
                    }
                    break;

                  
                    case 4:
                        System.out.println("Enter delete id");
                        int deleteId = sc.nextInt();

                        if(dao.deleteProduct(deleteId)){
                            System.out.println("Deletion succesfull");

                        }else{
                            System.out.println("Deletion unsuccesfull");

                        }
                        
                        break;

                    case 5:

                    System.out.println("Thankyou ");
                    
                    default :
                    System.out.println("Invalid number");
                
                
                
                }
                
 


       




    }
}

}