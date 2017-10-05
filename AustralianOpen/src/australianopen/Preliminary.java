package australianopen;
import java.util.*;
import java.io.*;

public class Preliminary extends Event 
{
    public Preliminary()
    {
      super();  
    }
    
    @Override
    public void setWinner(Player winner)
    {
        //If there is a game not completely filled, add that player into that game
        for(int i = 0; i < gc.getGames().size(); i++)
        {
            if(gc.getGames().get(i).readyStart() == 0 || gc.getGames().get(i).readyStart() == 1)
            {
                addPlayer(winner);
                return;
            }
        }
        //If there are no available spots, make a new game
        QuarterFinal qf = new QuarterFinal();
        qf.addPlayer(winner);
        //Save winner details
        sl.save("The winner of preliminary ID: " + this.getGameID() + " is: "
                + winner.getName(), "Preliminary_Winner" + this.getGameID() + ".txt");
        //Move game to history   
        gc.getGames().remove(this);
        gc.getGameHistory().add(this);
        System.out.println(winner.getName() + " has won the round! Player added to the Quarter Final!");
        
    }
    
    public void populatePlayers()
  {
      for(int i = 0; i < gc.getPlayers().size();i++)
      {
           switch(readyStart())
           {
               case 2:
                   return;
           }
           if(gc.getPlayers().get(i).isInAGame() == false)
           {
               participants.add(gc.getPlayers().get(i));
           }
      }
      //Make sure only max 2 players in each teamside
      //Make sure participant is not in any other games currently active.
  }
    
}
