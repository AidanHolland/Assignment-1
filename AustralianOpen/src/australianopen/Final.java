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
                + winner.getName(), "winners.txt");
        //Move game to history   
        gc.getGames().remove(this);
        gc.getGameHistory().add(this);
        
        if(gc.getGames().size() == 1)
        {
            System.out.println(winner.getName() + " has won the Game, congratulations!");
            gc.restart();
        }
    }
}
