package australianopen;

public class Player extends Participant
{
    Team team;
    private int wins;
    
    public Player()
    {
       
    }
    
    
    public Player(String name, int age, char gender, String country)
    {
        super(name, age, gender, country);
    }
    
    public enum Team
    {
        Red, Blue
    }
    
    public Team getTeam()
    {
        return team;
    }
    
    public void addWin()
    {
        wins++;
    }

    
         
            
}
