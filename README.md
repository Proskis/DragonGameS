William Visscher
Vikor Kruukka

DragonTreasure (Grupp nr 31)
Det här projektet har blivt skapat för kursen "Programutveckling med java" (D0019N) Eximinationsuppgift del 2.

DragonTreasure är ett spel där spelaren kan navigera sig i en dungeon mellan olika rum. Spelaren kan navigera sig med hjälp av väderstrecken norr, söder, väst, öst. Meningen med spelet är att navigera sig till kistan fylld med skatt och sedan navigera sig ut ur dungeonen till frihet. Detta görs samtidigt som det finns ett monster att besegra och en drake. Det finns även föremål som; vapen nyckel och potion, till hjälp för att klara av spelet. Spelet avslutas när spelaren har kommit ut ur dungeonen eller om spelaren vill avsluta när somhelst går det genom att skriva q (quit). Huvudfunktionen i spelet fungerar med en switch sats i en While sats som gör att navigerigen loopas tills man klarar spelet. Rummen och dörrar är sparad i varsinn 2D-array. Draken är en subklass till Monster och Potion, Weapon, Key är subklasser till classen Item.

Även om det inte var nödvändigt så gjorde vi Monster en superklass så då om man hade velat lägga till fler olika slags monster så hade man kunna göra det med en subklass lik Dragon.
Vi gjorde även Player en subklass av Monster då Player har två variabler som är likadana så för att undvika repetering av setter och getter kod.

Hur man kan spela:
Spelet kan köras direkt via IDE, såsom NetBeans, IntelliJ eller Eclipse. Genom att ladda ner alla filer och starta main metoden i filen Dragontreasure.java

När man startar spelet skriver man in ett namn till spelaren. 
För att navigera använder man n (north) w (west) w (east) och s (south).
Beroende på vilket rum man är i så kan man bara gå åt vissa håll, vilket uppges när man kommer in i rummet.
Man kan alltid skriva in m (map) för att få en överblick i hur man kan navigera genom spelet.
Man kan också alltid skriva q (quit) för att avsluta programmet.

