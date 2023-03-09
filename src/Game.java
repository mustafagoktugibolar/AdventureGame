import java.util.Scanner;

import Character.Player;

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


    }
}
