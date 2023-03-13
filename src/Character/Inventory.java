package Character;

import Location.Weapon;
import Location.Armor;

public class Inventory{

    // private boolean water;
    // private boolean food;
    // private boolean fireWood;
    // private String weaponName;
    // private int weaponDamage;
    // private int armorDefence;
    private Weapon weapon;
    private Armor armor;

    public Inventory(){
        this.weapon = new Weapon("Fist", 0, 0, 0);
        this.armor = new Armor("body", 0, 0, 0);
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

}
