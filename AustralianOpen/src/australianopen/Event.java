package australianopen;
import java.util.*;
import java.io.*;

public class Event implements Serializable
{ 
  private Date date;  
  private Location location;
  public ArrayList<Player> participants;
  private Player winner;
  private Boolean finished = false;
  private static int idCount = 0;
  private int gameID;
  GameController gc = GameController.getInstance();
  
  public Event(Location location, Date date)
  {
      this.date = date;
    
      this.location = location;
      idCount++;
      gameID = idCount;
  }
  
  public enum Location
  {
      Rod_Laver, Hisense, Margaret_Court
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
  
  public void setWinner(Player winner)
  {
      this.winner = winner;
      this.finished = true;
  }
  
  
  
  public void playGame()
  {
      
  }
  
  public boolean readyStart()
  {
      //Make sure there are 2 players
      return true;
  }
    
}
