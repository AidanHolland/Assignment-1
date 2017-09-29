package australianopen;
import java.util.*;
import java.io.*;

public abstract class Event implements Serializable
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
      gc.addGame(this);
  }
  
  public void addPlayer(Player p)
  {
      participants.add(p);
  }
 
  //Checking for full game
  public void populatePlayers()
  {
      for(int i = 0; i < gc.getPlayers().size();i++)
      {
           switch(readyStart())
           {
               case 2:
                   return;
           }
           
      }
      //Make sure only max 2 players in each teamside
      //Make sure participant is not in any other games currently active.
  }
  
  //Abstract as we are looking for a different type of event in each subclass
  public abstract void setWinner(Player winner);
  
  
  
  public void playGame()
  {
      //Take both players in list
      //Give players both points
      //Randomly give each player a number
      //Higher number means give that player a point
      //Reset
      //When one players point is 15
      //Set winner(that player)
  }
  
  public int readyStart()
  {
      switch(participants.size())
      {
          case 0:
                return 0;
          case 1:
                return 1;
          case 2:
                return 2;
      }
      return 3;
  }
    
}
