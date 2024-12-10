
package dragontreasure;

public class Room {
    String name;
    String description;
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    //getter rum namnen 
    public String getName() {
        return name;
    }
    
    //getter för beskrivning av rum
    public String getDescription() {
        return description;
    }
    
}

