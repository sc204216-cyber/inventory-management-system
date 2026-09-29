package project.config;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConfig {
    private static final String url ="jdbc:mysql://localhost:3306/inventory";
    private static final String user ="root";
    private static final String password ="kajal123#";


    public static void main (String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
     try{
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        System.out.println("Congrats you succesfully connected to the Mysql");

     }
       catch(Exception e){
       System.out.println("NOT connected");
       e.printStackTrace();
       }
    
    }
 public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}   

