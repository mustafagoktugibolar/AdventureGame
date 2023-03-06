import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private String heroes = "Select a Hero...\n"
    + "Samurai\n"
    + "Archer\n"
    + "Knight";

    public void start(){
        System.out.println("*********WELCOME*********");

        System.out.print("Enter Your Name : ");
        String playerName = sc.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName() + " Named Player Created...");

        System.out.println(heroes);
        System.out.print("Selected Hero : ");
        player.selectChar(sc.nextLine());



    }
}
