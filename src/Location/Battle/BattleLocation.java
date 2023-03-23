package Location.Battle;

import java.util.Random;

import Character.Player;
import Location.Location;
import Location.Battle.Obstacles.Obstacle;

public abstract class BattleLocation extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private static int tempObsNumber;
    private boolean isRun = false;



    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }
    

    public Obstacle getObstacle() {
        return obstacle;
    }


    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }


    public String getAward() {
        return award;
    }


    public void setAward(String award) {
        this.award = award;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }


    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber(){
        
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }


    @Override
    public boolean onLocation() throws InterruptedException {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are on " + this.getName() + " | Becareful! There are " + obsNumber 
        + " " + getObstacle().getName() + " here!\n");
        

        System.out.print("Would you like to (F)ight or (R)un : ");
        String selectedAction = sc.nextLine().toUpperCase();

        if(selectedAction.equals("F")){
            //FIGHT
            if(combat(obsNumber)){
                if(tempObsNumber == 0){
                    System.out.println("You Killed All Obstacles!");
                }
                else{
                    System.out.println("Running Back!");
                }
                return true;
            }
           
        }
        else{
            System.out.println("Running Back!");
            return true;
        }


        if(this.getPlayer().getHealth() == 0){
            System.out.println("\nYou Are Dead!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) throws InterruptedException{

        tempObsNumber = obsNumber;
        printStats();
        for (int i = 1; i <= obsNumber; i++) {
            
            while((this.getPlayer().getHealth() > 0) && (this.getObstacle().getHealth() > 0)){
                fight(tempObsNumber);

                if(isRun){
                    return true;
                }
                 
            }   
        }
        return false;
    }


    private void fight(int tempObsNum) throws InterruptedException{
        System.out.print("(H)it or (R)un : ");
        String input = sc.nextLine().toUpperCase();

        System.out.println("Obstacle Left : " + tempObsNum);

        if(input.equals("H")){
            System.out.println("\tYou hit " + this.getPlayer().getTotalDamage() + "!");
            
            if(obstacle.getHealth() - this.getPlayer().getTotalDamage() < 0){
                this.getObstacle().setHealth(0);
                
            }
            else{
                this.getObstacle().setHealth(obstacle.getHealth() - this.getPlayer().getTotalDamage());
                
            }
            afterHit();
            

            if(this.getObstacle().getHealth() > 0){
                System.out.println("\n \tObstacle hit you!");
                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getArmor().getDodge();
                
                if(obstacleDamage < 0){
                    obstacleDamage = 0;
                }
                if(this.getPlayer().getHealth() - obstacleDamage < 0){
                    this.getPlayer().setHealth(0);
                }
                else{
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                }
                afterHit();
            }
            else{
                System.out.println("You Killed the Obstacle! | Reward Added to the Inventory!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                tempObsNumber--;
                if(tempObsNumber > 0){
                    this.getObstacle().setHealthToDefault();
                }
               
            }
        }
        else{
            isRun = true;
            
        }
        
    }  

    private void printStats(){
        getPlayer().printInfo();
        getObstacle().printInfo();
     }  

    private void afterHit() throws InterruptedException{
        System.out.println("\tYour Health : " + this.getPlayer().getHealth());
        System.out.println("\t" + this.getObstacle().getName() + "s Health : " + this.getObstacle().getHealth()); 
        Thread.sleep(1500);    

    }
        
}
