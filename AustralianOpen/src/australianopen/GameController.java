package australianopen;
import java.util.*;
import java.io.*;


public class GameController implements Serializable 
{
    //Once gamecount has reached the maximum number of games, then call game end
    private static int gameCount;
    private ArrayList<Event> games = new ArrayList<Event>();
    private ArrayList<QuarterFinal> qfGames = new ArrayList<QuarterFinal>();
    private ArrayList<Final> fGames = new ArrayList<Final>();
    //All inactive games go here
    private ArrayList<Event> gameHistory = new ArrayList<Event>();
    private ArrayList<Player> players = new ArrayList<Player>();
    SaveLoad sl = SaveLoad.getInstance();
    private Boolean prelimPlayed = false;
    private Boolean quarterPlayed = false;
    private static final long serialVersionUID = -8051305154870863799L;
    
    
    private static GameController gc = new GameController();
    private GameController(){}
   
    public static GameController getInstance()
    {
        if(gc == null)
        {
            gc = new GameController();    
        }
        return gc;
    }
    
    public void addGame(Event game)
    {
        games.add(game);
    }
    
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    public ArrayList<Event> getGames()
    {
        return games;
    }
    
    public ArrayList<QuarterFinal> getQF()
    {
        return qfGames;
    }
    
    public ArrayList<Final> getF()
    {
        return fGames;
    }    
        
    
    public ArrayList<Event> getGameHistory()
    {
        return gameHistory;
    }
    
  
    
    
    public void startPrelim(Event game)
    {
        if(game.readyStart() == 2)
        {
            game.playGame();
        }
    }
    
    public void startQF(QuarterFinal game)
    {
        if(game.readyStart() == 2)
        {
            game.playGame();
        }
    }
    
    public void startFinal(Final game)
    {
        if(game.readyStart() == 2)
        {
            game.playGame();
        }
    }
    
    public void populateGame()
    {
        //Create 8 preliminary games
        for(int i = 0; i < 8; i++)
        {
            Preliminary p = new Preliminary();
            p.populatePlayers();
            
            System.out.println(p.getPlayers().get(0).getName() + " has been added to match ID: " + p.getGameID());
            System.out.println(p.getPlayers().get(1).getName() + " has been added to match ID: " + p.getGameID());
        }
        
    }
   
    public void playPrelims()
    {
       
        //Check if prelims have been played, if so, prompt player for restart
        if(prelimPlayed == true)
        {
            restart("This game has been played already!");
            return;
        }
        populateGame();
        //Loop through all games
        prelimPlayed = true;
        for(int i = 0; i < 8; i++)
        {
            startPrelim(games.get(i));
        }
        //Play game
        //Announce winner
        //Set that the prelims have been played
    }
    
    public void playQuarterFinal()
    {
        if(quarterPlayed == true)
        {
            return;
        }
         for(int i = 0; i < 4; i++)
        {
            startQF(qfGames.get(i));
        }
        quarterPlayed = true;
    }
    
    public void playFinal()
    {
        for(int i = 0; i < 2; i++)
        {
            startFinal(fGames.get(i));
        }
    }
    
    public void finish()
    {
        
    }
    
    public void restart(String s)
    {
       //Clear all match arrays including history
        //Set all check variables to false;
        System.out.println(s);
        System.out.println("Would you like to restart? Y/N");
        
        
        
        String choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextLine();
        
        switch(choice)
        {
            case "Y":
            case "y":
            case "Yes":
            case "yes":
                 System.exit(0);
                break;
            case "N":
            case "n":
            case "No":
            case "no":
                System.exit(0);
                break;
        }
            
    }
    

    
    public void createPlayer()
    {
        String firstName;
        String lastName;
        int age;
        char gender;
        String country;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player details");
        System.out.println("First name: ");
        firstName = sc.nextLine();
        System.out.println("Last name: ");
        lastName = sc.nextLine();
        System.out.println("Age: ");
        age = sc.nextInt();
        System.out.println("Gender: (M or F)");
        gender = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Country: ");
        country = sc.nextLine();
       
        //Consrtucting player adds them into players
        Player p = new Player(firstName, lastName, age, gender, country);
        //Saves players to txt
        savePlayers();

        System.out.println("Player created!");
    }
  
    
    public void savePlayers()
    {
        sl.savePlayers(players);
        System.out.println("Players saved to file!");
    }
    
    
    public void listPlayers()
    {
        for(int i = 0; i < players.size(); i++)
        {
            System.out.println((i + 1)+ ": " + players.get(i).getName());
        }
    }
    
    public void listCurrentMatches()
    {
        for(int i = 0; i < games.size(); i++)
        {
            System.out.println(games.get(i).gameID + games.get(i).gameType + ". Winner is: " + games.get(i).winner);
        }
        
    }
    
    public void listQF()
    {
        for(int i = 0; i < qfGames.size(); i++)
        {
            System.out.println(qfGames.get(i).gameID + ": " + qfGames.get(i).gameType + ". Winner is: " + qfGames.get(i).winner.getName());
        }
    }
    
    //To be used in conjunction with listPlayers()
    public Player selectPlayer()
    {
        int i;
        Scanner sd = new Scanner(System.in);
        System.out.println("Select number of player.");
        i = sd.nextInt() + 1;
        return players.get(i);
    }
    
    public void loadPlayers()
    {
        players = sl.loadPlayers();
    }
    
    public String searchPlayer(int pid)
    {
        try
        {
            for(int i = 0; i < players.size(); i++)
            {
                if(pid == players.get(i).getID())
                {
                    return players.get(i).toString();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("No player ID of that number exists in the program");
        }
        return null;
       
    }
    
   
    
}
