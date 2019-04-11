package no.hvl.dat107;

@SuppressWarnings("unused")
public class ProsjektdeltagelsePK {
private int ansatt;
private int prosjekt;

public ProsjektdeltagelsePK() {}

public ProsjektdeltagelsePK(int ansattId, int prosjektId) {
	this.ansatt = ansattId;
	this.prosjekt = prosjektId; //Kan bli problem med samma namn i deltagelse som ...
	
}
}
