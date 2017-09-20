package australianopen;

import java.io.*;

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
    
    
    public String loadString()
    {
    String loaded = "";
    
    return loaded;
    }
    
    
    
}
