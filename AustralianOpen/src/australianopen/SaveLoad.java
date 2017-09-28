package australianopen;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class SaveLoad
{
    String finder = "PLYR.txt";
    GameController gc = GameController.getInstance();
    //Lazy Singleton
    private static SaveLoad sl = null;
    private SaveLoad(){}
   
    public static SaveLoad getInstance()
    {
        if(sl == null)
        {
            sl = new SaveLoad();
        }
        return sl;
    }
    
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
    
    public void savePlayers(ArrayList<Player> p)
    {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try
        {
            fout = new FileOutputStream(finder);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(p);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(fout != null)
            {
                try
                {
                    fout.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            
            if(oos != null)
            {
                try
                {
                    oos.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public ArrayList<Player> loadPlayers() throws IOException, ClassNotFoundException
    {
        ArrayList<Player> loadedList = null;
        
        InputStream file = new FileInputStream(finder);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        int tempID = 0;
        
        loadedList = (ArrayList<Player>)input.readObject();
        ArrayList<Player> currentList = gc.getPlayers();
        
        //Find any common instances in both lists
        for(int i = 0; i < currentList.size(); i++)
        {
            for(int j = 0; j < loadedList.size(); j++)
            {
                //Remove commons instances in loadedList
                if(currentList.get(i).getID() == loadedList.get(j).getID())
                {
                    loadedList.remove(j);          
                }
            }
        }
        
        //Add all remaining objects to currentList
        for(int f = 0; f < loadedList.size(); f++)
        {
            currentList.add(loadedList.get(f));
        }
        for(int k = 0; k < currentList.size(); k++)
        {
            if(currentList.get(k).getID() > tempID)
            {
                tempID = currentList.get(k).getID();
            }
        }
        
        
        Player.idCount = tempID;
            
        return currentList;
    }
    
  
  
    
    
}
