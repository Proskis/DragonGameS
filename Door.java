
package dragontreasure;


public class Door {
    
     String position;
     boolean unLocked; 
     
     
    public Door(String position, boolean unLocked){
        
        this.position = position;
       
    }
    public String getPosition() {
        return position;
    }
    public boolean getLocked() {
        unLocked = true;
        return unLocked;
    }
}
