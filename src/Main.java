import Prog1Tools.IOTools;

public class Main {

	public static void main(String[] args) {
		
		//String nutzer, passwort;
		
		// Treiber Test 
		DBZugriff dbzugriff = new DBZugriff();
		
		// Verbindungstest
		dbzugriff.openConnection("admin", "123456"); 
		dbzugriff.closeConnection("admin");
		
		// SELECT Abfrage - ein soll kommentiert werden
		dbzugriff.anfrageDBZugriff("admin", "123456", "SELECT * FROM künstler;");
		//dbzugriff.anfrageDBZugriff("admin", "123456", "SELECT * FROM bilder;");
		
		// Manipulationen
		// INSERT INTO - ein neues Bild
		dbzugriff.manipulationDBZugriff("admin", "123456", "INSERT INTO bilder(Bild_Nr,Titel,Künstler,Breite,Höhe,Preis) VALUES(6,\"Sommer\", 2, 30, 30, 65);");
		// UPDATE - ein neuer Preis furs Bild "Sommer" 
		dbzugriff.manipulationDBZugriff("admin", "123456", "UPDATE bilder SET Preis = 75 WHERE Titel = \"Sommer\"");
		// DELETE das Bild mit Bild_Nr 6
		dbzugriff.manipulationDBZugriff("admin", "123456", "DELETE FROM bilder WHERE Bild_Nr = 6");
		// UPDATE alle Preise auf 10 Euro vermindern
		System.out.println(dbzugriff.manipulationDBZugriff("admin", "123456", "UPDATE bilder SET Preis = Preis - 10"));
		
		// Testen Methode equalsBilder(). Erzeugen 1 Künstler und 2 Bilder.
		Kuenstler froh = new Kuenstler(3);
		
		Bilder bild_1 = new Bilder(2, "Farborgie", froh, 100, 100, 990);
		Bilder bild_2 = new Bilder(5, "Am Spielplatz", froh, 90, 90, 460);
		
		bild_1.equalsBilder(bild_2);
	}

}
