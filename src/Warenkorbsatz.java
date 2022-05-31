
public class Warenkorbsatz {
	
	private int warenkorbsatz_id;
	private int artikel_id;
	private int anzahl;
	
	public Warenkorbsatz() {
		
	}
	
	public Warenkorbsatz(int warenkorbsatz_id, int artikel_id, int anzahl) {
		this.warenkorbsatz_id = warenkorbsatz_id;
		this.artikel_id = artikel_id;
		this.anzahl = anzahl;
	}

	public int getWarenkorbsatz_id() {
		return warenkorbsatz_id;
	}

	public void setWarenkorbsatz_id(int warenkorbsatz_id) {
		this.warenkorbsatz_id = warenkorbsatz_id;
	}

	public int getArtikel_id() {
		return artikel_id;
	}

	public void setArtikel_id(int artikel_id) {
		this.artikel_id = artikel_id;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	
}
