import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBZugriff {

	private final String url = "jdbc:mysql://127.0.0.1:3306";
	private String nutzer;
	private String passwort;
	private String databank = "webshop";
	private String befehl;
	Connection my_connection;
	private boolean verbindungsstand;
	
	// Konstruktoren
	public DBZugriff() {
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Treiber erfolgreich geladen.");
		}
		catch(Exception e) {
			System.out.println("Fehler beim Treiberladen.");
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

	// Methoden
	// OpenConnection - überprüft Nutzer und baut Verbindung auf
	public boolean openConnection(String nutzer, String passwort) {
		try {
			my_connection = DriverManager.getConnection(url, nutzer, passwort);
			verbindungsstand = true;
		}
		catch(Exception e) {
			verbindungsstand = false;
		}
		
		System.out.println(verbindungsstand);
		
		if(verbindungsstand) {
			System.out.println("Verbinding für den Nutzer " + nutzer + " passwort " + passwort + " erfolgreich aufgebaut.");
		} else {
			System.out.println("Verbinding für den Nutzer " + nutzer + " passwort " + passwort + " wurde nicht aufgebaut.");
		}
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
		
		System.out.println(verbindungsstand);
		
		if(verbindungsstand) {
			System.out.println("Verbinding für den Nutzer " + nutzer + " geöffnet.");
		} else {
			System.out.println("Verbinding für den Nutzer " + nutzer + " geschlossen.");
		}
		
	}
	
	// Abfragen
	public void databankAbfrage(String befehl) {
		
		this.befehl = befehl;
		
		try {
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			ResultSet my_result = my_statement.executeQuery(befehl);
			String result = "1";
			System.out.println(befehl);
			System.out.println(result);
			
		}
		catch(Exception e) {
			
		}
		
	}
	
	
}
