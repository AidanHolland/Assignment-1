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
        
        System.out.println(winner.getName() + " has won the round! Player added to the Quarter Final!");
        
    }
    
    
}
