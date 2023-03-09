package Character;
import java.util.Scanner;

public class Player extends Inventory{
    
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private Scanner sc = new Scanner(System.in);
    

    public Player(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getDamage() {
        return damage;
    }



    public void setDamage(int damage) {
        this.damage = damage;
    }



    public int getHealth() {
        return health;
    }



    public void setHealth(int health) {
        this.health = health;
    }



    public int getMoney() {
        return money;
    }



    public void setMoney(int money) {
        this.money = money;
    }



    public String getCharName() {
        return charName;
    }



    public void setCharName(String charName) {
        this.charName = charName;
    }


    public void selectChar(){
        GameCharacter[] charList= {new Samurai(), new Archer(), new Knight()};

        for (GameCharacter gameCharacter : charList) {
            System.out.println("Character Name : " + gameCharacter.getName() 
            + "\t Health : " + gameCharacter.getHealth() 
            + "\t Damage : " + gameCharacter.getDamage() 
            + "\t Money : " + gameCharacter.getMoney());
        }
        System.out.print("Select Hero : ");

        switch(sc.nextLine()){
            case "Samurai" :
                initPlayer(charList[0]);
                break;
            case "Archer" : 
                initPlayer(charList[1]);
                break;
            case "Knight" : 
                initPlayer(charList[2]);
                break;  
            default :
                initPlayer(charList[0]);
                break;            
        }
    }
    private void initPlayer(GameCharacter character){
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
        System.out.println(this.name + " named " + this.charName + " selected!");
    }

    
}
