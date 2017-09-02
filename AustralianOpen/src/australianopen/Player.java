package australianopen;

public class Player extends Participant
{
    Team team;
    
    public Player()
    {
        super();
    }
    
    private enum Team
    {
        Red, Blue
    }
}
