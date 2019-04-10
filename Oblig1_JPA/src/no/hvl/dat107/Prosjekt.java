package no.hvl.dat107;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig1_jpa", name = "prosjekt")
public class Prosjekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektId;
	private String prosjektNavn = "";
	private String beskrivelse = "";
	@ManyToMany
	@JoinTable(
			name = "oblig1_jpa.prosjektdeltagelse",
			joinColumns = @JoinColumn(name="prosjektId"),
			inverseJoinColumns = @JoinColumn(name ="ansattId"))
	private List<Ansatt> ansatte;
	
	
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
