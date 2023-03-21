package Location.Battle;

import java.util.Random;

import Character.Player;
import Location.Location;
import Location.Battle.Obstacles.Obstacle;

public abstract class BattleLocation extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;



    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }
    

    public Obstacle getObstacle() {
        return obstacle;
    }


    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }


    public String getAward() {
        return award;
    }


    public void setAward(String award) {
        this.award = award;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }


    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber(){
        
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }


    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are on " + this.getName());
        System.out.println("Becareful! | There are " + obsNumber + " " + getObstacle().getName() + " here!");
        return true;
    }
    
}
