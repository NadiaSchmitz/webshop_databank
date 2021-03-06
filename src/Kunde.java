
public class Kunde {

	private int kunde_Nr;
	private String vorname;
	private String nachname;
	private String adresse;
	private int plz;
	private String wohnort;
	
	public Kunde() {
		
	}
	
	public Kunde(int kunde_Nr, String vorname, String nachname, String adresse, int plz, String wohnort) {
		this.kunde_Nr = kunde_Nr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
		this.plz = plz;
		this.wohnort = wohnort;
	}

	public int getKunde_Nr() {
		return kunde_Nr;
	}

	public void setKunde_Nr(int kunde_Nr) {
		this.kunde_Nr = kunde_Nr;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
	
}
