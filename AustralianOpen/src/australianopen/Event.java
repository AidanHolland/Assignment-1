package australianopen;
import java.util.*;
import java.io.*;
import java.util.Random;

public abstract class Event implements Serializable
{ 
  protected Date date;
  public ArrayList<Player> participants = new ArrayList<Player>();
  protected Player winner;
  protected Boolean finished = false;
  static int idCount = 0;
  protected int gameID;
  GameController gc = GameController.getInstance();
  SaveLoad sl = SaveLoad.getInstance();
  
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
 

  
  
  //Abstract as we are looking for a different type of event in each subclass
  public abstract void setWinner(Player winner);
  
  public int getGameID()
  {
      return gameID;
  }
  
  public void playGame()
  {
      int p1Points = 0;
      int p2Points = 0;
    
      Player p1 = participants.get(1);
      Player p2 = participants.get(2);
      
      Random r = new Random();
      while(p1Points <= 15 || p2Points <= 15)
      {
        int p1Rn = r.nextInt(100);
        int p2Rn = r.nextInt(100);

        if(p1Rn > p2Rn)
        {
            p1Points++;
        }
        else if(p2Rn > p1Rn)
        {
            p2Points++;
        }
          
      }
      
      if(p1Points > p2Points)
      {
          //Put p1 into winner
          winner = p1;
          //
      }
      else if(p2Points > p1Points)
      {
          winner = p2;
      }
     
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
