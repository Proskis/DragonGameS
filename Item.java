
package dragontreasure;

//SuperKlass 'Item' för alla föremål i spelet
public class Item {
    public String name;
    public String description;
    public String itemPicture;
    
    //Konstruktor för att hämta namn, beskrivning och en bild på föremålet
    public Item(String name, String description, String itemPicture) {
        this.name = name;
        this.description = description;
        this.itemPicture = itemPicture;
        
    }
    //getter och setter för name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //getter och setter för item beskrivning
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;

    }
     //getter för och setter för itemPicture
    public String getitemPicture() {
        return itemPicture;
    }
    public void setitemPicture(String itemPicture){
        this.itemPicture = itemPicture;

    }
// Överskriden metod för att beskriva objektet
    @Override
    public String toString() {
        return "You found a " + name + "! " + description + itemPicture;
    }
} 
