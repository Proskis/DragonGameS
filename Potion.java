
package dragontreasure;

    //Subklassen Potion 
  class Potion extends Item{
    private int Healing;
    
    //Konstruktor för att hämta namn, beskrivning, bild på förmeålet och healing
    public Potion(String name, String description,String itemPicture, int Healing){
        
        super(name, description, itemPicture); // Anropar superklassen 'Item's konstruktor
        this.Healing = Healing;
    }
    
    // Getter och Setter för Healing
    public int getHealing(){
        return Healing;
    }
    
    public void setHealing(int Healing){
        this.Healing = Healing;
    }
// Metod för att skapa ett nytt objekt Potion och skriva ut objektet
 public static void getPotion(){
        Item potion = new Potion("Health Potion","A potion, when consumed heals the player "," \n" +
                "==================\n"+
                "||    ______    ||\n"+ 
                "||   /      \\   ||\n"+
                "||  /~~~~~~~~\\  ||\n"+
                "||  \\__    __/  ||\n"+
                "||   _/    \\_   ||\n"+
                "||  /________\\  ||\n"+
                "||  | Health |  ||\n"+
                "||  | Potion |  ||\n"+ 
                "||  \\________/  ||\n"+
                "||   \\______/   ||\n"+
                "=================="
        ,80);
        
                    
        
                System.out.println(potion);
 }
    //överskriden metod för att beskriva objektet
    @Override
    public String toString(){
         return "You found a " + name + "! " + description +  Healing + " HP" + itemPicture;
    }
  }
