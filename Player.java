
package dragontreasure;
import java.util.Scanner;

//då den också har health och attackdamage så gjorde vi subklass av monster istället för repetera samma kod
public class Player extends Monster {
    
    public Player(int health, int attackDamage) {
        
        super(health, attackDamage);
    }
    
     public static void PlayerName(){ // metod för att samla spelarens namn och skriva ut ett välkomst meddelande
         Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name:  ");
            String player = input.next();
            System.out.println();
            System.out.println("Welcome " + player + "! To the DragonTreasure game");
            
}
}
