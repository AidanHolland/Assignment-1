package australianopen;
import java.io.Serializable;

public class Player implements Serializable
{
    private String name;
    private int age;
    private char gender;
    String country;
    private int id;
    
    public Player() 
    {
        name = "Name";
        age = 0;
        gender = 'M';
        country = "Australia";
                
    }
    
    
    public String getName()
    {
        return name;
    }
    
        public String getCountry()
    {
        return country;
    }
    
}




