package australianopen;
import java.util.*;
import java.io.*;


public class GameController 
{
    //Once gamecount has reached the maximum number of games, then call game end
    private static int gameCount;
    private ArrayList<Event> games;
    //All inactive games go here
    private ArrayList<Event> gameHistory;
    private ArrayList<Player> players;
    SaveLoad sl = SaveLoad.getInstance();
    
    private static GameController gc = null;
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
    
    public ArrayList<Event> getGameHistory()
    {
        return gameHistory;
    }
    
    public void startTournament()
    {
        //Make sure 16 players are added in
        //Create 8 preliminaries and add the players into the game
        for(int i = 0; i < 8; i++)
        {
            //Game game = new Game();
        }
    }
    
    
    public void startGame(Event game)
    {
        if(game.readyStart() == 2)
        {
            game.playGame();
            //Take winner from game
            //Save player to winners list file
            //Make a new game
            //add player to new game
            //Add game to game history
            //Play next game in preliminary
            //If we have reached the end of the loop, start semi finals
          
            gameHistory.add(game);
        }
        else
        {
            System.out.println("Incorrect amount of players");
            //Find a player to add
        }
    }
    
    
    
    public void populateGame()
    {
        //Create 8 preliminary
        
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
