package Location.Battle.BattleLocations;

import Character.Player;
import Location.Battle.Awards.Firewood;
import Location.Battle.Obstacles.Vampire;

public class Woods extends BattleLocation {

    public Woods(Player player) {
        super(player, "Woods", new Vampire(),new Firewood(), 3);
        
    }
    
}
