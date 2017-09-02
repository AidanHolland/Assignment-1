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
        
        System.out.println("The current players in the game are:");
        //Select which team to win, sort by team colour.
        for(int i = 0; i < game.participants.size(); i++)
      {   
          //Create a player instance to check against
          Player check =  (Player)game.participants.get(i);

          if(check.team == Player.Team.Blue)
          {
            bluePlayers.add(check.getName());
          }
          else
          {
            redPlayers.add(check.getName());
          }
      }  
        
        if(bluePlayers.size() == 1)
        {
        System.out.println("Player 1: " + bluePlayers.get(0).toString());
        System.out.println("Player 2:" + redPlayers.get(0).toString());
        }
        else if(bluePlayers.size() == 2)
        {
        System.out.println("Team 1 Player 1: " + bluePlayers.get(0).toString());
        System.out.println("Team 1 Player 2: " + bluePlayers.get(1).toString());
        System.out.println("Team 2 Player 1: " + redPlayers.get(0).toString());
        System.out.println("Team 2 Player 2: " + redPlayers.get(1).toString());
        }
        
        
    }
    
    
   
    
}
