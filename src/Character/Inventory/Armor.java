package Character.Inventory;

public class Armor {
    private String name;
    private int id;
    private int dodge;
    private int price;

    
    public Armor(String name, int id, int dodge, int price) {
        this.name = name;
        this.id = id;
        this.dodge = dodge;
        this.price = price;
    }

    //Creating Armor
    public static Armor[] armor(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Light", 1, 1, 15);
        armorList[1] = new Armor("Normal", 2, 3, 25);
        armorList[2] = new Armor("Heavy", 3, 5, 40);
        return armorList;
    }

    public static Armor getArmorByID(int id){
        for (Armor a : armor()) {
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDodge() {
        return dodge;
    }
    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    
}
