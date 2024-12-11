
package dragontreasure;


public class Door {
    
     String position;
     boolean unLocked; 
     
     
    public Door(String position, boolean unLocked){
        
        this.position = position;
       
    }
    //getter dörr position
    public String getPosition() {
        return position;
    }
    //getter för ifall dörr är låst eller upplåst
    public boolean getLocked() {
        unLocked = true;
        return unLocked;
    }
}
