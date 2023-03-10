package Character;
import java.util.Scanner;
import Location.Location;
import Location.Normal.SafeHouse;
import Location.Normal.ToolStore;


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
        System.out.println("Character Names : ");
        for (GameCharacter gameCharacter : charList) {
            System.out.println("\t" + gameCharacter.getName()
            + " :" 
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
    public void selectLocation() throws InterruptedException{
        Location location = null;
        
        String locations = "Locations : \n"
        +"\t1 : Safe House \n"
        +"\t2 : Tool Store \n";
        
        System.out.println(locations);
        System.out.print("Select Location : ");

        switch(sc.nextInt()){
            case 1 :
                location = new SafeHouse(this);
                break;
            case 2 : 
                location = new ToolStore(this);
                break;
            default :
                location = new SafeHouse(this);
                break;
        }
        location.onLocation();
    }
    private void initPlayer(GameCharacter character){
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
        System.out.println(this.name + " named " + this.charName + " selected!");
    }
    
    
}
