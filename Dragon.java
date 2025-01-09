
package dragontreasure;

//subklass av Monster
public class Dragon extends Monster {
    
    public Dragon(int health, int attackDamage) {
        
        super(health, attackDamage); //tar health och attackDamage setter/getter från Monster
    }
    
    // lägger ut info och bild i egen metod
    public static void displayInfo(){
        System.out.println("                                       \\/\n" +
"                                       ^`'.\n" +
"                                       ^   `'.\n" +
"             (                         ^      `'.\n" +
"           )  )        \\/              ^         `'.\n" +
"         (   ) @       /^              ^            `'.\n" +
"       )  )) @@  )    /  ^             ^               `'.\n" +
"      ( ( ) )@@      /    ^            ^                  `'.\n" +
"    ))  ( @@ @ )    /      ^           ^                     `'.\n" +
"   ( ( @@@@@(@     /       |\\_/|,      ^                        `'.\n" +
"  )  )@@@(@@@     /      _/~/~/~|C     ^                           `'.\n" +
"((@@@(@@@@@(     /     _(@)~(@)~/\\C    ^                              `'.\n" +
"  ))@@@(@@)@@   /     /~/~/~/~/`\\~`C   ^             __.__               `'.\n" +
"   )@@@@(@@)@@@(     (o~/~o)^,) \\~ \\C  ^          .' -_'-'\"...             `.\n" +
"    ( (@@@)@@@(@@@@@@_~^~^~,-/\\~ \\~ \\C/^        /`-~^,-~-`_~-^`;_           `.\n" +
"      @ )@@@(@@@@@@@   \\^^^/  (`^\\.~^ C^.,  /~^~^~^/_^-_`~-`~-~^\\- /`'-./`'-. ;\n" +
"       (@ (@@@@(@@      `''  (( ~  .` .,~^~^-`-^~`/'^`-~ _`~-`_^-~\\         ^^\n" +
"           @jgs@             (((` ~ .-~-\\ ~`-_~`-/_-`~ `- ~-_- `~`;\n" +
"          /                 /~((((` . ~-~\\` `  ~ |:`-_-~_~`  ~ _`-`;\n" +
"         /                 /~-((((((`.\\-~-\\ ~`-`~^\\- ^_-~ ~` -_~-_`~`;\n" +
"        /                 /-~-/(((((((`\\~-~\\~`^-`~`\\ -~`~\\-^ -_~-_`~-`;\n" +
"       /                 /~-~/  `((((((|-~-|((`.-~.`Y`_,~`\\ `,- ~-_`~-`;\n" +
"      /              ___/-~-/     `\"\"\"\"|~-~|\"''    /~-^ .'    `:~`-_`~-~`;\n" +
"     /         _____/  /~-~/           |-~-|      /-~-~.`      `:~^`-_`^-:\n" +
"    /    _____/        ((((            ((((      (((((`           `:~^-_~-`;\n" +
"    \\___/                                                          `:_^-~`;\n" +
"                                                                    `:~-^`:\n" +
"                                                                  ,`~-~`,`\n" +
"                                                                 ,\"`~.,'\n" +
"                                                               ,\"-`,\"`\n" +
"                                                             ,\"_`,\"\n" +
"                                                            ,\",\"`\n" +
"                                                         ;~-~_~~;\n" +
"                                                          '. ~.'");
        System.out.println("An angry dragon shows up and attack you!");
    }
    
    
    
}
