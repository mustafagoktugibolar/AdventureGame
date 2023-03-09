package Location.Normal;

import Character.Player;
import Location.Location;

public class SafeHouse extends Location {

    public SafeHouse(Player player) {
        super(player, "Safe House");
        
    }

    @Override
    public boolean onLocation() throws InterruptedException {
        System.out.println("You are on safe House!\n"
        + "Health Renewed!\n"
        + "Health : " + this.getPlayer().getHealth());
        Thread.sleep(3000);
        return true;
    }
    
}
