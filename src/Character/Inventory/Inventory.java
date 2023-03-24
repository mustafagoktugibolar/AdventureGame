package Character.Inventory;

import Location.Battle.Awards.Award;

public class Inventory{

    private Weapon weapon;
    private Armor armor;
    private Award award;

    public Inventory(){
        this.weapon = new Weapon("Fist", -1, 0, 0);
        this.armor = new Armor("none", -1, 0, 0);
        this.award = new Award("None");
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

     

}
