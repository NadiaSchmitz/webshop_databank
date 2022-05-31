
public class Kuenstler {

	private int kuenstler_Nr;
	private String vorname;
	private String nachname;
	private String adresse;
	private int plz;
	private String wohnort;
	
	public Kuenstler() {
		
	}
	
	public Kuenstler(int kuenstler_Nr, String vorname, String nachname, String adresse, int plz, String wohnort) {
		this.kuenstler_Nr = kuenstler_Nr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.adresse = adresse;
		this.plz = plz;
		this.wohnort = wohnort;
	}

	public int getKuenstler_Nr() {
		return kuenstler_Nr;
	}

	public void setKuenstler_Nr(int kuenstler_Nr) {
		this.kuenstler_Nr = kuenstler_Nr;
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
