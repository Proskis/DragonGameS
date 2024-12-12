package dragontreasure;

import java.util.Scanner;


public class Dungeon {
    
    //metod för att beskriva vart man gick och skriva ut rums beskrivning samt dörr status
    private void roomDoorStatus(String direction) {
    System.out.println("\nYou went " + direction + "\n");
    System.out.println(dungeon[playerX][playerY].getDescription());
    System.out.println("\nThe " + doorLock[playerX][playerY].getPosition() +
            " door is unlocked, " + doorLock[playerX][playerY].getLocked());
}
    
    private Room[][] dungeon;
    private int playerX;
    private int playerY;

    
    private Door[][] doorLock;
    private int doorX;
    private int doorY;
    // Konstruktor
    
    public Dungeon() {
        // Initialisera dungeonen
        
        
      //hämtar dörrar och kollar om dem är låst eller inte
        doorLock = new Door[][]{
            
            //rad 0 med kolumner
            { 
                new Door("south", true),
                
                null,
                
                new Door("south", true)
                
                
            },
            
            //rad 1 med kolumner
            {
                
                new Door("north, east and south",true),
                
                null,

                new Door("north, south and west", true)

                
            },
            
            //rad 2 med kolumner
            {
                new Door("north and east", true),
                
                new Door("west and east",true),
                
                new Door("north and west", true)
           
            }
        };
        
         //hämtar namn och beskrivning av "Room"
        dungeon = new Room[][]{
            
            //rad 0 med kolumner
                {
                new Room("Exit", "=======================================================\n"
                         + "|| You escape the dungeon and make it outside.       || \n"
                         + "|| You're free and can enjoy a breath of fresh air   || \n"
                         + "======================================================="),
        
                null,
        
                new Room("Room F", "===============================================================================================\n"+ 
                           "|| You open the door and instantly you see what the snoring sound was coming from.           ||\n"+
                           "|| A beast of a dragon sleeping! The dragon is huge and takes up almost half the room space. ||\n"+
                           "|| Right next to the sleeping dragon you spot a chest filled with treasure.                  ||\n"+
                           "|| To get to the treasure you have to move cautiously to not wake the dragon up.             ||\n"+
                           "|| There appears to be a padlock with a 3 digit code on the treasure chest.                  ||\n"+
                           "|| You enter the code '694' and collect the treasure!                                        ||\n"+
                           "||                  _.--.                                                                    ||\n"+
                           "||              _.-'_:-'||                                                                   ||\n"+
                           "||          _.-'_.-::::'||                                                                   ||\n"+
                           "||     _.-:'_.-::::::'  ||                                                                   ||\n"+
                           "||   .'`-.-:::::::'     ||                                                                   ||\n"+
                           "||  /.'`;|:::::::'      ||_                                                                  ||\n"+
                           "||  ||  ||::::::'      _.;._'-._                                                             ||\n"+
                           "||  ||  ||:::::'   _.-!oo @.!-._'-.                                                          ||\n"+
                           "||  \'. ||:::::.-!() oo @!()@.-'_.||                                                          ||\n"+
                           "||   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||                                                          ||\n"+
                           "||     `>'-.!@%()@'@_%-'_.-o _. |'||                                                         ||\n"+
                           "||      ||-._'-.@.-'_.-' _.-o   |'||                                                         ||\n"+
                           "||      ||=[ '-._.-\\U/.-'    o |'||                                                          ||\n"+
                           "||      || '-.]=|| |'|       o  |'||                                                         ||\n"+
                           "||      ||      || |'|        _ | ';                                                         ||\n"+
                           "||      ||      || |'|    _.-'_.-'                                                           ||\n"+
                           "||      |'-._   || |'|_.-'_.-'                                                               ||\n"+
                           "||      '-._'-.|| |' `_.-'                                                                   ||\n"+
                           "||           '-.||_/.-'                                                                      ||\n"
                         + "|| You can move south [s]                                                                    ||\n"+
                           "===============================================================================================")
                },
                
            //rad 1 med kolumner
                {
                new Room("Room D", "================================================================================================================\n"
                         + "|| As soon as you enter you notice the light peaking through the cracks of a door infront of you, North.      ||\n"
                         + "|| 'Could that be the exit out of here' you think to yourself.                                                ||\n"
                         + "|| You also take notice of the door going East, and the horrid smell that is coming from that direction.      ||\n"
                         + "|| You can move north [n], east [e] or south [s]                                                              ||\n"
                         + "================================================================================================================"),
        
                null, 
        
                new Room("Room E","=========================================================================================================\n" 
                         + "|| As you open the door that horrid smell hits your face and you almost vomit.                         ||\n"
                         + "|| You see the outline of something laying in the corner.                                              ||\n"
                         + "|| As you approach it you see what appears to be a rotting corpse surrounded by spider webs and bugs.  ||\n"
                         + "|| You notice a piece of paper laying next to the corpse. 'Code for the chest is 694' the paper reads. ||\n"
                         + "|| You also notice a loud snoring sound coming from behind a door going North.                         ||\n"
                         + "|| There is also a door going South and the door going back West where you came from.                  ||\n"
                         + "|| You can move north [n], south [s] or west [w]                                                       ||\n"
                         + "=========================================================================================================")
                },
    
            //rad 2 med kolumner
                {
                new Room("Room C", "=====================================================================================\n"
                         + "|| You enter a room that appears to be empty.                                      ||\n"
                         + "|| However, there seems to be some kind of scratching noise coming from the walls. ||\n"
                         + "|| Must be rats you think to yourself.                                             ||\n"
                         + "|| There appears to be a door leading North                                        ||\n"
                         + "|| You can move north [n] or east [e]                                              ||\n"
                         + "====================================================================================="),
        
                new Room("Room A", "======================================================================\n"
                         + "|| It is very dark but you can just barely                          ||\n"
                         + "|| see the outline of a door to your left and a door to your right. ||\n"
                         + "|| You can decide to go through the West door or the East door,     ||\n"
                         + "|| You can move west [w] or east [e]                                ||\n"
                         + "======================================================================"),
        
                new Room("Room B", "==================================================================================================\n"
                         + "|| As you enter the room you vaguely start to smell something horrid.                           ||\n"
                         + "|| The smell is not coming from this room you realize.                                          ||\n"
                         + "|| You look around and notice the room is filled with spider webs everywhere.                   ||\n"
                         + "|| You notice a door going North. You can either take that door or go back where you came from. ||\n"
                         + "|| You can move north [n] or west [w]                                                           ||\n"
                         + "==================================================================================================")
                }
        };
        
        //spelarens starposition, rum A
        playerX = 2;
        playerY = 1;
        
        // Dörr startposition, rum A. i Sync med spelarens position
        doorX = playerX;
        doorY = playerY;
    }
    
    // Startar spelet
    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        Player.PlayerName();
        System.out.println("\nUse n (north), w (west), e (east), s (south) to move.");
        System.out.println("\nYou enter the dungeon!\n");
        System.out.println(dungeon[playerX][playerY].getDescription() + "\nThe " + doorLock[doorX][doorY].getPosition() 
                + " door is unlocked, " + doorLock[doorX][doorY].getLocked());
          
        //loopar spelet så man kan fortsätta gå tills man hamnar på exit 
        while (true) {
            System.out.print("\nWhere do you want to go? ");
            String direction = scanner.nextLine().toLowerCase();

            // beroende på vilken vägriktning man går så förflyttas man således
            switch (direction) {
                
                //förlfyttar spelaren uppåt så länge man inte är högst upp
                case "n":
                    if ((playerX == 2 && playerY == 1)){ //gör så man inte kan gå norr på [2][1] då [1][1] är null
                        System.out.println("\nYou cant go north");
                        break;
                    }
                    if (playerX > 0) {
                        playerX--;
                        roomDoorStatus("North"); //hämtar metod
                    } 
                    else System.out.println("\nYou cant go north.");
                    break;
                    
                    //förflyttar spelaren ner så länge man inte är längst ner
                case "s":
                    if (playerX < dungeon.length - 1){
                        playerX++;
                        roomDoorStatus("South"); //hämtar metod
                    } 
                    else System.out.println("\nYou cant go south.");
                    break;
                    
                    // förflyttar spelaren väst "vänster" så länge man inte är mest åt vänster
                case "w":
                    if (playerX == 1 && playerY == 2) { //hoppar över array [1][1] då den är null
                        playerY = 0;
                        roomDoorStatus("West"); //hämtar metod
                        break;
                    }
                    if (playerX == 0 && playerY ==  2){
                        System.out.println("\nYou cant go West");
                        break;
                    }
                    if (playerY > 0){
                        playerY--;
                        roomDoorStatus("West"); //hämtar metod
                    } 
                    else System.out.println("\nYou cant go west.");
                    break;
                    
                    // förflyttar spelaren öst "höger" så länge man inte är mest åt höger
                case "e":
                    if (playerX == 1 && playerY == 0) { //hoppar över array [1][1] då den är null
                        playerY = 2;
                        roomDoorStatus("East"); //hämtar metod
                        break;
                    }
                    if (playerY < dungeon[playerX].length - 1){
                        playerY++;
                        roomDoorStatus("East"); //hämtar metod
                    } 
                    else System.out.println("\nYou cant go east.");
                    break;
                    
                    // skriver ut att använda korrekt bokstäver
                default:
                    System.out.println("\nError. Use n, w, e, or s."); 
            }
            
            
            //läser av vart i "grid" man är, är rummet = Exit -> break
            if (dungeon[playerX][playerY].getName().equals("Exit")) { 
                break;
            }
        }

        scanner.close(); // stänger scanner
    }
     public void endGame(){
       
        System.out.println("The game has ended. Thanks for playing");
       
        System.exit(0); // Avslutar spelet
}
}
