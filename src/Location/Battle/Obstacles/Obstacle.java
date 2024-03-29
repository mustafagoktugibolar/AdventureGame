package Location.Battle.Obstacles;

public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int award;
    private final int DEFAULT_HEALTH;

    
    public Obstacle(String name, int id, int damage, int health, int award) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.award = award;
        DEFAULT_HEALTH = health;

    }

    public void setHealthToDefault(){
        this.setHealth(DEFAULT_HEALTH);
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public int getAward() {
        return award;
    }


    public void setAward(int award) {
        this.award = award;
    }

    public void printInfo(){
        System.out.println("\nObstacle Info : "
        + "\n \tName :" + this.name
        + "\n \tHealth : " + this.getHealth()
        + "\n \tDamage : " + this.getDamage()
        + "\n \tAward : " + this.getAward() + "\n");
    }

}
