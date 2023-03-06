public class Player extends Inventory{
    
    //Inventory inventory;
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;

    

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


    public void selectChar(String name){
        
        if(name.equals("Samurai")){
            this.setCharName(name);
            damage = 5;
            health = 21;
            money = 15;
        }
        else if(name.equals("Archer")){
            this.setCharName(name);
            damage = 7;
            health = 18;
            money = 20;
        }
        else if(name.equals("Knight")){
            this.setCharName(name);
            damage = 8;
            health = 24;
            money = 5;
        }

    }
    
}
