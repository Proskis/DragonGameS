
package dragontreasure;
import java.util.Scanner;

public class Player {
    
     public static void PlayerName(){ // metod för att sammla spelarens namn och skriva ut ett välkomst meddelande
         Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name:  ");
            String player = input.next();
            System.out.println();
            System.out.println("Welcome " + player + "! To the DragonTreasure game");
}
}
