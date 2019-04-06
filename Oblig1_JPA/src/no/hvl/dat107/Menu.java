package no.hvl.dat107;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

public class Menu {
	Scanner userInput;
	AnsattEAO ansattEAO;
	AvdelingEAO avdelingEAO;

	public Menu() {
		setup();
	}

	private void setup() {
		ansattEAO = new AnsattEAO();
		avdelingEAO = new AvdelingEAO();
		userInput = new Scanner(System.in);
	}

	public void finalize() {
		userInput.close();
	}

	private int getUserInt() {
		int userInt = -1;
		while (true) {
			if (userInput.hasNextInt()) {
				userInt = userInput.nextInt();
				return userInt;
			} else {
				System.out.println("Please try again.");
				userInput.next();
			}
		}
	}

	private String getUserString() {
//		String userString = "";
//		while (true) {
//			if (userInput.hasNext()) {
//				userString = userInput.next();
//				return userString;
//			} else {
//				
//			}
//		}
		return userInput.next();
	}

	private void pauseForInput() {
		System.out.println("Any key to continue...");
		userInput.next();
		start();
	}

	private void start() {
		System.out.println("Velkommen til et elendigt menysystem!\n" + "PLEASE SELECT AN ACTION FROM THE FOLLOWING: \n"
				+ "1. Ansatt valg.\n" + "2. Not implemented.\n" + "3. Not implemented.\n" + "0. Exit.");
		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			findAnsatt();
			break;
		case 2:
			System.out.println("WHAT ABOUT NOT IMPLEMENTED DID YOU NOT UNDERSTAND?!");
			pauseForInput();
			break;
		case 3:
			System.out.println("WHAT ABOUT NOT IMPLEMENTED DID YOU NOT UNDERSTAND?!");
			pauseForInput();
			break;
		case 0:
			System.out.println("Terminating.");
			finalize();
			System.exit(0);
			break;
		default:
			System.out.println("Ha ha, very funny.");
			pauseForInput();
		}
	}

	private void findAnsatt() {
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn ansatt via id.\n" + "2. Finn ansatt ved brukernavn.\n" + "3. List alle ansatte.\n"
				+ "0. Return upwards.");

		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			System.out.println("Hvilken ansattID?");
			int inputInt = 0;
			inputInt = getUserInt();
			try {
				Ansatt ansatt = ansattEAO.finnAnsattMedId(inputInt);
				System.out.println("a) Hente ut ansatt med ansattId=1");
				System.out.println("   " + ansatt);
			} catch (NoResultException e) {
				System.out.println("No such result. " + e);
			}
			pauseForInput();
			break;
		case 2:
			while (true) {
				System.out.println("Hvilket brukernavn?");
				String input = getUserString();
				System.out.println(input);
				Ansatt ansatta;
				try {
					ansatta = ansattEAO.finnAnsattMedBn(input);
					System.out.println("a) Hente ut ansatt med bn=" + input);
					System.out.println("   " + ansatta);
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		case 3:
			List<Ansatt> ansattsb = ansattEAO.finnAlleAnsatte();
			System.out.println("b) Hente ut alle ansatts");
			Iterator iter = ansattsb.iterator();
			while (iter.hasNext()) {
				System.out.println("   " + iter.next());
			}
			pauseForInput();
			break;
		case 0:
			System.out.println("Returning to main menu.");
			start();
			break;
		}

	}

	public void test() {
		start();

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
