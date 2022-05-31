import Prog1Tools.IOTools;

public class Main {

	public static void main(String[] args) {
		
		String nutzer_name, passwort;
		
		// Treiber Test 
		DBZugriff dbzugriff = new DBZugriff();
		
		// Verbindungstest
		//System.out.println("Tragen Sie bitte Nutzername ein: ");
		nutzer_name = IOTools.readString("Geben Sie Nutzername ein: ");
		passwort = IOTools.readString("Geben Sie Passwort ein: ");
		
		dbzugriff.openConnection(nutzer_name, passwort); // existiert, pass +
		dbzugriff.closeConnection(nutzer_name);
		//dbzugriff.openConnection("admin", "000"); // existiert, pass -
		//dbzugriff.openConnection("kunde", "123"); // existiert, pass +
		//dbzugriff.openConnection("unbekannt", "000"); // existiert nicht
		
		//dbzugriff.closeConnection("admin");
		
		//dbzugriff.openConnection("admin", "123456");
		//dbzugriff.databankAbfrage("SELECT tb_kunde.Vorname FROM tb_kunde WHERE Nachname = 'Müller';");

	}

}
