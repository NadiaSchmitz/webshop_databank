import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBZugriffBilder extends DBZugriff {
	private Bilder bild;
	private String befehl_bild;
	public static int anzahl;
	public ArrayList<Bilder> bilder_liste;
	
	public DBZugriffBilder() {
		super();
	}
	
	public Bilder getBild() {
		return bild;
	}

	public void setBild(Bilder bild) {
		this.bild = bild;
	}

	public String getBefehl_bild() {
		return befehl_bild;
	}

	public void setBefehl_bild(String befehl_bild) {
		this.befehl_bild = befehl_bild;
	}
	
	// Einen neuen Artikel erfassen
	public String erfasseNeuenArtikel(Bilder bild) {
		befehl_bild = "INSERT INTO bilder(Bild_Nr, Titel, Künstler, Breite, Höhe, Preis) VALUES(" + bild.getBild_Nr() + ", '" + bild.getTitel() + "' , " + bild.getKuenstler().getKuenstler_Nr() + ", " + bild.getBreite() + ", " + bild.getHohe() + ", " + bild.getPreis() +");";
		return befehl_bild;
	}
	
	// Liste der Artikel erstellen
	public void erstelleArtikelListe(String nutzer, String passwort, String befehl) {
		
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			ResultSet my_result = my_statement.executeQuery(befehl);
			
			String result = "";
			anzahl = 0;
			bilder_liste = new ArrayList<Bilder>();
			
			// Ausgabe aus Datenbank - SQL Abfrage
			System.out.println("\nAusgabe aus Datenbank - SQL Abfrage");
			System.out.printf("\n %-15s %-20s %-15s %-15s %-15s %-15s", "Bild_Nr", "Titel", "Künstler_Nr", "Breite", "Höhe", "Preis");
			while (my_result.next()) {
				result = result.concat("\n" + my_result.getInt("Bild_Nr") + "  " 
				+ my_result.getString("Titel") + "  " + my_result.getInt("Künstler") + "  " 
				+ my_result.getInt("Breite") + "  " + my_result.getInt("Höhe") + "  " 
				+ my_result.getDouble("Preis"));
				System.out.printf("\n %-15s %-20s %-15s %-15s %-15s %-15s", 
						my_result.getInt("Bild_Nr"), my_result.getString("Titel"), 
						my_result.getInt("Künstler"), my_result.getInt("Breite"), 
						my_result.getInt("Höhe"), my_result.getDouble("Preis"));
				anzahl++;
				
				Bilder bild = new Bilder(my_result.getInt("Bild_Nr"), my_result.getString("Titel"), 
						my_result.getInt("Breite"), my_result.getInt("Höhe"), my_result.getDouble("Preis"));
				
				bilder_liste.add(bild);
			}
			
			System.out.println();
			System.out.println();
			
			// Ausgabe aus der Liste
			System.out.println("Ausgabe aus der Liste");
			System.out.printf("\n %-15s %-20s %-15s %-15s %-15s", "Bild_Nr", "Titel", "Breite", "Höhe", "Preis");
			for (int i = 0; i < bilder_liste.size(); i++) {
				System.out.printf("\n %-15s %-20s %-15s %-15s %-15s", bilder_liste.get(i).getBild_Nr(), bilder_liste.get(i).getTitel(), bilder_liste.get(i).getBreite(), bilder_liste.get(i).getHohe(), bilder_liste.get(i).getPreis());
			}
			
			System.out.println();
			System.out.println();
			
			closeConnection(nutzer);	
		}
		catch(Exception e) {
			System.out.println("Liste der Bilder. Es ist ein Fehler aufgetreten.");
		}
	}
	
	// Artikel min einer bestimmten Nummer abfragen, ein Objekt machen und speichern
	public void ladeArtikel(String nutzer, String passwort, int bild_nummer) {
		
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			befehl = "SELECT * FROM bilder WHERE Bild_Nr = " + bild_nummer + ";";
			
			ResultSet my_result = my_statement.executeQuery(befehl);
			
			String result = "";
			
			// Ausgabe aus Datenbank - SQL Abfrage
			System.out.println("\nAusgabe aus Datenbank - SQL Abfrage");
			System.out.printf("\n %-15s %-20s %-15s %-15s %-15s %-15s", "Bild_Nr", "Titel", "Künstler_Nr", "Breite", "Höhe", "Preis");
			while (my_result.next()) {
				result = result.concat("\n" + my_result.getInt("Bild_Nr") + "  " 
				+ my_result.getString("Titel") + "  " + my_result.getInt("Künstler") + "  " 
				+ my_result.getInt("Breite") + "  " + my_result.getInt("Höhe") + "  " 
				+ my_result.getDouble("Preis"));
				System.out.printf("\n %-15s %-20s %-15s %-15s %-15s %-15s", 
						my_result.getInt("Bild_Nr"), my_result.getString("Titel"), 
						my_result.getInt("Künstler"), my_result.getInt("Breite"), 
						my_result.getInt("Höhe"), my_result.getDouble("Preis"));
				
				bild = new Bilder(my_result.getInt("Bild_Nr"), my_result.getString("Titel"), 
						my_result.getInt("Breite"), my_result.getInt("Höhe"), my_result.getDouble("Preis"));
			}
			
			System.out.println();
			System.out.println();
			
			// Ausgabe aus dem gespeicherten Objekt
			System.out.println("Ausgabe aus dem Objekt");
			System.out.printf("\n %-15s %-20s %-15s %-15s %-15s", "Bild_Nr", "Titel", "Breite", "Höhe", "Preis");
			System.out.printf("\n %-15s %-20s %-15s %-15s %-15s", bild.getBild_Nr(), bild.getTitel(), bild.getBreite(), bild.getHohe(), bild.getPreis());
			
			
			System.out.println();
			System.out.println();
			
			closeConnection(nutzer);	
		}
		catch(Exception e) {
			System.out.println("Daten des Bildes. Es ist ein Fehler aufgetreten.");
		}
	}
	
	// Überprüft, ob eine Nummer des Artikels schon vergeben wurde
	public boolean istArtNrVergeben(String nutzer, String passwort, int bild_n) {
		boolean is_vergeben = false;
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			befehl = "SELECT Bild_Nr FROM bilder;";
			
			ResultSet my_result = my_statement.executeQuery(befehl);
			
			int result = 0;
			
			while (my_result.next()) {
			
				result = my_result.getInt("Bild_Nr");
				
				if(my_result.getInt("Bild_Nr") == bild_n) {
					is_vergeben = true;
					break;
				}
			}
			
			closeConnection(nutzer);
		}
		catch(Exception e) {
			System.out.println("Suche nach der Bild_Nr. Es ist ein Fehler aufgetreten.");
		}
		
		if (is_vergeben) {
			System.out.println("Die Nummer ist schon bereits vergeben.");
		} else {
			System.out.println("Die Nummer ist nicht vergeben.");
		}
		
		return is_vergeben;
	}
	
	// Ändert einen bestimmten Artikel
	public boolean aendereArtikel(String nutzer, String passwort, Bilder bild) {
		boolean result;
		
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			int bild_Nr = bild.getBild_Nr();
			
			befehl = "UPDATE bilder SET Titel = 'Farbogie New', Breite = 110, Höhe = 110, Preis = 1000.0 WHERE Bild_Nr = " + bild_Nr + ";";
			
			my_statement.executeUpdate(befehl);
			
			result = true;
			System.out.println("Update war erfolgreich.");
			
			closeConnection(nutzer);	
			
		}
		catch(Exception e) {
			result = false;
			System.out.println("Es ist ein Fehler beim Update aufgetreten.");
		}
		return result;
	}
	
	// Löscht einen Artikel mit Bild_Nr = bild_n
	public boolean loescheArtikel(String nutzer, String passwort, int bild_n) {
		boolean result;
		
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			befehl = "DELETE FROM bilder WHERE bilder.Bild_Nr = " + bild_n + ";";
			
			my_statement.executeUpdate(befehl);
			
			result = true;
			System.out.println("Delete war erfolgreich.");
			
			closeConnection(nutzer);	
			
		}
		catch(Exception e) {
			result = false;
			System.out.println("Es ist ein Fehler beim Delete aufgetreten.");
		}
		return result;
	}
}
