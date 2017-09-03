package australianopen;

public class Player extends Participant
{
    Team team;
    private int wins;
    
    public Player()
    {
        
    }
    
    
    public Player(String country)
    {
        super();
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
