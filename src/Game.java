import java.util.Scanner;
import Character.Player;
import Location.Location;
import Location.Normal.SafeHouse;
import Location.Normal.ToolStore;

public class Game {
    private Scanner sc = new Scanner(System.in);
   
    public void start() throws InterruptedException{
        System.out.println("*********WELCOME*********");

        System.out.print("Enter Your Name : ");
        String playerName = sc.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName() + " Named Player Created...");
        Thread.sleep(2000);
        player.selectChar();

        Location location = null;
        while(true){
            player.printInfo();
            String locations = "Locations : \n"
            +"\t1 : Safe House  \n"
            +"\t2 : Tool Store \n";

            System.out.println(locations);
            System.out.print("Select Location : ");

            //Location Selection
            switch(sc.nextInt()){
                case 1 :
                    location = new SafeHouse(player);
                    break;
                case 2 : 
                    location = new ToolStore(player);
                    break;
                default :
                    location = new SafeHouse(player);
                    break;
            }
            //End Of the Game
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }

        }



    }
}
