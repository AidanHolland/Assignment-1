package australianopen;

import java.io.*;
import java.io.Serializable;
import java.nio.file.*;
import java.util.*;

public class SaveLoad
{
    public void save(String s)
    {
        System.out.println("Enter filename");
        FileWriter fw = null;
        try
        {
            fw = new FileWriter("Name" + ".txt");
        }      
        catch(Exception e)
        {
            System.out.println("Exception caught, reason is: " + e);
        } 
       finally
        {
           // fw.close();
        }
        
    }
    
    
    public String loadToString(String filePath) throws IOException
    {
        String load = new String(Files.readAllBytes(Paths.get(filePath)));
        return load;
    }
    
    public void savePlayers()
    {
        //For each player class
        //Save a player to file
    }
    
    public ArrayList<Player> loadPlayers()
    {
        ArrayList<Player> players = null;
    //For each player class file that has been saved
    //Load in player object
        return players;
    }
    
    
    
}
