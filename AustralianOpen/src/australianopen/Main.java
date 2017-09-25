package australianopen;
import java.util.*;
import java.io.*;

public class Main 
{
    String lines = "";
    GameController gc = new GameController();
    SaveLoad sl = new SaveLoad();
    
    public static void main(String[] args) throws IOException
    {
       Main main = new Main();
       main.run();
    }
    
    public void menu()
    {
       
       System.out.println(lines);
    }
    
    public void run() throws IOException
    {
        int choice;
       
        lines = sl.loadToString("menu.txt");
        
        
        for(;;)
        {
            
            menu();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    return;
                            
                          
            }
        }
        
    }
    
}
