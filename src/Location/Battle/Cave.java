package Location.Battle;

import Character.Player;
import Location.Battle.Obstacles.Zombie;

public class Cave extends BattleLocation{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food", 3);

    }


}
