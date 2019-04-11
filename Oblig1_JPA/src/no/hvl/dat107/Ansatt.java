package no.hvl.dat107;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig1_jpa", name = "ansatt")
public class Ansatt {

	private static final LocalDate LocalDate = null;
	private static final BigDecimal BigDecimal = null;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansattId;
	private String brukernavn = "";
	private String fornavn = "";
	private String etternavn = "";
	private LocalDate ansettelsesdato;
	private String stilling = "";
	private BigDecimal maanedslonn;

	@ManyToOne
	@JoinColumn(name = "avdeling", referencedColumnName = "avdelingsid")
	private int ansattAvdeling;
	@ManyToMany(mappedBy = "ansatte")
	private int ansattProsjekt;

	@OneToMany(mappedBy = "ansatt")
	private List<Prosjektdeltagelse> deltagelser;

	@ManyToMany(mappedBy = "ansatte")
	private List<Prosjekt> prosjekter;

	public Ansatt() { // Trengs for JPA

	}
//	this("","","",LocalDate,"",BigDecimal);}

	public LocalDate getAnsettelsesdato() {
		return ansettelsesdato;
	}

	public void setAnsettelsesdato(LocalDate ansettelsesdato) {
		this.ansettelsesdato = ansettelsesdato;
	}

	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void setDeltagelser(List<Prosjektdeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
	}

	public List<Prosjekt> getProsjekter() {
		return prosjekter;
	}

	public void setProsjekter(List<Prosjekt> prosjekter) {
		this.prosjekter = prosjekter;
	}

	

	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesdato, String stilling,
			BigDecimal maanedslonn, int ansattAvdeling, int ansattProsjekt) {

		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesdato = ansettelsesdato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		this.ansattAvdeling = ansattAvdeling;
		this.ansattProsjekt = ansattProsjekt;

	}

	public int getAnsattAvdeling() {
		return ansattAvdeling;
	}

	public void setAnsattAvdeling(int ansattAvdeling) {
		this.ansattAvdeling = ansattAvdeling;
	}

	public int getAnsattProsjekt() {
		return ansattProsjekt;
	}

	public void setAnsattProsjekt(int ansattProsjekt) {
		this.ansattProsjekt = ansattProsjekt;
	}

	public Integer getAnsattId() {
		return ansattId;
	}

	public static LocalDate getLocaldate() {
		return LocalDate;
	}

	public static BigDecimal getBigdecimal() {
		return BigDecimal;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getSjefInfo() {
		return fornavn + " " + etternavn;
	}

	public LocalDate getAnsettelsedato() {
		return ansettelsesdato;
	}

	public void setAnsettelsedato(LocalDate ansettelsedato) {
		this.ansettelsesdato = ansettelsedato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public BigDecimal getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(BigDecimal maanedslonn) {
		this.maanedslonn = maanedslonn;
	}
	public  void lagreNyProsjekt(Prosjekt p) {
		AnsattEAO aEAO = new AnsattEAO();
		aEAO.lagreNyProsjekt(p,this);
	}
			
	@Override
	public String toString() {
		return "Ansatt [ansattId=" + ansattId + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelsesdato=" + ansettelsesdato + ", stilling=" + stilling + ", maanedslonn="
				+ maanedslonn + ", ansattAvdeling=" + ansattAvdeling + ", ansattProsjekt=" + ansattProsjekt + "]";
	}

}
