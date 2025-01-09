DragonTreasure (Grupp nr 31)
Det här projektet har blivt skapat för kursen "Programutveckling med java" (D0019N) Eximinationsuppgift del 2.

DragonTreasure är ett spel där spelarren kan navigera sig i en dungeon emellan olika rum. Spelaren kan navigera sig med hjälp av väderstrecken norr, söder, väst, öst. Meningen med spelet är att navigera sig till kistan fylld med skatt och sedan navigera sig ut ur dungeonen till frihet. Detta görs samtidigt som det finns ett monster att besegra och en drake. Det finns även föremål som; vapen nyckel och potion, till hjälp för att klara av spelet. Spelet avslutas när spelaren har kommit ut ur dungeonen eller om spelaren vill avsluta när somhelst går det genom att skriva q (quit). Huvudfunktionen i spelet fungerar med en switch sats i en While sats som gör att navigerigen loopas tills man klarar spelet. Rummen och dörrar är sparad i varsinn 2D-array. Draken är en subklass till Monster och Potion, Weapon, Key är subklasser till classen Item.

Spelet är uppbyggd på 5 olika filer (Dragontreasure.java, Dungeon.java, Player.java, Room.java, & Door.java) 
Dragontreasure.java har main-metoden och används för att tillkalla metoderna som startar spelet och avslutar spelet. 
Dungeon.java skapar 2D-arraysen för rummen och dörrarna. Den innehåller den största delen av programmet och hanterar navigeringen och utskrifter av beskrivningarna.
Player.java har en metod för att samla spelarens namn och skriva ut ett välkomst meddelande, detta görs med en scanner.
Room.java använder getter metod för att samla rum namn + rums beskrivningar.
Door.java använder getter metod för att samla dörr position + ifall en dörr är upplåst eller inte.

Hur man kan spela:
Spelet kan köras direkt via IDE, såsom NetBeans, IntelliJ eller Eclipse. Genom att ladda ner alla filer och starta main metoden i filen Dragontreasure.java

