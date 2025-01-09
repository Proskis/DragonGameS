package dragontreasure;

public class Room {
    private String name;
    private String description;

    // Konstruktor för att initiera rummet
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getter för namnet på rummet
    public String getName() {
        return name;
    }

    // Getter för beskrivningen av rummet
    public String getDescription() {
        return description;
    }

    // Statisk metod för att hämta en 2D-array av alla rummen
    public static Room[][] getAllRooms() {
        return new Room[][]{
            {
                new Room("Exit", "=======================================================\n"
                         + "|| You escape the dungeon and make it outside.       || \n"
                         + "|| You're free and can enjoy a breath of fresh air   || \n"
                         + "======================================================="),
                null,
                new Room("Room F", "====================================================================================\n"+ 
                           "|| You open the door and instantly you see what the snoring sound was coming from.||\n"+
                           "|| A beast of a dragon!                                                           ||\n"+
                           "|| Right next to the sleeping dragon you spot a chest filled with treasure.       ||\n"+
                           "|| To get to the treasure you have to move cautiously to not wake the dragon up.  ||\n"+
                           "|| You trip over another corpse and make a loud noise!                            ||\n"+
                           "|| The dragon wakes up and initializes a battle!                                  ||\n"+
                           "===================================================================================="
                        
                )
            },
            {
                new Room("Room D", "================================================================================================================\n"
                         + "|| As soon as you enter you notice the light peaking through the cracks of a door infront of you, North.      ||\n"
                         + "|| 'Could that be the exit out of here' you think to yourself. You hear a deep growl coming from the corner   ||\n"
                         + "|| You also take notice of the door going East, and the horrid smell that is coming from that direction.      ||\n"
                         + "|| You can move north [n], east [e] or south [s]                                                              ||\n"
                         + "================================================================================================================"),
                null,
                new Room("Room E", "=========================================================================================================\n" 
                         + "|| As you open the door that horrid smell hits your face and you almost vomit.                         ||\n"
                         + "|| You see the outline of something laying in the corner.                                              ||\n"
                         + "|| As you approach it you see what appears to be a rotting corpse surrounded by spider webs and bugs.  ||\n"
                         + "|| Next to the corpse you see something that looks like some kind of potion                            ||\n"
                         + "|| You also notice a loud snoring sound coming from behind a door going North.                         ||\n"
                         + "|| There is also a door going South and the door going back West where you came from.                  ||\n"
                         + "|| You can move north [n], south [s] or west [w]                                                       ||\n"
                         + "=========================================================================================================")
            },
            {
                new Room("Room C", "=====================================================================================\n"
                         + "|| You enter a room that appears to be empty expect for the sword on the ground    ||\n"
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
                         + "|| On a hook on the wall you spot a key hanging                                                 ||\n"
                         + "|| You notice a door going North. You can either take that door or go back where you came from. ||\n"
                         + "|| You can move north [n] or west [w]                                                           ||\n"
                         + "==================================================================================================")
            }
        };
    }
    
    public static boolean doBattle(Player player, Monster monster) {
        
        // Loop som körs tills en av parterna har 0 eller lägre i hälsa
        while (player.getPlayerHealth() > 0 && monster.getHealth() > 0) {
            // Spelaren attackerar först
            monster.setHealth(monster.getHealth() - player.getPlayerAttackDamage());
            System.out.println("You attacked the monster and dealt: " + player.getPlayerAttackDamage()+ " damage");
            
            if (monster.getHealth() <= 0) {
                System.out.println("The monster has been defeated! You have: "+ player.getPlayerHealth()+ " HP left");
                return true;
            }

            // Monstret attackerar
            player.setPlayerHealth(player.getPlayerHealth() - monster.getAttackDamage());
            System.out.println("The monster attacked you and dealt: " + monster.getAttackDamage()+" damage");
            
            if (player.getPlayerHealth() <= 0) {
                System.out.println("You have been defeated by the monster!");
                return false;
                   
            }
        }
        return false;
    }
}

    
    
