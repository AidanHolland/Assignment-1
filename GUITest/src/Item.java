/**
 * @author e43814
 * @version 2014
 */
import java.io.*;

public class Item implements Serializable{
    private double price;
    private String name;

    public Item(String name, double price) {
        this.price = price;
        this.name = name;
    }
       
    @Override
    public String toString(){
       String str = "<html><br />" + name + "<br />$" + price +"<br /></html>";
         
       return str;
    }

}
