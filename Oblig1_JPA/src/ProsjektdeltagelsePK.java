
public class ProsjektdeltagelsePK {
private int ansattId;
private int prosjektId;

public ProsjektdeltagelsePK() {}

public ProsjektdeltagelsePK(int ansattId, int prosjektId) {
	this.ansattId = ansattId;
	this.prosjektId = prosjektId; //Kan bli problem med samma namn i deltagelse som ...
	
}
}
