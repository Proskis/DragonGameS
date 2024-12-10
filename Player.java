
package dragontreasure;
import java.util.Scanner;

public class Player {
    
     public static void PlayerName(){
         Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name:  ");
            String player = input.next();
            System.out.println();
            System.out.println("Welcome " + player + "! To the DragonTreasure game");
}
}
