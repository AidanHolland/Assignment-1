package australianopen;
import java.util.*;


public class GameController 
{
    //Once gamecount has reached the maximum number of games, then call game end
    private static int gameCount;
    private ArrayList<Game> games;
    private ArrayList<Game> gameHistory;
    private ArrayList<Player> activePlayers;
    
    public void startTournament()
    {
        //Make sure 16 players are added in
        //Create 8 preliminaries and add the players into the game
        for(int i = 0; i < 8; i++)
        {
            //Game game = new Game();
        }
    }
    
    
    public void startGame(Game game)
    {
        if(game.readyStart() == true)
        {
            game.playGame();
            //Take winner from game
            //Save player to winners list file
            //Make a new game
            //add player to new game
            //Add game to game history
            //Play next game in preliminary
            //If we have reached the end of the loop, start semi finals
          
            gameHistory.add(game);
        }
        else
        {
            System.out.println("Incorrect amount of players");
        }
    }
    
    
    
    public void createGame()
    {
    
    }
  
    
    
   
    
}
