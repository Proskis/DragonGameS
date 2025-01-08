
package dragontreasure;
import java.util.Scanner;

public class Player {
    
    private int playerHealth;
    private int playerAttackDamage;
    
    //konstruktor
    
    public Player(int playerHealth, int playerAttackDamage) {
        this.playerHealth = 20;
        this.playerAttackDamage = 1;
    }
    
    public int getPlayerHealth(){
        return playerHealth;
    }
    
    public void setPlayerHealth(int playerHealth){
        this.playerHealth = playerHealth;
    }
    
    // getter och setter för attackDamage
    
    public int getPlayerAttackDamage(){
        return playerAttackDamage;
    }
    
    public void setPlayerAttackdamage(int playerAttackDamage){
        this.playerAttackDamage = playerAttackDamage;
    }
    
     public static void PlayerName(){ // metod för att samla spelarens namn och skriva ut ett välkomst meddelande
         Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name:  ");
            String player = input.next();
            System.out.println();
            System.out.println("Welcome " + player + "! To the DragonTreasure game");
            
}
}
