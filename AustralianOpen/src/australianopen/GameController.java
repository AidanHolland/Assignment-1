package australianopen;
import java.util.*;
import java.io.*;


public class GameController 
{
    //Once gamecount has reached the maximum number of games, then call game end
    private static int gameCount;
    private ArrayList<Event> games = new ArrayList<Event>();
    //All inactive games go here
    private ArrayList<Event> gameHistory = new ArrayList<Event>();
    private ArrayList<Player> players = new ArrayList<Player>();
    SaveLoad sl = SaveLoad.getInstance();
    private Boolean prelimPlayed = false;
    private Boolean quarterPlayed = false;
    
    
    private static GameController gc = new GameController();
    private GameController(){}
   
    public static GameController getInstance()
    {
        /*if(gc == null)
        {
            gc = new GameController();    
        }*/
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
    
    public ArrayList<Event> getGameHistory()
    {
        return gameHistory;
    }
    
  
    
    
    public void startGame(Event game)
    {
        if(game.readyStart() == 2)
        {
            game.playGame();
            //Take winner from game
            //Save player to winners list file
            //Move game to game history
            games.remove(game);
            //Make a new game
            
            //add player to new game
           
          
            gameHistory.add(game);
        }
        else
        {
            System.out.println("Incorrect amount of players");
            //Find a player to add
        }
    }
    
    public void playPrelims()
    {
        //Check if prelims have been played, if so, prompt player for restart
        if(prelimPlayed == true)
        {
            System.out.println("");
            return;
        }
        //Loop through all games
        for(int i = 0; i < games.size(); i++)
        {
            startGame(games.get(i));
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
        //Check if this has been run already
    }
    
    public void playFinal()
    {
        
    }
    
    public void finish()
    {
    }
    
    public void restart()
    {
       //Clear all match arrays including history
        //Set all check variables to false;
    }
    
    public void populateGame()
    {
        //Create 8 preliminary games
        for(int i = 0; i < 8; i++)
        {
            Preliminary p = new Preliminary();
            p.populatePlayers();
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
    
    public void loadPlayers() throws IOException, ClassNotFoundException
    {
        players = sl.loadPlayers();
    }
    
    public void listPlayers()
    {
        for(int i = 0; i < players.size(); i++)
        {
            System.out.println((i + 1)+ ": " + players.get(i).getName());
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
