package dragontreasure;

import java.util.Scanner;


public class Dungeon {
    
    //metod för att beskriva vart man gick och skriva ut rums beskrivning samt dörr status
    private void roomDoorStatus(String direction) {
    System.out.println("\nYou went " + direction + "\n");
    System.out.println(dungeon[playerX][playerY].getDescription());
    Player player = new Player(20,1);
   
        if (playerX == 1 && playerY == 2 && PotionPickedup == false){
                        Potion.getPotion();
                         System.out.println("Pickup [p] the Potion to add it to your inventory");
                        roomEVisit = true;
                        
        }
        if (playerX == 2 && playerY == 0 && SwordPickedup == false ){
                       Weapon.getSword(); 
                        System.out.println("Pickup [p] the Sword to add it to your inventory");
                        roomCVisit = true;
                         
        }
        if (playerX == 2 && playerY == 2 && KeyPickedup == false){
                       Key.getKey();
                       System.out.println("Pickup [p] the key to add it to your inventory");
                        roomBVisit = true;
                          
        }
        if (playerX == 0 && playerY == 0 && dragonDefeat == true){
                       Treasure.getTreasure();
                        TreasurePickedup = true;  
       
        }
         if(playerX == 1 && playerY == 2 && KeyPickedup == false){
           System.out.println("\nThe " + doorLock[1][2].getPosition()
                + " door appears to be locked");
        }
         if (playerX == 1 && playerY == 2 && KeyPickedup == true) {
            System.out.println("\nThe " + doorLock[1][2].getPosition()
                + " door appears to be locked\n" +
                    "Use [u] to use the key and unlock the door");
        
        }
        if(playerX == 1 && playerY == 0 && roomDVisit == false){
            Monster monster = new Monster(8, 1);  // skapar ett monster
            monster.displayInfo();
            Room.doBattle(player, monster);
            roomDVisit = true;
            monsterDefeat = true;
            
        }
        
        if(playerX == 0 && playerY == 2 && roomFVisit == false){
            Dragon dragon = new Dragon(18, 2);  // Skapa en drake
            dragon.displayInfo();
            Room.doBattle(player, dragon);
            roomFVisit = true;
            dragonDefeat = true;
        }
        }
        
      
    //ger variabel till array, spelaren och dörrarna
    private Room[][] dungeon;
    private int playerX;
    private int playerY;

    
    private Door[][] doorLock;
    private int doorX;
    private int doorY;
    
    private boolean roomAVisit;
    private boolean roomBVisit;
    private boolean roomCVisit;
    private boolean roomDVisit;
    private boolean roomEVisit;
    private boolean roomFVisit; 
    
    private boolean TreasurePickedup;
    private boolean KeyPickedup;
    private boolean SwordPickedup; 
    private boolean PotionPickedup;
    private boolean UsedPotion;
    
    private boolean monsterDefeat;
    private boolean dragonDefeat;
    
   private boolean doorLocked;
    // Konstruktor
    public Dungeon() {
        // Initialisera dungeonen
        dungeon = Room.getAllRooms(); // Hämtar alla rummen från Room-klassen
        doorLock = Door.getAllDoors();// Hämtar alla dörrar från Door-klassen
        
        //spelarens starposition, rum A
        playerX = 2;
        playerY = 1;
        
        // Dörr startposition, rum A. i Sync med spelarens position
        doorX = playerX;
        doorY = playerY;
        
        SwordPickedup = false; 
        TreasurePickedup = false;
        KeyPickedup = false;
        PotionPickedup = false;
        UsedPotion = false;
        
        monsterDefeat = false;
        dragonDefeat = false;
        
        roomAVisit = false;
        roomBVisit = false;
        roomCVisit = false;
        roomDVisit = false;
        roomEVisit = false;
        roomFVisit = false;
        
        doorLocked = true;
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
        
           System.out.println(dungeon[playerX][playerY].getDescription()); 
 
        //loopar spelet så man kan fortsätta gå tills man hamnar på exit 
        while (true) {
            System.out.print("\nWhat's your next action? ");
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
                        if(playerX == 1 && playerY == 2 && KeyPickedup == true && doorLocked == true){
                       System.out.println("\nThe door going north seems to be locked\n" +
                                 "Maybe a key could open it.");
                       
                        break;
                     }
                        if(playerX == 1 && playerY == 2 && KeyPickedup == true && doorLocked == true){
                        playerX--;
                        doorLock[1][2].getLocked();
                        roomDoorStatus("North"); //hämtar metod
                        break;
                    }
                        if(playerX == 1 && playerY == 2 && KeyPickedup == false && doorLocked == true){
                        doorLock[1][2].getLocked();
                        
                         System.out.println("\nThe door going north seems to be locked\n" +
                                 "Maybe a key could open it.");
                        
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
                
                    // plockar upp Item ifall spelaren är i rätt rum och inte redan har plockat upp Item.
                case "p": 
                    if(playerX == 2 && playerY == 0 && SwordPickedup == false){
                      System.out.println("You picked up a Sword" );
                    SwordPickedup = true;
                    
                          break;
                    }
                    if(playerX == 1 && playerY == 2 && PotionPickedup == false && UsedPotion == false){
                        System.out.println("You picked up a Potion");
                    PotionPickedup = true;     
                          break;
                     }
                    if(playerX == 2 && playerY == 2 && KeyPickedup == false){
                        System.out.println("You picked up a Key");
                    KeyPickedup = true;     
                          break;
                    }
                  else
                        System.out.println("\nThere is nothing to pickup here.");
                    break;
                    
                   // Använder föremålet HealthPotion ifall spelaren har plockat upp den   
                case "hp":
                     if (PotionPickedup == true && UsedPotion == false){
                         System.out.println("Succes");
                         // PLAYER HP + 80...
                         UsedPotion = true;
                         PotionPickedup = false;
                         
                         break;
                     }
                     if (PotionPickedup == false){
                         System.out.println("\nYou cant use a Health Potion because you dont have one in your inventory.");
                         break;
                     
                     }
                     case "q": //hämtar metod för att avsluta spelet
                        System.out.println("\nYou quit the game."); 
                        endGame();
            
                case "u":
                    if(playerX == 1 && playerY == 2 && KeyPickedup == true && doorLocked == true){
                        
                        doorLocked = false;
                        System.out.println("\nYou used a Key to unlock the door");
                        break;
                    }
                    else
                        System.out.println("\nThere is nothing to be use here");
                        break;
                    // skriver ut att använda korrekt bokstäver
                default:
                    System.out.println("\nError. Use [n], [w], [e], [s] to move.\n"+
                            "Or [p], [hp], [u] to perform a task\n"+
                            "Or [q] to quit the game"); 
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
