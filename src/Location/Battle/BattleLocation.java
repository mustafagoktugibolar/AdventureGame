package Location.Battle;

import Character.Player;
import Location.Location;
import Location.Battle.Obstacles.Obstacle;

public abstract class BattleLocation extends Location{

    private Obstacle obstacle;
    private String award;
    public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;

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


    @Override
    public
    boolean onLocation() {
        return false;
    }
    
}
