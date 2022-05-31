
public class Main {

	public static void main(String[] args) {
		
		DBZugriff dbzugriff_treiberladenkontrolle = new DBZugriff();
		
		
		
		DBZugriff dbzugriff_verbindungkontrolle = new DBZugriff();
		dbzugriff_verbindungkontrolle.openConnection("admin", "123456"); // existiert, pass +
		dbzugriff_verbindungkontrolle.openConnection("admin", "000"); // existiert, pass -
		dbzugriff_verbindungkontrolle.openConnection("kunde", "123"); // existiert, pass +
		dbzugriff_verbindungkontrolle.openConnection("unbekannt", "000"); // existiert nicht
		
		dbzugriff_verbindungkontrolle.closeConnection("admin");
		
		dbzugriff_verbindungkontrolle.openConnection("admin", "123456");
		dbzugriff_verbindungkontrolle.databankAbfrage("SELECT tb_kunde.Vorname FROM tb_kunde WHERE Nachname = 'Müller';");

	}

}
