package project.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int stock_quantity;
    private String category;


    public Product(){

    }
    //Constructor without id
    public Product(String name ,double price,int stock_quantity,String category){
        this.name= name;
        this.price=price;
        this.stock_quantity=stock_quantity;
        this.category=category;
    }

 // Constructor with id

public Product(int id,String name ,double price,int stock_quantity,String category){
        this.id=id;
        this.name= name;
        this.price=price;
        this.stock_quantity=stock_quantity;
        this.category=category;
    }

  public int getId(){
    return id;
  }
    public void setId(int id){
        this.id=id;
    }
 
     public String getName(){
       return name;
     }
     public void SetName(String name){
        this.name=name;
     }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public int getStock_quantity(){
        return stock_quantity;
    }
    public void setStock_quantity(int stock_quantity){
        this.stock_quantity=stock_quantity;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }

  public String toString(){
    return "product[id " + id + " name " + name + " price " + price + " stock_quantity " + stock_quantity + " category ]";
  }


}
