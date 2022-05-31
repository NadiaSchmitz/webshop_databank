
public class Bilder {
	
	private int bild_Nr;
	private String titel;
	private Kuenstler kuenstler;
	private int breite;
	private int hohe;
	private double preis;
	
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

	public int getBild_Nr() {
		return bild_Nr;
	}

	public void setBild_Nr(int bild_Nr) {
		this.bild_Nr = bild_Nr;
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
}
