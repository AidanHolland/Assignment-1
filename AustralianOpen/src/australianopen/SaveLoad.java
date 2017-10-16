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
    private static SaveLoad sl = new SaveLoad();
    private SaveLoad(){}
   
    public static SaveLoad getInstance()
    {
        /*if(sl == null)
        {
            sl = new SaveLoad();
        }*/
        return sl;
    }
    
    public void save(String s, String path)
    {
        System.out.println("Enter filename");
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
     
        try
        {
            if(new File(path).isFile())
            {
                fout = new FileOutputStream(path, true);
                oos = new ObjectOutputStream(fout);
                oos.writeBytes(s);
            }
            else
            {
                fout = new FileOutputStream(path);
                oos = new ObjectOutputStream(fout);
                oos.writeBytes(s);
            }
        }      
        catch(Exception e)
        {
            System.out.println("Exception caught, reason is: " + e);
        } 
        finally
        {
           closeStreams(fout, oos);
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
            for(int i = 0; i < p.size(); i++)
            {
                oos.writeObject(p.get(i));
            }
        }
        catch(Exception e)
        {
            System.out.println("Error is: " + e);
        }
        finally
        {
            closeStreams(fout, oos);
        }
        
    }
    
    
  
    
    public ArrayList<Player> loadPlayers() throws IOException, ClassNotFoundException
    {   
        ArrayList<Player> loadedList = new ArrayList<Player>();
        ArrayList<Player> currentList = new ArrayList<Player>();
        
        for(int i = 0; i < GameController.getInstance().getPlayers().size(); i++)
        {
            currentList.add(GameController.getInstance().getPlayers().get(i));     
        }
      
        try
        {
            int tempID = 0;
            boolean cont = true;
            FileInputStream fis = new FileInputStream(finder);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            //loadedList = (ArrayList<Player>) ois.readObject();
            while(cont)
            {
                Object obj = null;
                try
                {
                    obj = ois.readObject();
                    if(obj != null)
                    {
                        
                    }
                    Player p = (Player) ois.readObject();
                    loadedList.add(p);
                }
                catch(FileNotFoundException e)
                {
                }
            }
            
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
                //Get largest ID to make sure we don't overwrite
                if(currentList.get(k).getID() > tempID)
                {
                    tempID = currentList.get(k).getID();
                }
            }
            Player.idCount = tempID;
        }
        catch(Exception e)
        {
            
        }
        return currentList;
    }
    
  
    public void closeStreams(FileOutputStream fout, ObjectOutputStream oos)
    {
         if(fout != null)
            {
                try
                {
                    fout.close();
                }
                catch(Exception e)
                {
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
                }
            }
        }
    }
    
    


