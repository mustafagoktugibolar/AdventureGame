package Character;

public class Inventory{

    private boolean water;
    private boolean food;
    private boolean fireWood;
    private String weaponName;
    private int weaponDamage;
    private int armorDefence;

    
    public boolean isWater() {
        return water;
    }
    public void setWater(boolean water) {
        this.water = water;
    }
    public boolean isFood() {
        return food;
    }
    public void setFood(boolean food) {
        this.food = food;
    }
    public boolean isFireWood() {
        return fireWood;
    }
    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }
    public String getWeaponName() {
        return weaponName;
    }
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
    public int getWeaponDamage() {
        return weaponDamage;
    }
    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
    public int getArmorDefence() {
        return armorDefence;
    }
    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    
    
}
