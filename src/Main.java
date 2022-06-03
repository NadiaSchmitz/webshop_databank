import Prog1Tools.IOTools;

public class Main {

	public static void main(String[] args) {
		
		//String nutzer, passwort;
		
		// Treiber Test 
		DBZugriff dbzugriff = new DBZugriff();
		
		// Verbindungstest
		
		dbzugriff.openConnection("admin", "123456"); 

		dbzugriff.closeConnection("admin");
		
		
		//DBZugriff abfrage_1 = new DBZugriff("admin", "123456", "SELECT * FROM kunde WHERE kunde.Nachname = 'Maler';");
		//DBZugriff abfrage_2 = new DBZugriff("admin", "123456", "SELECT * FROM künstlerinnen;");

		//dbzugriff.anfrageDBZugriff("admin", "123456", "SELECT * FROM bilder;");
		//dbzugriff.anfrageDBZugriff("admin", "123456", "SELECT * FROM künstler;");
		
		dbzugriff.manipulationDBZugriff("admin", "123456", "INSERT INTO bilder(Bild_Nr,Titel,Künstler,Breite,Höhe,Preis) VALUES(6,\"Sommer\", 2, 30, 30, 65);");
		dbzugriff.manipulationDBZugriff("admin", "123456", "UPDATE bilder SET Preis = 75 WHERE Titel = \"Sommer\"");
		dbzugriff.manipulationDBZugriff("admin", "123456", "DELETE FROM bilder WHERE Bild_Nr = 6");
		
		System.out.println(dbzugriff.manipulationDBZugriff("admin", "123456", "UPDATE bilder SET Preis = Preis - 10"));
		
		// Testen Methode equalsBilder(). Erzeugen 1 Künstler und 2 Bilder.
		Kuenstler froh = new Kuenstler(3);
		
		Bilder bild_1 = new Bilder(2, "Farborgie", froh, 100, 100, 990);
		Bilder bild_2 = new Bilder(5, "Am Spielplatz", froh, 90, 90, 460);
		
		bild_1.equalsBilder(bild_2);
	}

}
