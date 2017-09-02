package australianopen;

public class Player extends Participant
{
    Team team;
    
    
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
    

    
         
            
}
