package no.hvl.dat107;

import java.util.List;

public class Main {

	// Scanner tastatur = new Scanner(System.in);

	public static void main(String[] args) {
		AnsattEAO ansattEAO = new AnsattEAO();

		Ansatt ansatt = ansattEAO.finnAnsattMedId(1);
		System.out.println("a) Hente ut ansatt med ansattId=1");
		System.out.println("   " + ansatt);

		Ansatt ansatt1 = ansattEAO.finnAnsattMedId(1);
		System.out.println("    " + ansatt1);

		 //a)
		List<Ansatt> ansatta = ansattEAO.finnAnsattMedBn("asdf");
		System.out.println("a) Hente ut ansatt med bn=asdf");
		System.out.println("   " + ansatta);

		// b)
		List<Ansatt> ansattsb = ansattEAO.finnAlleAnsatte();
		System.out.println("b) Hente ut alle ansatts");
		System.out.println("   " + ansattsb);

//		// c)
//		List<Ansatt> ansattsc = ansattEAO.finnAnsatteMedTekst("Hassan");
//		System.out.println("c) Hente ut ansatt med tekst=\"Hassan\"");
//		System.out.println("   " + ansattsc);

		// d)
//		System.out.println("d) Legge til en ny ansatt med pk=4");
//		Ansatt ansattny = new Ansatt(4, "Gj�re lekser");
//		ansattEAO.lagreNyAnsatt(ansattny);
//		Ansatt ansattd = ansattEAO.finnAnsattMedPk(4);
//		System.out.println("   Henter ut ansatt med pk=4");
//		System.out.println("   " + ansattd);

		// e)
//		System.out.println("e) Slette ansatt med pk=4");
//		ansattEAO.slettAnsattMedPk(4);
//		Ansatt ansatte = ansattEAO.finnAnsattMedBn("asdf");
//		System.out.println("   Henter ut ansatt med pk=4");
//		System.out.println("   " + ansatte);

		// f)
//		System.out.println("f) Endre tekst p� ansatt med pk=3");
//		Ansatt ansattf1 = ansattEAO.finnAnsattMedPk(3);
//		ansattf1.setTekst("Endret tekst " + LocalTime.now());
//		ansattEAO.oppdaterAnsatt(ansattf1);
//		Ansatt ansattf2 = ansattEAO.finnAnsattMedPk(3);
//		System.out.println("   Henter ut ansatt med pk=3");
//		System.out.println("   " + ansattf2);

	}
}
