package australianopen;
//ff

public class QuarterFinal extends Event
{
    public QuarterFinal()
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
        Final sf = new Final();
        sf.addPlayer(winner);
        //Save winner details
        sl.save("The winner of quarter final ID: " + this.getGameID() + " is: "
                + winner.getName(), "QuarterFinal_Winner" + this.getGameID() + ".txt");
        //Move game to history   
        gc.getGames().remove(this);
        gc.getGameHistory().add(this);
        
        System.out.println(winner.getName() + " has won the round! Player added to the Quarter Final!");
        
    }
    
    
    
}
