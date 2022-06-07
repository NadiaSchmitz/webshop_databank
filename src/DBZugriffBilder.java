
public class DBZugriffBilder {
	Bilder bild;
	String befehl_bild;
	
	public DBZugriffBilder() {
		
	}
	
	public String neuesBildSpeicher() {
		befehl_bild = "INSERT INTO bilder(Bild_Nr,Titel,Künstler,Breite,Höhe,Preis) VALUES(6," + bild.getBild_Nr() + ", " + bild.getTitel() + ", " + bild.getKuenstler().getKuenstler_Nr() + ", " + bild.getBreite() + ", " + bild.getHohe() + ", " + bild.getPreis() +");";
		return befehl_bild;
	}

}
