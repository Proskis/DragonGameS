
package dragontreasure;

public class Monster {
    
    private int health;
    private int attackDamage;
    
    //konstruktor
    
    public Monster(int health, int attackDamage) {
        this.health = health;
        this.attackDamage = attackDamage;
    }
    
    public static void displayInfo(){
        System.out.println("\nAn angry monster is in the room and attacks you! ");
    }
    
    // getter och setter för health
    
    public int getHealth(){
        return health;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    // getter och setter för attackDamage
    
    public int getAttackDamage(){
        return attackDamage;
    }
    
    public void setAttackdamage(int attackDamage){
        this.attackDamage = attackDamage;
    }
    
}
