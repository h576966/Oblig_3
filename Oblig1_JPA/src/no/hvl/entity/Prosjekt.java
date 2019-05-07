package no.hvl.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.eao.ProsjektEAO;

@Entity
@Table(schema = "oblig1_jpa", name = "prosjekt")
public class Prosjekt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektId;
	private String prosjektNavn;
	private String beskrivelse;
	@OneToMany(mappedBy = "prosjekt")
	private List<Prosjektdeltagelse> deltagelser;

	public Prosjekt() { // Trengs for JPA

	}


	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void setDeltagelser(List<Prosjektdeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
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
		return "Prosjekt [prosjektnavn=" + prosjektNavn + ", beskrivelse=" + getBeskrivelse() + "]";
	}
	
	   public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
	        deltagelser.add(prosjektdeltagelse);
	   }
	   
	   

}
