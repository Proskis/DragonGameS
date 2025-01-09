package dragontreasure;

import java.util.Scanner;


public class Dungeon {
    public int PlayerDamage = 1;
    public int PlayerHealth = 20;
    
    //metod för att beskriva vart man gick och skriva ut rums beskrivning
    private void roomDoorStatus(String direction) {
    System.out.println("\nYou went " + direction + "\n");
    System.out.println(dungeon[playerX][playerY].getDescription());
    Player player = new Player(PlayerHealth,PlayerDamage);

        // If-sats, Om alla krav stämmer så hämtas getPotion metoden och ändrar roomEvisit till true
        if (playerX == 1 && playerY == 2 && PotionPickedup == false && UsedPotion == false){
                        Potion.getPotion();
                         System.out.println("Pickup [p] the Potion to add it to your inventory");
                        roomEVisit = true;
                        
        }
          // If-sats, Om alla krav stämmer så hämtas getSword metoden och ändrar roomCvisit till true
        if (playerX == 2 && playerY == 0 && SwordPickedup == false ){
                       Weapon.getSword(); 
                        System.out.println("Pickup [p] the Sword to add it to your inventory");
                        roomCVisit = true;
                         
        }
        // If-sats, Om alla krav stämmer så hämtas getKey metoden och ändrar roomBvisit till true
        if (playerX == 2 && playerY == 2 && KeyPickedup == false){
                       Key.getKey();
                       System.out.println("Pickup [p] the key to add it to your inventory");
                        roomBVisit = true;
                          
        }
        // If-sats, Om alla krav stämmer så hämtas getTreasure metoden och ändrar TreasurePickedup till true
        if (playerX == 0 && playerY == 0 && dragonDefeat == true){
                       Treasure.getTreasure();
                        TreasurePickedup = true;  
       
        }
        // If-sats, Om alla krav stämmer så skrivs ut att dörren är låst
         if(playerX == 1 && playerY == 2 && KeyPickedup == false){
           System.out.println("\nThe " + doorLock[1][2].getPosition()
                + " door appears to be locked");
        }
        // If-sats, Om alla krav stämmer så skrivs det ut att dörren är låst men kan öppnas med nyckeln
         if (playerX == 1 && playerY == 2 && KeyPickedup == true) {
            System.out.println("\nThe " + doorLock[1][2].getPosition()
                + " door appears to be locked\n" +
                    "Use [u] to use the key and unlock the door");
        
        }
        
        if(playerX == 1 && playerY == 0 && roomDVisit == false){ // Om spelaren är i korrekt rum och inte har varit där tidigare
            Monster monster = new Monster(8, 1);  // skapar ett monster
            monster.displayInfo(); //hämtar monster info
            
            boolean battle = Room.doBattle(player, monster); //sätter battle till samma värde som doBattle
            
            if(!battle){ // om fighten returnerar false (spelaren förlorar) avslutas spelet
               System.out.println("Game over!");
               System.exit(0); 
            }
            //uppdaterar värden på variablerna efter man besökt rummet och vunnit mot monstret
            roomDVisit = true;
            monsterDefeat = true;
            
        }
        
        if(playerX == 0 && playerY == 2 && roomFVisit == false){
            Dragon dragon = new Dragon(18, 2);  // Skapa en drake
            dragon.displayInfo(); //hämtar drake info
            
            boolean battleResult = Room.doBattle(player, dragon);
    
            if (!battleResult) { // om fighten returnerar false (spelaren förlorar) avslutas spelet
              System.out.println("Game over!");
              System.exit(0);
            }
            //uppdaterar värden på variablerna efter man besökt rummet och vunnit mot monstret
            roomFVisit = true;
            dragonDefeat = true;
        }
        }
        
      
    //ger variabel till array, spelaren, dörrarna, rummen och alla items och monsters
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

        //sätter värde på variablerna 
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
        System.out.println("\nUse m (map) to open a map of the dungeon");
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
                        // Skriver ut att man måste använda en nyckel för att gå norr ifall kraven stämmer
                        if(playerX == 1 && playerY == 2 && KeyPickedup == true && doorLocked == true){
                       System.out.println("\nThe door going north seems to be locked\n" +
                                 "Maybe a key could open it.");
                       
                        break;
                     }
                        // Skriver ut att man måste ha en nyckel för att gå norr ifall kraven stämmer
                        if(playerX == 1 && playerY == 2 && KeyPickedup == false && doorLocked == true){
                        doorLock[1][2].getLocked();
                        
                         System.out.println("\nThe door going north seems to be locked\n" +
                                 "Maybe a key could open it.");
                        
                        break;
                        }
                        //Flyttar spelaren Norr 
                    if (playerX > 0) {
                        playerX--;
                        roomDoorStatus("North"); //hämtar metod
                    } 
                    // Om if-satserna ovan inte gäller så skrivs det ut att man inte kan gå norr
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
                
                    
                case "p": // plockar upp Item ifall spelaren är i rätt rum och inte redan har plockat upp Item. 
                    if(playerX == 2 && playerY == 0 && SwordPickedup == false){
                      System.out.println("You picked up a Sword" );
                    SwordPickedup = true; // ändrar variablen till att spelaren har plockat upp svärdet
                    PlayerDamage=2;       // ändrar PlayerDamage till 2 eftersom spelaren nu har svärdet
                          break;
                    }
                    if(playerX == 1 && playerY == 2 && PotionPickedup == false && UsedPotion == false){
                        System.out.println("\nYou picked up a Potion\n" + 
                                "Use [hp] to consume the HealthPotion");
                    PotionPickedup = true;     // ändrar variablen till att spelaren har plockat upp potion
                          break;
                     }
                    if(playerX == 2 && playerY == 2 && KeyPickedup == false){
                        System.out.println("You picked up a Key");
                    KeyPickedup = true;     // ändrar variablen till att spelaren har plockat upp nyckeln
                          break;
                    }
                  else
                        // Om spelaren försöker plocka upp något som inte finns så skrivs det ut ett meddelande
                        System.out.println("\nThere is nothing to pickup here.");
                    break;
                    
                   
                case "hp": // Använder föremålet HealthPotion ifall spelaren har plockat upp den   
                     if (PotionPickedup == true && UsedPotion == false){
                        PlayerHealth = 20; // Ändrar PlayerHealth till max HP
                         UsedPotion = true; // ändrar variablen till att spelaren har använt upp potion
                         PotionPickedup = false; // ändrar variablen till att spelaren inte nå mer har en potion
                         System.out.println("You used a HealthPotion. Current PlayerHealth = " + PlayerHealth);
                         break;
                     }
                     // skriver ut meddelande om spelaren försöker använda en HealthPotion som inte spelaren har plockat upp
                     if (PotionPickedup == false){
                         System.out.println("\nYou cant use a Health Potion because you dont have one in your inventory.");
                         break;
                     
                     }
                     case "q": //hämtar metod för att avsluta spelet
                        System.out.println("\nYou quit the game."); 
                        endGame();
            
                case "u": // Använder nyckeln för att låsa upp dörren
                    if(playerX == 1 && playerY == 2 && KeyPickedup == true && doorLocked == true){
                        
                        doorLocked = false; // ändrar variablen till att dörren är nu öppen (false)
                        System.out.println("\nYou used a Key to unlock the door");
                        break;
                    }
                    else
                        // Ifall det inte finns någont att använda skrivs ett meddelande ut
                        System.out.println("\nThere is nothing to use here");
                        break;
        
                case "m": // Skriver ut en bild på en map av dungeonens layout
                        System.out.println("Map:\n"
                                         + "=================\n"
                                         + "|| Exit    [*] ||\n"
                                         + "||  |       |  ||\n"
                                         + "|| [*]-----[ ] ||\n"
                                         + "||  |       |  ||\n"
                                         + "|| [ ]-[ ]-[ ] ||\n"
                                         + "||      ^      ||\n"
                                         + "||    START    ||\n"
                                         + "=================");
                    break;
                    
                default:// skriver ut att använda korrekt bokstäver
                    System.out.println("\nError. Use [n], [w], [e], [s] to move.\n"+
                            "Or [p], [hp], [u], [m] to perform a task\n"+
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
