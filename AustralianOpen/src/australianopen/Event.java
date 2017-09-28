package australianopen;
import java.util.*;
import java.io.*;

public class Event implements Serializable
{ 
  protected Date date;
  public ArrayList<Player> participants;
  protected Player winner;
  protected Boolean finished = false;
  static int idCount = 0;
  protected int gameID;
  GameController gc = GameController.getInstance();
  
  public Event()
  {
      idCount++;
      gameID = idCount;
  }
  
  
 
  
  public void addPlayer()
  {
      for(int i = 0; i < gc.getPlayers().size();i++)
      {
           
      }
      //When adding participant, force choose for teamside
      //Make sure only max 2 players in each teamside
      //Make sure participant is not in any other games currently active.
  }
  
  public abstract void setWinner(Player winner);
  
  
  
  public void playGame()
  {
      
  }
  
  public boolean readyStart()
  {
      //Make sure there are 2 players
      return true;
  }
    
}
