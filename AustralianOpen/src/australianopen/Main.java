package australianopen;
import java.util.*;


public class Main 
{
    String lines = "";
    GameController gc = new GameController();
    
    public static void main(String[] args) 
    {
       Main main = new Main();
       main.run();
    }
    
    public void menu()
    {
       
    }
    
    public void run()
    {
        int choice;
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
