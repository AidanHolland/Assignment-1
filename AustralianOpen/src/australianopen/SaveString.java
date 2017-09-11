package australianopen;

import java.io.*;

public class SaveString 
{
    
    
    
    public void save(String s)
    {
        System.out.println("Enter filename");
        
        try
        {
            FileWriter fw = new FileWriter("Name" + ".txt");
        }
        catch(Exception e)
        {
            System.out.println("Exception caught, reason is: " + e);
        }
        
    }
    
}
