
package dragontreasure;


public class Door {
    
     char position;
     boolean locked;
     
     
    public Door(char position, boolean locked){
        
        this.position = position;
       
    }
    public char getPosition() {
        return position;
    }
    public boolean getLocked() {
        return locked;
    }
}
