package australianopen;
//ff

public class QuarterFinal extends Event
{
    public QuarterFinal()
    {
        super();
        gameType = "Quarter Final";
    }
    
     @Override
    public void setWinner(Player winner)
    {
        //If there is a game not completely filled, add that player into that game
        for(int i = 0; i < gc.getF().size(); i++)
        {
            if(gc.getF().get(i).readyStart() == 0 || gc.getF().get(i).readyStart() == 1)
            {
                gc.getF().get(gc.getF().size() -1).addPlayer(this.winner);
                sl.save("The winner of QuarterFinal ID: " + this.getGameID() + " is: "
                + winner.getName(), "qfwinners.txt");
                gc.getGameHistory().add(this); 
                System.out.println(winner.getName() + " has won the round! Player added to the Final!");
                return;
            }
        }
        //If there are no available spots, make a new game
        Final f = new Final();
        System.out.println("created a new Final!");
        f.addPlayer(winner);
        //Save winner details
        sl.save("The winner of QuarterFinal ID: " + this.getGameID() + " is: "
                + winner.getName(), "qfwinners.txt");
          
        gc.getF().add(f);
        //Move game to history 
        gc.getGameHistory().add(this); 
        System.out.println(winner.getName() + " has won the round! Player added to the Final!");
    
    }
    
}
