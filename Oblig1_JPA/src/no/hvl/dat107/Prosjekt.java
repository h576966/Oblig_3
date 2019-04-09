package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig1_jpa", name = "prosjekt")
public class Prosjekt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektId;
	private String prosjektNavn = "";
	private String beskrivelse = "";
	
	public Prosjekt() { // Trengs for JPA

	}
	
	public Prosjekt(String prosjektNavn, String beskrivelse) {

		this.prosjektNavn = prosjektNavn;
		this.beskrivelse = beskrivelse;
	}

	public String getProsjektNavn() {
		return prosjektNavn;
	}

	public void setProsjektNavn(String prosjektNavn) {
		this.prosjektNavn = prosjektNavn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public int getProsjektId() {
		return prosjektId;
	}
	
	@Override
	public String toString() {
		return "Prosjekt [prosjektnavn=" + prosjektNavn + ", beskrivelse=" + getBeskrivelse()
				+ "]";
	}
}
