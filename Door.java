package dragontreasure;

public class Door {
     private String position;
     private boolean unLocked; 
     
     
     //metod för att hämta dörrens position (vart den leder) samt ifall dörren är upplåst
    public Door(String position, boolean unLocked){ 
        this.position = position;
        this.unLocked = unLocked;
       
    }
    //getter dörr position
    public String getPosition() {
        return position;
    }
    //getter för ifall dörr är låst eller upplåst
    public boolean getLocked() {
        return unLocked;
    }
    // Statisk metod för att hämta en 2D-array av alla rummen
    public static Door[][] getAllDoors() {
        return new Door[][]{
             { 
                new Door("south", true),
                
                null,
                
                new Door("south", true)
                
                
            },
            
            //rad 1 med kolumner
            {
                
                new Door("north, east and south",true),
                
                null,

                new Door("North", false)

                
            },
            
            //rad 2 med kolumner
            {
                new Door("north and east", true),
                
                new Door("west and east",true),
                
                new Door("north and west", true)
           
            }
        };
    }
}
