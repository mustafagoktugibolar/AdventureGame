package Location.Normal;

import Character.Player;
import Location.Location;

public class ToolStore extends Location{

    public ToolStore(Player player) {
        super(player, "Tool Store");
        
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are on Tool Store");
        return true;
    }
    
}
