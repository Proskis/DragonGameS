
package dragontreasure;
   
//Subklassen 'Key' till superklassen 'Item'
 class Key extends Item{
 
    //Konstruktor för att hämta namn, beskrivning och bild för nyckeln
    public Key(String name, String description,String itemPicture){
        
        super(name, description, itemPicture); // Anropar superklassen 'Item's konstruktor
    }
// Metod för att göra ett föremål 'key' och skriva ut objektet
 public static void getKey(){
        Item Key = new Key("Key","A key of somesort, who knows what it unlocks... "," \n" +
                "===========================================\n" +
                "||                                       ||  \n" +
                "||  8 8 8 8                     ,ooo.    ||  \n" +
                "||  8a8 8a8                    oP   ?b   ||  \n" +
                "|| d888a888zzzzzzzzzzzzzzzzzzzz8     8b  ||  \n" +
                "||  `\"\"^\"\"'                    ?o___oP'  ||  \n" + 
                "||                                       ||  \n" +
                "===========================================\n" 

        );
                System.out.println(Key);
 }
    //överskriden metod för att beskriva objektet
    @Override
    public String toString(){
         return "You found a " + name + "! " + description   + itemPicture;
    }
  }
