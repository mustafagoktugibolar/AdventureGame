package Location.Normal;

import Character.Player;
import Location.Armor;
import Location.Location;
import Location.Weapon;

public class ToolStore extends Location{
    private int selectedArmorID = 0;
    private int selectedWeaponID = 0;
    
    public ToolStore(Player player) {
        super(player, "Tool Store");
        
    }

    @Override
    public boolean onLocation() throws InterruptedException {
        String process = "Processes :\n"
        + "\t1 - Weapons \n"
        + "\t2 - Armors \n"
        + "\t3 - exit";

        System.out.println("Welcome to the Tool Store!");
        boolean showMenu = true;

        while(showMenu){
            System.out.println(process);
            System.out.print("Select Process : ");
            int selectedCase = sc.nextInt();

            while(selectedCase < 1 || selectedCase > 3){
                System.out.print("Unvalid Process! | Try Again \n"+
                "Select Process : ");
                selectedCase = sc.nextInt();   
            }

            switch(selectedCase){
                case 1 :
                    printWeapons();
                    buyWeapon(); 
                    break;
                case 2 :
                    printArmors();
                    buyArmor();
                    break;
                case 3 :
                    System.out.println("Leaving Tool Store...");
                    showMenu = false;
                    Thread.sleep(2000);
                    return false;
            }
        }
        return true;
    }

    //WEAPONS    
    private void printWeapons(){    
        //Print Weapons
        System.out.println("Weapons : ");
        for (Weapon wep : Weapon.weapons()) {
            System.out.println("\t" + wep.getId() + " - " + wep.getName() 
            + "\tDamage : " + wep.getDamage() 
            + "\tPrice : " + wep.getPrice());
        }
        System.out.println("\n \t0 - leave");
    }


    private void buyWeapon(){
        System.out.print("Select Weapon : ");
        selectedWeaponID = sc.nextInt();

        //Checking Input
        while(selectedWeaponID < 0 || selectedWeaponID > Weapon.weapons().length){
            System.out.print("Unvalid Process! | Try Again \n"+
            "Select Weapon : ");
            selectedWeaponID = sc.nextInt();
        }


        //Buying Process
        if(selectedWeaponID != 0){
            Weapon weapon = Weapon.getWeaponByID(selectedWeaponID);
            if(weapon != null){
                if(weapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("insufficient balance | Current Balance : " 
                    + this.getPlayer().getMoney());
                }
                else{
                    //BALANCE UPDATED
                    int balance = this.getPlayer().getMoney() - weapon.getPrice();
                    this.getPlayer().setMoney(balance);

                    System.out.println("Previous Weapon : " 
                    + this.getPlayer().getInventory().getWeapon().getName());

                    //WEAPON ADDEN TO THE INVENTORY
                    this.getPlayer().getInventory().setWeapon(weapon);
                    System.out.println("You Purchased " + weapon.getName() +"!\n"
                    + "New Balance : " + this.getPlayer().getMoney());
                }
            }
        }
    }


    //ARMORS    
    private void printArmors(){
        //Print Armors
        System.out.println("Armors : ");
        for (Armor wep : Armor.armor()) {
            System.out.println("\t" + wep.getId() + " - " + wep.getName() 
            + "\tDodge : " + wep.getDodge() 
            + "\tPrice : " + wep.getPrice());
        }
        System.out.println("\t0 - leave");
    }


    private void buyArmor(){
        System.out.print("Select Armor : ");
        selectedArmorID = sc.nextInt();

        //Checking Input
        while(selectedArmorID < 0 || selectedArmorID > Armor.armor().length){
            System.out.print("Unvalid Process! | Try Again \n"+
            "Select Weapon : ");
            selectedArmorID = sc.nextInt();
        }   

        //Buying Process
        if(selectedArmorID != 0){
            Armor armor = Armor.getArmorByID(selectedArmorID);
            if(armor != null){
                if(armor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("insufficient balance | Current Balance : " 
                    + this.getPlayer().getMoney());
                }
                else{
                    //BALANCE UPDATED
                    int balance = this.getPlayer().getMoney() - armor.getPrice();
                    this.getPlayer().setMoney(balance);

                    System.out.println("Previous Armor : " 
                    + this.getPlayer().getInventory().getArmor().getName());

                    //ARMOR ADDED TO THE INVENTORY
                    this.getPlayer().getInventory().setArmor(armor);
                    System.out.println("You Purchased " + armor.getName() + "!\n"
                    + "New Balance : " + this.getPlayer().getMoney());
                }
            }
        }   
    }   
}
