package dragontreasure;

import java.util.Scanner;


public class Dungeon {
    
    //metod för att beskriva vart man gick och skriva ut rums beskrivning samt dörr status
    private void roomDoorStatus(String direction) {
    System.out.println("\nYou went " + direction + "\n");
    System.out.println(dungeon[playerX][playerY].getDescription());
    if(!dungeon[playerX][playerY].equals(dungeon[0][0])){
        System.out.println("\nThe " + doorLock[playerX][playerY].getPosition() +
            " door is unlocked, " + doorLock[playerX][playerY].getLocked());
    }
    
}

    //ger variabel till array, spelaren och dörrarna
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
        
        dungeon = Room.getAllRooms(); // Hämtar alla rummen från Room-klassen
        playerX = 2; // Startposition
        playerY = 1;
        
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

        //hämtar player metoden
        Player.PlayerName();
        //skriver ut spelinstruktioner och start  beskrivningen
        System.out.println("\nUse n (north), w (west), e (east), s (south) to move.");
        System.out.println("\nUse q to quit the game at anytime");
        System.out.println("\nYou enter the dungeon!\n");
        System.out.println(dungeon[playerX][playerY].getDescription() + "\nThe " + doorLock[doorX][doorY].getPosition() 
                + " door is unlocked, " + doorLock[doorX][doorY].getLocked());
        
        //loopar spelet så man kan fortsätta gå tills man hamnar på exit 
        while (true) {
            System.out.print("\nWhere do you want to go? ");
            String direction = scanner.nextLine().toLowerCase();

            // beroende på vilken vägriktning man går så förflyttas man således
            // kan man inte gå ut ett håll så stannar man kvar och meddelas att man inte kan gå åt det hållet
            switch (direction) {
                
                //förlfyttar spelaren uppåt (norr) så länge man inte är högst upp
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
                    
                    //förflyttar spelaren ner (syd) så länge man inte är längst ner
                case "s":
                    if (playerX < dungeon.length - 1){
                        playerX++;
                        roomDoorStatus("South"); //hämtar metod
                    } 
                    else System.out.println("\nYou cant go south.");
                    break;
                    
                    // förflyttar spelaren vänster (väst) så länge man inte är längst åt vänster
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
                    
                    // förflyttar spelaren höger (öst) så länge man inte är längst åt höger
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
                    
                    case "q": //hämtar metod för att avsluta spelet
                        System.out.println("\nYou quit the game."); 
                        endGame();
                        
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
     public void endGame(){ // Metod för att avsluta spelet
       
        System.out.println("The game has ended. Thanks for playing");
       
        System.exit(0); // Avslutar spelet
}
}
