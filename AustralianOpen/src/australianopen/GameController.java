package australianopen;
import java.util.*;

public class GameController 
{
    //If gamecount is gre
    private int gameCount;
    private ArrayList<Game> gameHistory;
    
    public void startGame(Game game)
    {
        if(game.hasPlayers() == true)
        {
        
        }
        else
        {
            System.out.println("Incorrect amount of players");
        }
    }
    
    public void chooseWinner(Game game)
    {
        System.out.println("The current players in the game are:");
    }
    
    
    
    
}
