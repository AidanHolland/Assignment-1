package australianopen;
import java.util.*;


public class Game 
{ 
  private Date date;  
  private Location location;
  private Playoff playoff;
  private GameType gameType;
  public ArrayList<Participant> participants;
  private Player winner;
  private static int idCount = 0;
  private int gameID;
  
  public Game(Location location, Playoff playoff, GameType gameType, Date date)
  {
      this.date = date;
      this.gameType = gameType;
      this.location = location;
      this.playoff = playoff;
      idCount++;
      gameID = idCount;
  }
  
  public enum Location
  {
      Rod_Laver, Hisense, Margaret_Court
  }
    
  public enum Playoff
  {
    Preliminary, QuarterFinal, SemiFinal, Final 
  }
  
  public enum GameType
  {
      Single, Double
  } 
  
  public enum Winner
  {
      Red, Blue
  }
  
  public void addParticipants()
  {
      //When adding participant, force choose for teamside
      //Make sure only max 2 players in each teamside
  }
  
  public void setWinner(Player winner)
  {
      this.winner = winner;
  }
  
  public Boolean hasPlayers()
  {
      int counter = 0;
      for(Participant p : participants)
      {
          
          //Create a player instance to check against
          Player check = new Player();
          //Create a variable to import participant
          Class temp = p.getClass();
          //Check if
          if(temp.isInstance(check) == true)
          {
              counter++;
          }
      }
      
      switch(gameType)
      {
          case Single:
              if(counter == 2)
              {
              return true;
              }
              
          break;
          case Double:
              if(counter == 4)
              {
              return true;    
              }
      }
           return false;   
     
              
      
  }
    
}
