package Location;
import Character.Player;

public abstract class NormalLocation extends Location{

    public NormalLocation(Player player, String name) {
        super(player, name);

    }

    @Override
    public
    boolean onLocation() {
        System.out.println("You are on Safe House! \n"
        + "health renewed!");
        return true;
    }
    
}
