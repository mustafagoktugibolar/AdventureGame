package Character;
import java.util.Scanner;

import Character.GameCharacters.Archer;
import Character.GameCharacters.GameCharacter;
import Character.GameCharacters.Knight;
import Character.GameCharacters.Samurai;
import Character.Inventory.Armor;
import Character.Inventory.Inventory;
import Character.Inventory.Weapon;
import Location.Location;
import Location.Battle.Awards.Award;
import Location.Battle.BattleLocations.Cave;
import Location.Battle.BattleLocations.River;
import Location.Battle.BattleLocations.Woods;
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
    Inventory inventory = null;
    
    


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

    public Award getAward(){
        return this.getInventory().getAward();
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
                    if(this.getAward().getHasAward() == false){
                        location = new Cave(this);
                        break;
                    }
                    else{
                        System.out.println("You Took The Award! | Go To Another Location!");
                        continue;
                    }
                case 4 :
                    if(this.getAward().getHasAward() == false){
                        location = new Woods(this);
                        break;
                    }
                    else{
                        System.out.println("You Took The Award! | Go To Another Location!");
                        continue;
                    }  
                case 5 :
                    if(this.getAward().getHasAward() == false){
                        location = new River(this);
                        break;
                    }
                    else{
                        System.out.println("You Took The Award! | Go To Another Location!");
                       continue;
                    }  
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

            //FINISING THE GAME
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
        + "\n \tAwards : " +  this.getAward().getName()
        + "\n \tArmor : " + this.getArmor().getName() 
        + "\n \tDodge : " + this.getArmor().getDodge() 
        + "\n \tWeapon : " + this.getWeapon().getName()
        + "\n \tDamage : " + this.getTotalDamage()
        + "\n \tMoney : " + this.getMoney());
        
    }

    // private void creatLocations(){
    //     safeHouse = new SafeHouse(this);
    //     toolStore = new ToolStore(this);
    //     cave = new Cave(this);
    //     river = new River(this);
    //     woods = new Woods(this);
    // }
    
    
}
