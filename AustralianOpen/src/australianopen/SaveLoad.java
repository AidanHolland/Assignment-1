package australianopen;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class SaveLoad implements Serializable
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
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try 
        {    
            File newTextFile = new File(path);
            FileWriter fw = new FileWriter(newTextFile, true);
            fw.write(s);
            fw.append("\r\n");
            fw.close();
        } 
        catch (IOException iox) 
        {
            iox.printStackTrace();
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
            for(Player player: p)
            {
              oos.writeObject(player);
            }
            fout.close();
            oos.close();
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
    
    
  
    

	public ArrayList<Player> loadPlayers() 
    {   
        ArrayList<Player> loadedList = new ArrayList<Player>();
        ArrayList<Player> currentList = new ArrayList<Player>();
        int tempID = 0;
        FileInputStream fis;
        ObjectInputStream ois;
        
        for(int i = 0; i < GameController.getInstance().getPlayers().size(); i++)
        {	
            currentList.add(GameController.getInstance().getPlayers().get(i));  
        }
        
        try
        {
        	fis = new FileInputStream(finder);
        	ois = new ObjectInputStream(fis);
     
           while(true)
           {
        	   Object obj = ois.readObject(); 
        	   Player p = (Player)obj;
        	   loadedList.add(p);
           }
        }
        catch(EOFException eof)
        {
        	   
        }
        catch(Exception e)
        {
        	   e.printStackTrace();
        }
        
  
        //Find any common instances in both lists
        for(int i = 0; i < loadedList.size(); i++)
        {
            for(int j = 0; j < currentList.size(); j++)
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
       
        
        for(int k = 0; k < loadedList.size(); k++)
        {
            //Get largest ID to make sure we don't overwrite
            if(currentList.get(k).getID() > tempID)
            {
                tempID = currentList.get(k).getID();
            }
        }
        Player.idCount = tempID;
        
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
    
    


