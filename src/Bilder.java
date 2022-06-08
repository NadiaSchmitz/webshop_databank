
public class Bilder {
	
	private int bild_Nr;
	private String titel;
	private Kuenstler kuenstler;
	private int breite;
	private int hohe;
	private double preis;
	private DBZugriffBilder dbzugriff_bilder;
		
	// Konstruktoren
	public Bilder() {
		
	}
	
	public Bilder(int bild_Nr, String titel, Kuenstler kuenstler, int breite, int hohe, double preis) {
		this.bild_Nr = bild_Nr; 
		this.titel = titel;
		this.kuenstler = kuenstler;
		this.breite = breite;
		this.hohe = hohe;
		this.preis = preis;
	}
	
	public Bilder(int bild_Nr, String titel, int breite, int hohe, double preis) {
		this.bild_Nr = bild_Nr; 
		this.titel = titel;
		this.breite = breite;
		this.hohe = hohe;
		this.preis = preis;
	}

	// Getters und Setters, für den Parameter bild_Nr - nur Getter
	public int getBild_Nr() {
		return bild_Nr;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Kuenstler getKuenstler() {
		return kuenstler;
	}

	public void setKuenstler(Kuenstler kuenstler) {
		this.kuenstler = kuenstler;
	}

	public DBZugriffBilder getDbzugriff_bilder() {
		return dbzugriff_bilder;
	}

	public void setDbzugriff_bilder(DBZugriffBilder dbzugriff_bilder) {
		this.dbzugriff_bilder = dbzugriff_bilder;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getHohe() {
		return hohe;
	}

	public void setHohe(int hohe) {
		this.hohe = hohe;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	// Methoden
	public void equalsBilder(Bilder bild_2) {
		boolean kuenstler_vergleich = false;
		boolean hohe_vergleich = false;
		boolean breite_vergleich = false;
		boolean preis_vergleich = false;
		
		if (this.kuenstler.getKuenstler_Nr() == bild_2.kuenstler.getKuenstler_Nr()) {
			kuenstler_vergleich = true;
		}
		
		if (this.hohe == bild_2.getHohe()) {
			hohe_vergleich = true;
		}
		
		if (this.breite == bild_2.getBreite()) {
			breite_vergleich = true;
		}
		
		if (this.preis == bild_2.getPreis()) {
			preis_vergleich = true;
		}
		
		System.out.printf("\n %-15s %-15s %-15s %-15s %-15s", "Titel", "Künstler", "Höhe", "Breite", "Preis");
		System.out.printf("\n %-15s %-15s %-15s %-15s %-15s", this.titel, this.kuenstler.getKuenstler_Nr(), this.hohe, this.breite, this.preis);
		System.out.printf("\n %-15s %-15s %-15s %-15s %-15s", bild_2.getTitel(), bild_2.getKuenstler().getKuenstler_Nr(), bild_2.getHohe(), bild_2.getBreite(), bild_2.getPreis());
		System.out.printf("\n %-15s %-15s %-15s %-15s %-15s\n", "-", kuenstler_vergleich, hohe_vergleich, breite_vergleich, preis_vergleich);
	}
}
