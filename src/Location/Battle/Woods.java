package Location.Battle;

import Character.Player;
import Location.Battle.Obstacles.Vampire;

public class Woods extends BattleLocation {

    public Woods(Player player) {
        super(player, "Woods", new Vampire(), "Firewood", 3);
        
    }
    
}
