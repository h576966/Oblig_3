package no.hvl.dat107;

import java.util.List;
import java.util.Scanner;

public class Menu {
	Scanner userInput;
	AnsattEAO ansattEAO;
	
	public Menu() {
		setup();
	}
	
	private void setup() {
		ansattEAO = new AnsattEAO();
	}
	
	private void findAnsatt() {
		userInput = new Scanner(System.in);
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn ansatt via id.\n"
				+ "2. Finn ansatt ved brukernavn.\n"
				+ "3. List alle ansatte.");
		int userSelection = 0;
		while (true) {
			if (userInput.hasNextInt() ) {
				userSelection = userInput.nextInt();
				break;
			} else {
				System.out.println("Please try again.");
			}
		}
		
		switch (userSelection) {
		case 1: 
			Ansatt ansatt = ansattEAO.finnAnsattMedId(1);
			System.out.println("a) Hente ut ansatt med ansattId=1");
			System.out.println("   " + ansatt);
			break;
		case 2:
			Ansatt ansatta = ansattEAO.finnAnsattMedBn("asdf");
			System.out.println("a) Hente ut ansatt med bn=asdf");
			System.out.println("   " + ansatta);
			break;
		case 3:
			List<Ansatt> ansattsb = ansattEAO.finnAlleAnsatte();
			System.out.println("b) Hente ut alle ansatts");
			System.out.println("   " + ansattsb);
			break;
		}
		
	}
	
	public void test() {		
		findAnsatt();
		
//		// c)
//		List<Ansatt> ansattsc = ansattEAO.finnAnsatteMedTekst("Hassan");
//		System.out.println("c) Hente ut ansatt med tekst=\"Hassan\"");
//		System.out.println("   " + ansattsc);
//
//		// d)
//		System.out.println("d) Legge til en ny ansatt med pk=4");
//		Ansatt ansattny = new Ansatt(4, "Gjore lekser");
//		ansattEAO.lagreNyAnsatt(ansattny);
//		Ansatt ansattd = ansattEAO.finnAnsattMedPk(4);
//		System.out.println("   Henter ut ansatt med pk=4");
//		System.out.println("   " + ansattd);
//
//		// e)
//		System.out.println("e) Slette ansatt med pk=4");
//		ansattEAO.slettAnsattMedPk(4);
//		Ansatt ansatte = ansattEAO.finnAnsattMedBn("asdf");
//		System.out.println("   Henter ut ansatt med pk=4");
//		System.out.println("   " + ansatte);
//
//		// f)
//		System.out.println("f) Endre tekst paa ansatt med pk=3");
//		Ansatt ansattf1 = ansattEAO.finnAnsattMedPk(3);
//		ansattf1.setTekst("Endret tekst " + LocalTime.now());
//		ansattEAO.oppdaterAnsatt(ansattf1);
//		Ansatt ansattf2 = ansattEAO.finnAnsattMedPk(3);
//		System.out.println("   Henter ut ansatt med pk=3");
//		System.out.println("   " + ansattf2);
	}
	
	
	
}
