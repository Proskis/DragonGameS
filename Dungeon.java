
package dragontreasure;

import java.util.Scanner;


public class Dungeon {
    
    private Room[][] dungeon;
    private int playerX;
    private int playerY;

    // Konstruktor
    
    public Dungeon() {
        // Initialisera dungeonen
        //hämtar namn och beskrivning av "Room"
        
        dungeon = new Room[][]{
            
            //rad 0 med kolumner
                {
                new Room("Exit (g)", "put some text here."),
        
                null,
        
                new Room("Room F", "You open the door and instantly you see what the snoring sound was coming from.\n"
                         + "A beast of a dragon sleeping! The dragon is huge and takes up almost half the room space.\n"
                         + "Right next to the sleeping dragon you spot a chest filled with treasure.\n"
                         + "To get to the treasure you have to move cautiously to not wake the dragon up.\n"
                         + "There appears to be a padlock with a 3 digit code on the treasure chest.")
                },
                
            //rad 1 med kolumner
                {
                new Room("Room D", "As soon as you enter you notice the light peaking through the cracks of a door infront of you, North.\n"
                         + "'Could that be the exit out of here' you think to yourself.\n"
                         + "You also take notice of the door going East, and the horrid smell that is coming from that direction.\n"
                         + "Write a 'N' to take the door going North or 'E' to take the door going East"),
        
                null, 
        
                new Room("Room E", "As you open the door that horrid smell hits your face and you almost vomit.\n"
                         + "You see the outline of something laying in the corner.\n"
                         + "As you approach it you see what appears to be a rotting corpse surrounded by spider webs and bugs.\n"
                         + "You notice a piece of paper laying next to the corpse. 'Code for the chest is 694' the paper reads.\n"
                         + "You also notice a loud snoring sound coming from behind a door going North.\n"
                         + "There is also a door going South and the door going back West where you came from.\n"
                         + "Write a 'N' to take the door going North, 'S' to take the door going South, or 'W' to take the door going West.")
                },
    
            //rad 2 med kolumner
                {
                new Room("Room C", "You enter a room that appears to be empty.\n"
                         + "However, there seems to be some kind of scratching noise coming from the walls.\n"
                         + "Must be rats you think to yourself.\n"
                         + "There appears to be a door leading North\n"
                         + "Write a 'N' to take the door going North or 'E' to take the door going East"),
        
                new Room("Room A", "It is very dark but you can just barely\n"
                         + "see the outline of a door to your left and a door to your right.\n"
                         + "You can decide to go through the West door or the East door,\n"
                         + "Write a 'W' to take the West door or 'E' to take the East door"),
        
                new Room("Room B", "As you enter the room you vaguely start to smell something horrid.\n"
                         + "The smell is not coming from this room you realize.\n"
                         + "You look around and notice the room is filled with spider webs everywhere.\n"
                         + "You notice a door going North. You can either take that door or go back where you came from.\n"
                         + "Write a 'N' to take the door going North or 'W' to take the door going West")
                }
        };
        
        //spelarens starposition, rum A
        playerX = 2;
        playerY = 1;
    }
    
    // Startar spelet
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welocme!");
        System.out.println("Use n (north), w (west), e (east), s (south) to move.");
        System.out.println("You start in: " + dungeon[playerX][playerY].getName());
        System.out.println(dungeon[playerX][playerY].getDescription());

       /* while (true) {
            System.out.print("\nWhere do you want to go? ");
            String direction = scanner.nextLine().toLowerCase();

            switch (direction) {
                case "n":
                    if (playerX > 0) playerX--;
                    else System.out.println("You cant go north.");
                    break;
                case "s":
                    if (playerX < dungeon.length - 1) playerX++;
                    else System.out.println("You cant go south.");
                    break;
                case "w":
                    if (playerY > 0) playerY--;
                    else System.out.println("You cant go west.");
                    break;
                case "e":
                    if (playerY < dungeon[playerX].length - 1) playerY++;
                    else System.out.println("You cant go east.");
                    break;
                default:
                    System.out.println("error. use n, w, e, or s.");
            }

            System.out.println("you are now in : " + dungeon[playerX][playerY].getName());
            System.out.println(dungeon[playerX][playerY].getDescription());

            if (dungeon[playerX][playerY].getName().equals("Exit")) {
                System.out.println("You left the dungeon");
                break;
            }
        }*/

        scanner.close();
    }
}
