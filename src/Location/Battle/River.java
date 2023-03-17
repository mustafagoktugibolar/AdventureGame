package Location.Battle;

import Character.Player;
import Location.Battle.Obstacles.Bear;

public class River extends BattleLocation{

    public River(Player player){
        super(player, "River", new Bear(), "Water");
    }
}
