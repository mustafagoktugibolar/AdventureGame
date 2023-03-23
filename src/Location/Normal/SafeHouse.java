package Location.Normal;

import Character.Player;
import Location.Location;

public class SafeHouse extends Location {

    public SafeHouse(Player player) {
        super(player, "Safe House");
        
    }

    @Override
    public boolean onLocation() throws InterruptedException {
        renewHealth();
        System.out.println("You are on safe House!\n"
        + "Health Renewed!\n"
        + "Health : " + this.getPlayer().getHealth());
        System.out.println();
        Thread.sleep(3000);
        return true;
    }

    private void renewHealth(){
        this.getPlayer().setHealth(this.getPlayer().getHEALTH());
    }
    
}
