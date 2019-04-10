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
	private Ansatt ansattId;
	
	@Id
	@ManyToOne
	@JoinColumn(name="prosjektid")
	private Prosjekt prosjektId;
	
	private String prosjektRolle;
	private BigDecimal arbeidsTimer;
	
	public Prosjektdeltagelse() {}
	
	public Prosjektdeltagelse(Ansatt ansattId, Prosjekt prosjektId, String prosjektrolle, BigDecimal arbeidstimer) {
		this.ansattId = ansattId;
		this.prosjektId = prosjektId;
		this.prosjektRolle = prosjektRolle;
		this.arbeidsTimer = arbeidsTimer;
		
		ansattId.leggTilProsjektdeltagelse(this);
		prosjektId.leggTilProsjektdeltagelse(this);
	}
	
}
