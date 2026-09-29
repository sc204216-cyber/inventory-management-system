package project.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import project.config.DatabaseConfig;
import project.model.Product;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
public class ProductDAO {
    
    public boolean addProduct( Product product){
        
        try{
            Connection connection = DatabaseConfig.getConnection();
            String query = "INSERT INTO products (name, price, stock_quantity, category) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getStock_quantity());
            preparedStatement.setString(4, product.getCategory());

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected>0){
                System.out.println("Data inserted");
                return true;        
            }
        
        }
         catch(Exception e){
            System.out.println("Not Inserted");
            e.printStackTrace();
           return false;
         }

        return false;
    }

public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
     String query = "SELECT * FROM products";

    try (Connection connection = DatabaseConfig.getConnection();
   
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet rs = preparedStatement.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            int stock_quantity = rs.getInt("stock_quantity");
            String category = rs.getString("category");
            Product product = new Product(id, name, price, stock_quantity, category);
            products.add(product);
            
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return products;
}
    public boolean deleteProduct(int id){
         String query = "DELETE FROM products WHERE id = ?";
         try{
            Connection connection= DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,id);

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected>0){
                System.out.println("Done");

            }
        }
        catch(Exception e){
            System.out.println("NOT DONE");
            e.printStackTrace();
        }
        return false;
    }
      public boolean updateProduct(Product product){
        String query ="UPDATE products SET price = ?, stock_quantity = ?  WHERE id = ?";
      
     try{
        Connection connection = DatabaseConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setDouble(1,product.getPrice());
        preparedStatement.setInt(2,product.getStock_quantity());
        preparedStatement.setInt(3, product.getId());

        int rowaffected = preparedStatement.executeUpdate();
        if(rowaffected>0){
            System.out.println("Congrate upadate succesful");
        }else{
            System.out.println("Sorry upadte fail");
        }
      
      
    
    
    } catch(Exception e){
        System.out.println("Do again for upadate ");
        e.printStackTrace();
       }

       return true;
    
    
    
    }

}
