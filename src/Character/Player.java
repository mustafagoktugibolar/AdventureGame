package Character;
import java.util.Scanner;
import Location.Location;
import Location.Weapon;
import Location.Armor;
import Location.Battle.Cave;
import Location.Battle.River;
import Location.Battle.Woods;
import Location.Normal.SafeHouse;
import Location.Normal.ToolStore;


public class Player extends Inventory{
    
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private int HEALTH;
    private Scanner sc = new Scanner(System.in);
    Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }



    public Inventory getInventory() {
        return inventory;
    }



    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public int getTotalDamage(){
        return damage + this.getWeapon().getDamage();
    }



    public int getDamage() {
        return damage;
    }



    public void setDamage(int damage) {
        this.damage = damage;
    }



    public int getHealth() {
        return health + this.getArmor().getDodge();
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


    public int getHEALTH() {
        return HEALTH;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public Armor getArmor(){
        return this.getInventory().getArmor();
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

        switch(sc.nextLine().toUpperCase()){
            case "SAMURAI" :
                initPlayer(charList[0]);
                break;
            case "ARCHER" : 
                initPlayer(charList[1]);
                break;
            case "KNIGHT" : 
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
        + "\t0 : Leave The Game \n"
        + "\t1 : Safe House  \n"
        + "\t2 : Tool Store \n"
        + "\t3 : Cave \n"
        + "\t4 : Woods \n"
        + "\t5 : River \n"
        + "\t6 : Print Info\n";

            while(true){
            System.out.println(locations);
            System.out.print("Select Location : ");
    
            switch(sc.nextInt()){
                case 0 :
                    System.out.println("Leaving The Game...");
                    location = null;
                    Thread.sleep(2000);
                    break;
                case 1 :
                    location = new SafeHouse(this);
                    break;
                case 2 : 
                    location = new ToolStore(this);
                    break;
                case 3 :
                    location = new Cave(this);   
                    break;
                case 4 :
                    location = new Woods(this);
                    break;       
                case 5 :
                    location = new River(this);
                    break;  
                case 6 : 
                    printInfo();
                    Thread.sleep(1500);
                    continue;
                default :
                    location = new SafeHouse(this);
                    break;
            }
            if(location == null){
                break;
            }

            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
               
        }
        
    }
    

    private void initPlayer(GameCharacter character){
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharName(character.getName());
        HEALTH = this.getHealth();
        System.out.println(this.name + " named " + this.charName + " selected!");
    }

    public void printInfo(){
        System.out.println("Player Info : "
        + "\n \tName : " + this.name 
        + "\n \tHealth : " + this.getHealth()
        + "\n \tArmor : " + this.getArmor().getName() 
        + "\n \tDodge : " + this.getArmor().getDodge() 
        + "\n \tWeapon : " + this.getWeapon().getName()
        + "\n \tDamage : " + this.getTotalDamage()
        + "\n \tMoney : " + this.getMoney());
        
    }
    
    
}
