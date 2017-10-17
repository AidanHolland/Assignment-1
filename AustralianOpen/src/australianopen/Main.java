package australianopen;
import java.util.*;
import java.io.*;

public class Main 
{
    String lines = "";
    GameController gc = GameController.getInstance();
    SaveLoad sl = SaveLoad.getInstance();
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
       Main main = new Main();
       main.run();
    }
    
    public void menu()
    {
       System.out.println(lines);
    }
    
    public void run() throws IOException, ClassNotFoundException
    {
        int choice;
        gc.loadPlayers();
        lines = sl.loadToString("menu.txt");
       
        
        for(;;)
        {
            
            menu();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1:
                    gc.listPlayers();
                    break;
                case 2:
                    gc.createPlayer();
                    break;
                case 3:
                    gc.playPrelims();
                    break;
                case 4:
                    gc.playQuarterFinal();
                    break;
                case 5:
                    gc.playFinal();
                    break;
                case 6:
                    System.out.println("Enter the ID of your player");
                    choice = sc.nextInt();
                    System.out.println(gc.searchPlayer(choice));
                    break;
                case 7:
                    System.out.println(sl.loadToString("prelimwinners.txt"));
                    System.out.println(sl.loadToString("qfwinners.txt"));
                    System.out.println(sl.loadToString("finalwinner.txt"));
                    break;
                case 8:
                    return;
                case 9:
                    gc.listCurrentMatches();
                case 10:
                    gc.listQF();
                            
                          
            }
        }
        
    }
    
    
}
