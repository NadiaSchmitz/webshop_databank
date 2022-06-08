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

	public String neuesBildSpeicher(Bilder bild) {
		befehl_bild = "INSERT INTO bilder(Bild_Nr, Titel, Künstler, Breite, Höhe, Preis) VALUES(" + bild.getBild_Nr() + ", '" + bild.getTitel() + "' , " + bild.getKuenstler().getKuenstler_Nr() + ", " + bild.getBreite() + ", " + bild.getHohe() + ", " + bild.getPreis() +");";
		return befehl_bild;
	}
	
	public void erstelleArtikelListe(String nutzer, String passwort, String befehl) {
		
		try {
			openConnection(nutzer, passwort);
			
			Statement my_statement = my_connection.createStatement();
			my_statement.execute("USE " + databank);
			
			ResultSet my_result = my_statement.executeQuery(befehl);
			
			String result = "";
			anzahl = 0;
			bilder_liste = new ArrayList<Bilder>();
			
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
	
}
