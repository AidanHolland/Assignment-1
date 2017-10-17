package australianopen;

import java.util.Scanner;


public class Final extends Event
{
    public Final()
    {
        super();
    }
    
    @Override
    public void setWinner(Player winner)
    {
        sl.save("The winner of Final Match, ID: " + this.getGameID() + " is: "
                + winner.getName() + "\n", "finalwinner.txt");
        //Move game to history   
        gc.getGameHistory().add(this);
   
            System.out.println(winner.getName() + " has won the Game, congratulations!");
            gc.restart("The game has now been finished!");
      
    }
}
