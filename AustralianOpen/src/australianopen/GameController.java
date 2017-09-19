package australianopen;
import java.util.*;


public class GameController 
{
    //If gamecount is gre
    private int gameCount;
    private ArrayList<Game> gameHistory;
    
    public void startGame(Game game)
    {
        Game temp = game;
        if(game.hasPlayers() == true)
        {
            chooseWinner(temp);
        }
        else
        {
            System.out.println("Incorrect amount of players");
        }
    }
    
    public void chooseWinner(Game game)
    {
        ArrayList<String> bluePlayers = new ArrayList();
        ArrayList<String> redPlayers = new ArrayList();
        Scanner s = new Scanner(System.in);
        Player check;
        
        String input;
        
        
       
        
    }
    
    
   
    
}
