package australianopen;
import java.util.*;


public class GameController 
{
    //Once gamecount has reached the maximum number of games, then call game end
    private static int gameCount;
    private ArrayList<Game> games;
    private ArrayList<Game> gameHistory;
    
    public void startTournament()
    {
        //Make sure 16 players are added in
        //
        
        
    }
    
    
    public void startGame(Game game)
    {
        Game temp = game;
        if(game.readyStart() == true)
        {
            game.playGame();
            //Take winner from game
            //Make a new game
        }
        else
        {
            System.out.println("Incorrect amount of players");
        }
        
        
        
    }
    
  
    
    
   
    
}
