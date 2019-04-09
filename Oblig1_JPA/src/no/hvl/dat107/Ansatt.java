package no.hvl.dat107;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int ansattAvdeling;
	private int ansattProsjekt;

	public Ansatt() { // Trengs for JPA

	}
//	this("","","",LocalDate,"",BigDecimal);}

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

	public Integer getansattId() {
		return ansattId;
	}

	public void setansattId(Integer ansattId) {
		this.ansattId = ansattId;
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

	@Override
	public String toString() {
		return "Ansatt [ansattId=" + ansattId + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelsesdato=" + ansettelsesdato + ", stilling=" + stilling + ", maanedslonn="
				+ maanedslonn + ", ansattAvdeling=" + ansattAvdeling + ", ansattProsjekt=" + ansattProsjekt + "]";
	}

}
