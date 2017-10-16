package australianopen;
import java.io.Serializable;

public class Player implements Serializable
{
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    String country;
    static int idCount;
    private int pid;
    GameController gc = GameController.getInstance();
    
    public Player(){}
    
    public Player(String firstName, String lastName, int age, char gender, String country) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.country = country; 
        idCount++;
        pid = idCount;
        gc.getPlayers().add(this);
    }
    
    
    public String getName()
    {
        return firstName + " " + lastName;
    }
    
    public int getID()
    {
        return pid;
    }
    
    public String getCountry()
    {
        return country;
    }
        
    @Override
    public String toString()
    {
        return "Name: " + firstName + " " + lastName + "\nAge: " + age 
                + "Gender:"  + gender+ "\nCountry: " + country + ".";
    }
    
    //Search through all games participants and compare ID
    public boolean isInAGame()
    {
        for(int i = 0; i < gc.getGames().size(); i++)
        {
            for(int f = 0; f < gc.getGames().get(i).participants.size(); f++)
            {
                if(gc.getGames().get(i).participants.get(f).getID() == this.getID())
                {
                    return true;
                }
            }
        }
        return false;
    }
    
}




