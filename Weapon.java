
package dragontreasure;

//Subklassen Weapon
 class Weapon extends Item{
    private int Damage;
    
    //Konstruktor
    public Weapon(String name, String description,String itemPicture, int Damage){
        
        super(name, description, itemPicture); // Anropar superklassen 'Item's konstruktor
        this.Damage = Damage;
    }
    
    // Getter och Setter för Damage
    public int getDamage(){
        return Damage;
    }
    
    public void setDamage(int Damage){
        this.Damage = Damage;
    }
  // Metod för att skapa ett nytt objekt sword samt skriver ut objektet
 public static void getSword(){
       Item sword = new Weapon("Sword","A Iron sword meant for killing monsters that Deals ",  " \n" +
                "========================================\n" +
                "||  \\%`.                              ||\n" +
                "||   `.%`.                            ||\n" +
                "||     `.%`.                          ||\n" +
                "||       `.%`.                        ||\n" +
                "||         `.%`.                      ||\n" +
                "||          `.%`.    __               ||\n" +
                "||             `.%`.  \\ \\             ||\n" +
                "||               `.%`./_/             ||\n" +
                "||                 `./ /.             ||\n" +
                "||                __/\\/:/;.           ||\n" +
                "||               \\__/  `:/;.          ||\n" +
                "||                       `:/;.,       ||\n" +
                "||                          `:/ ;     ||\n" +
                "||                            `'      ||\n" +
                "========================================\n" 
               , 2);
        
        System.out.println(sword);
    }
// Överskriden metod för att beskriva objektet
    @Override
    public String toString() {
        return "You found a " + name + "! " + description + Damage + " damage" + itemPicture;
    }
      }
