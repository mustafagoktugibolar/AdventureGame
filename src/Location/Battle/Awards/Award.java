package Location.Battle.Awards;

//import java.util.ArrayList;

public class Award {
    private String name;
    private boolean hasAward = false;

    public Award(String name, boolean hasAward) {
        this.name = name;
        this.hasAward = hasAward;   
    }

    

    public Award(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getHasAward() {
        return hasAward;
    }
    public void setHasAward(boolean hasAward) {
        this.hasAward = hasAward;
    }

  
    // public ArrayList<String> printAwards(){
    //     ArrayList<String> awardList = new ArrayList<String>();

    //     for (int i = 0; i < 3; i++) {
    //         awardList.add(getInventoryName());
    //     }
        
    //     return awardList;
        
    // }

    

    
}
