import java.util.Date;

public class Kunde {

	private int kunde_id;
	private String vorname;
	private String nachname;
	private Date anmeldungsdatum;
	
	public Kunde() {
		
	}
	
	public Kunde(int kunde_id, String vorname, String nachname, Date anmeldungsdatum) {
		this.kunde_id = kunde_id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.anmeldungsdatum = anmeldungsdatum;
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

	public Date getAnmeldungsdatum() {
		return anmeldungsdatum;
	}

	public void setAnmeldungsdatum(Date anmeldungsdatum) {
		this.anmeldungsdatum = anmeldungsdatum;
	}

	public int getKunde_id() {
		return kunde_id;
	}
	
}
