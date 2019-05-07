package no.hvl.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import no.hvl.eao.AnsattEAO;

@Entity
@Table(schema = "oblig1_jpa", name = "avdeling")
public class Avdeling {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingsId;
	private String avdelingsNavn;
	private int avdelingsSjef;

	
	public Avdeling() { // Trengs for JPA

	}
	
	public Avdeling(String avdelingsNavn, int avdelingsSjef) {

		this.avdelingsNavn = avdelingsNavn;
		this.avdelingsSjef = avdelingsSjef;
	}
	
	public Avdeling(String avdelingsNavn) {

		this.avdelingsNavn = avdelingsNavn;
		
	}
	
	public int getAvdelingId() {
		return avdelingsId;
	}

	public String getAvdelingsNavn() {
		return avdelingsNavn;
	}

	public void setAvdelingsNavn(String avdelingsNavn) {
		this.avdelingsNavn = avdelingsNavn;
	}

	public int getAvdelingsSjef() {
		return avdelingsSjef;
	}
	public void setAvdelingsSjef(int avdelingsSjef) {
		this.avdelingsSjef = avdelingsSjef;
	}
	
	@Override
	public String toString() {
		AnsattEAO ansattEAO = new AnsattEAO();
		Ansatt sjef = ansattEAO.finnAnsattMedId(avdelingsSjef);
		return "Avdeling [avdelingsnavn=" + avdelingsNavn + ", avdelingsSjef=" + sjef.getSjefInfo()
				+ "]";
	}
}
