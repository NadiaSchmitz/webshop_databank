
public class Artikel {
	
	private int artikel_id;
	private String bezeichnung;
	private double preis;
	private int mwst;
	
	public Artikel() {
		
	}
	
	public Artikel(int artikel_id, String bezeichnung, double preis, int mwst) {
		this.artikel_id = artikel_id; 
		this.bezeichnung = bezeichnung;
		this.preis = preis;
		this.mwst = mwst;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getMwst() {
		return mwst;
	}

	public void setMwst(int mwst) {
		this.mwst = mwst;
	}

	public int getArtikel_id() {
		return artikel_id;
	}

}
