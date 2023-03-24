package Location.Battle.BattleLocations;

import Character.Player;
import Location.Battle.Awards.Water;
import Location.Battle.Obstacles.Bear;

public class River extends BattleLocation{

    public River(Player player){
        super(player, "River", new Bear(), new Water(), 3);
    }
}
