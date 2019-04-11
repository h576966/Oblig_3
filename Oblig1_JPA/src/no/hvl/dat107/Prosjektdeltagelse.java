package no.hvl.dat107;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig1_jpa")
@IdClass(ProsjektdeltagelsePK.class)
public class Prosjektdeltagelse {
	
	@Id
	@ManyToOne
	@JoinColumn(name="ansattid")
	private Ansatt ansatt;
	
	@Id
	@ManyToOne
	@JoinColumn(name="prosjektid")
	private Prosjekt prosjekt;
	
	private String prosjektRolle;
	private BigDecimal arbeidsTimer;
	
	public Prosjektdeltagelse() {}
	
	public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt) {
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
		this.prosjektRolle = "";
		this.arbeidsTimer = BigDecimal.ZERO;
		
		//ansattId.leggTilProsjektdeltagelse(this);
		//prosjektId.leggTilProsjektdeltagelse(this);
	}

	public String getProsjektRolle() {
		return prosjektRolle;
	}

	public void setProsjektRolle(String prosjektRolle) {
		this.prosjektRolle = prosjektRolle;
	}

	public BigDecimal getArbeidsTimer() {
		return arbeidsTimer;
	}

	public void setArbeidsTimer(BigDecimal arbeidsTimer) {
		this.arbeidsTimer = arbeidsTimer;
	}
	
}
