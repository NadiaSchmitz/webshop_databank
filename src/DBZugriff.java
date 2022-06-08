import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBZugriff {

	private final String url = "jdbc:mysql://127.0.0.1:3306";
	private String nutzer;
	private String passwort;
	protected String databank = "atelier";
	protected String befehl;
	Connection my_connection;
	private boolean verbindungsstand;
	private String verbindungsstandbericht;
	
	// Konstruktoren
	public DBZugriff() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Treiber erfolgreich geladen." + "\n");
		}
		catch(Exception e) {
			System.out.println("Fehler beim Treiberladen." + "\n");
		}	
	}

	// Getters und Setters
	public String getUrl() {
		return url;
	}
	
	public String getNutzer() {
		return nutzer;
	}

	public void setNutzer(String nutzer) {
		this.nutzer = nutzer;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getDatabank() {
		return databank;
	}

	public void setDatabank(String databank) {
		this.databank = databank;
	}

	public String getBefehl() {
		return befehl;
	}

	public void setBefehl(String befehl) {
		this.befehl = befehl;
	}

	public boolean isVerbindungsstand() {
		return verbindungsstand;
	}

	public void setVerbindungsstand(boolean verbindungsstand) {
		this.verbindungsstand = verbindungsstand;
	}

	public String getVerbindungsstandbericht() {
		return verbindungsstandbericht;
	}

	public void setVerbindungsstandbericht(String verbindungsstandbericht) {
		this.verbindungsstandbericht = verbindungsstandbericht;
	}

	// Methoden
	// OpenConnection - überprüft Nutzer und baut Verbindung auf. 
	// Wird auch Methode verbindungsstandberichtText() benutzt, um nutzer-
	// freundliche Ausgabe zu entwickeln
	public boolean openConnection(String nutzer, String passwort) {
		try {
			my_connection = DriverManager.getConnection(url, nutzer, passwort);
			verbindungsstand = true;
		}
		catch(Exception e) {
			verbindungsstand = false;
		}
		System.out.println("Nutzer Name: " + nutzer);
		System.out.println("Passwort: " + passwort);
		System.out.println("Verbindung: " + verbindungsstandberichtText());
		
		return verbindungsstand;
	}
	
	// CloseConnection, schließt Verbindung für einen bestimmten Nutzer
	public void closeConnection(String nutzer) {
		try {
			my_connection.close();
			verbindungsstand = false;
		}
		catch(Exception e) {
			verbindungsstand = true;
		}
		System.out.println("Nutzer Name: " + nutzer);
		System.out.println("Verbindung: " + verbindungsstandberichtText());
	}
	
	// Verbindungsstandbericht
	public String verbindungsstandberichtText() {
		if (verbindungsstand) {
			verbindungsstandbericht = "Verbindung ist geöffnet.";
		} else {
			verbindungsstandbericht = "Verbindung ist geschlossen.";
		}
		return verbindungsstandbericht;
	}
	
	// Abfragen Tabelle Künstler und Bilder
	public void anfrageDBZugriff(String nutzer, String passwort, String befehl) {
//		this.nutzer = nutzer;
//		this.passwort = passwort;
//		this.befehl = befehl;
		
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			ResultSet my_result = my_statement.executeQuery(befehl);
			
			String result = "";
			int anzahl = 0;
			
			// Block für SELECT Abfrage - dbzugriff.anfrageDBZugriff("admin", "123456", "SELECT * FROM bilder;");
			System.out.printf("\n %-15s %-15s %-15s %-25s %-15s %-15s", "Kunstler_Nr", "Vorname", 
					"Nachname", "Adresse", "PLZ", "Wohnort");
			while (my_result.next()) {
				result = result.concat("\n" + my_result.getInt("Künstler_nr") + "  " 
				+  my_result.getString("Vorname") + "  " + my_result.getString("Nachname") + "  " 
				+ my_result.getString("Adresse") + "  " + my_result.getInt("PLZ") + "  " 
				+ my_result.getString("Wohnort"));
				System.out.printf("\n %-15s %-15s %-15s %-25s %-15s %-15s", 
						my_result.getInt("Künstler_Nr"), my_result.getString("Vorname"), 
						my_result.getString("Nachname"), my_result.getString("Adresse"), 
						my_result.getInt("PLZ"), my_result.getString("Wohnort"));
				anzahl++;
			}
			
			System.out.println();
			System.out.println();
			
			
			// Block für SELECT Abfrage - dbzugriff.anfrageDBZugriff("admin", "123456", "SELECT * FROM künstler;");			
//			System.out.printf("\n %-15s %-20s %-15s %-15s %-15s %-15s", "Bild_Nr", "Titel", "Künstler_Nr", "Breite", "Höhe", "Preis");
//			while (my_result.next()) {
//				result = result.concat("\n" + my_result.getInt("Bild_Nr") + "  " 
//				+ my_result.getString("Titel") + "  " + my_result.getInt("Künstler") + "  " 
//				+ my_result.getInt("Breite") + "  " + my_result.getInt("Höhe") + "  " 
//				+ my_result.getDouble("Preis"));
//				System.out.printf("\n %-15s %-20s %-15s %-15s %-15s %-15s", 
//						my_result.getInt("Bild_Nr"), my_result.getString("Titel"), 
//						my_result.getInt("Künstler"), my_result.getInt("Breite"), 
//						my_result.getInt("Höhe"), my_result.getDouble("Preis"));
//			}
//			
//			System.out.println();
//			System.out.println();
			
			closeConnection(nutzer);	
		}
		catch(Exception e) {
			System.out.println("Es ist ein Fehler aufgetreten.");
		}
		
	}
	
	// Manipulationen
	public boolean manipulationDBZugriff(String nutzer, String passwort, String befehl) {
		boolean result;
		this.nutzer = nutzer;
		this.passwort = passwort;
		this.befehl = befehl;
		
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
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
	
	
}
