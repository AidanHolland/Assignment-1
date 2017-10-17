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
    
    public Player(String firstName, String lastName, int age, char gender, String country, int ID)
    {
         this(firstName, lastName, age, gender, country);
         pid = ID;
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
        //For each of the games
        for(int i = 0; i < gc.getGames().size(); i++)
        {
           
            //For the size of the games participant array
            for(int f = 0; f < gc.getGames().get(f).getPlayers().size(); f++)
            {
                
                //If the games participant is the same as this players id
                if(gc.getGames().get(i).getPlayers().get(f).getID() == this.getID())
                {
                    return true;
                }
            }
        }
        return false;
    }
    
}




