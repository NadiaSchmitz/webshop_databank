
public class Main {

	public static void main(String[] args) {
		
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
		// System.out.println(dbzugriff.manipulationDBZugriff("admin", "123456", "UPDATE bilder SET Preis = Preis - 10"));
		
		// Testen Methode equalsBilder(). Erzeugen 1 Künstler und 2 Bilder.
		Kuenstler froh = new Kuenstler(3);
		
		Bilder bild_1 = new Bilder(2, "Farborgie", froh, 100, 100, 990);
		Bilder bild_2 = new Bilder(5, "Am Spielplatz", froh, 90, 90, 460);
		
		bild_1.equalsBilder(bild_2);
		
		// Neues Objekt DBZugriffBilder
		DBZugriffBilder dbzugriff_bilder = new DBZugriffBilder();
		
		// Einen neuen Artikel erfassen mit Klasse DBZugriffBilder
		Bilder bild_fluss = new Bilder(6, "Fluss", froh, 30, 30, 120.0);
		String fluss_befehl = dbzugriff_bilder.erfasseNeuenArtikel(bild_fluss);
		System.out.println("Neues Bild Fluss: " + dbzugriff_bilder.manipulationDBZugriff("admin", "123456", fluss_befehl));
		
		// Neues Bild speichern mit Klasse DBZugriffBilder - falsche Nummer
		Bilder bild_schule = new Bilder(6, "Schule", froh, 120, 70, 235.0);
		String schule_befehl = dbzugriff_bilder.erfasseNeuenArtikel(bild_schule);
		System.out.println("Neues Bild Schule: " + dbzugriff_bilder.manipulationDBZugriff("admin", "123456", schule_befehl));		
		
		// Liste der Artikel erstellen
		dbzugriff_bilder.erstelleArtikelListe("admin", "123456", "SELECT * FROM bilder;");
		
		// Artikel min einer bestimmten Nummer abfragen, ein Objekt machen und speichern
		dbzugriff_bilder.ladeArtikel("admin", "123456", 3);
		
		// Überprüft, ob eine Nummer des Artikels schon vergeben wurde
		System.out.println(dbzugriff_bilder.istArtNrVergeben("admin", "123456", 3));
		System.out.println(dbzugriff_bilder.istArtNrVergeben("admin", "123456", 10));
		
		// Ändert einen bestimmten Artikel
		System.out.println(dbzugriff_bilder.aendereArtikel("admin", "123456", bild_1));
		
		// Löscht einen Artikel mit Bild_Nr = bild_n
		System.out.println(dbzugriff_bilder.loescheArtikel("admin", "123456", 7));
	}

}
