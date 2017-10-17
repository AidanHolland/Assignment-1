package australianopen;
import java.util.*;
import java.io.*;

public class Preliminary extends Event 
{
    static int pCounter = 0;
    public Preliminary()
    {
      super();  
      gameType = "Preliminary";
    }
    
    @Override
    public void setWinner(Player winner)
    {
        //If there is a game not completely filled, add that player into that game
        for(int i = 0; i < gc.getGames().size(); i++)
        {
            if(gc.getGames().get(i).readyStart() == 1)
            {
                gc.getQF().get(gc.getQF().size()-1).participants.add(this.winner);
                sl.save("The winner of preliminary ID: " + this.getGameID() + " is: "
                + winner.getName(), "prelimwinners.txt");
                System.out.println(winner.getName() + " has won the round! Player added to the Quarter Final!");
                gc.getGameHistory().add(this); 
                return;
            }
        }
        //If there are no available spots, make a new game
        QuarterFinal qf = new QuarterFinal();
        System.out.println("created a new quarter final!");
        //qf.addPlayer(winner);
        //Save winner details
        sl.save("The winner of preliminary ID: " + this.getGameID() + " is: "
                + winner.getName(), "prelimwinners.txt");
          qf.addPlayer(this.winner);
        gc.getQF().add(qf);
        //Move game to history 
        gc.getGameHistory().add(this); 
        System.out.println(winner.getName() + " has won the round! Player added to the Quarter Final!");
    }
    
    public void populatePlayers()
    {    
      for(int i = 0; i < 2; i++)
      {
           /*switch(readyStart())
           {2
               case 2:
                   return;
           }
           if(gc.getPlayers().get(pCounter).isInAGame() == false)
           {*/
               pCounter++;
               participants.add(gc.getPlayers().get(pCounter));
           //}
      }
      //Make sure only max 2 players in each teamside
      //Make sure participant is not in any other games currently active.
    }
    
}
