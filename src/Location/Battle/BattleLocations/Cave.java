package Location.Battle.BattleLocations;

import Character.Player;
import Location.Battle.Awards.Food;
import Location.Battle.Obstacles.Zombie;

public class Cave extends BattleLocation{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), new Food(), 3);

    }


}
