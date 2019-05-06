package no.hvl.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig1_jpa")
//@IdClass(ProsjektdeltagelsePK.class)
public class Prosjektdeltagelse {
	
	
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektdeltagelseID;
	private String prosjektRolle;
	private BigDecimal arbeidsTimer;
	
	
	@ManyToOne
	@JoinColumn(name="ansattid")
	private Ansatt ansatt;
	
	
	@ManyToOne
	@JoinColumn(name="prosjektid")
	private Prosjekt prosjekt;
	
	public Prosjektdeltagelse() {}
	
	public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, int arbeidstimer, String prosjektRolle) {
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
		this.prosjektRolle = "";
		this.arbeidsTimer = BigDecimal.ZERO;
		
		ansatt.leggTilProsjektdeltagelse(this);
		prosjekt.leggTilProsjektdeltagelse(this);
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
//	public void skrivUt(String innrykk) {
//        System.out.printf("%sDeltagelse: %s %s, %s, %d timer, %s", innrykk, 
//                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), timer, rolle);
//    }

}
