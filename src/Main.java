import Prog1Tools.IOTools;

public class Main {

	public static void main(String[] args) {
		
		String nutzer_name, passwort;
		
		// Treiber Test 
		DBZugriff dbzugriff = new DBZugriff();
		
		// Verbindungstest
		nutzer_name = IOTools.readString("Geben Sie Nutzername ein: ");
		passwort = IOTools.readString("Geben Sie Passwort ein: ");
		
		dbzugriff.openConnection(nutzer_name, passwort); 
		dbzugriff.closeConnection(nutzer_name);
		
		//dbzugriff.databankAbfrage("SELECT tb_kunde.Vorname FROM tb_kunde WHERE Nachname = 'Müller';");

		
		
		// import java.util.Date;

	}

}
