package no.hvl.dat107;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

public class Menu {
	Scanner userInput;
	AnsattEAO ansattEAO;
	AvdelingEAO avdelingEAO;
	ProsjektEAO prosjektEAO;

	public Menu() {
		setup();
	}

	private void setup() {
		ansattEAO = new AnsattEAO();
		avdelingEAO = new AvdelingEAO();
		prosjektEAO = new ProsjektEAO();
		userInput = new Scanner(System.in);
	}

	@Override
	public void finalize() {
		ansattEAO = null;
		avdelingEAO = null;
		prosjektEAO = null;
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
		return userInput.next();
	}

	private BigDecimal getUserBigDec() {
		BigDecimal userBigDec = new BigDecimal(-1);
		while (true) {
			if (userInput.hasNextInt()) {
				userBigDec = userInput.nextBigDecimal();
				return userBigDec;
			} else {
				System.out.println("Please try again.");
				userInput.next();
			}
		}
	}

	private void pauseForInput() {
		System.out.println("Any key to continue...");
		userInput.next();
		start();
	}

	private void start() {
		System.out.println("Velkommen til et elendigt menysystem!\n" + "PLEASE SELECT AN ACTION FROM THE FOLLOWING: \n"
				+ "1. Ansatt valg.\n" + "2. Avdeling valg.\n" + "3. Prosjekt valg.\n" + "0. Exit.");
		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			valgAnsatt();
			pauseForInput();
			break;
		case 2:
			valgAvdeling();
			pauseForInput();
			break;
		case 3:
			valgProsjekt();
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

	private Avdeling finnAvdeling() { // cloned from below
		System.out.println("Velg en avdeling: 1. ID eller 2. Navn.");
		int selection = getUserInt();
		Avdeling avdeling = null;
		boolean loopHole = true;
		switch (selection) {
		case 1:
			while (loopHole) {
				System.out.println("Hvilket ansattID?");
				int inputInt = 0;
				inputInt = getUserInt();
				try {
					avdeling = avdelingEAO.finnAvdelingMedId(inputInt);
					System.out.println("Henter ut prosjekt med avdelingId=" + inputInt);
					System.out.println("   " + avdeling);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		case 2:
			while (loopHole) {
				System.out.println("Hvilket brukernavn?");
				String input = getUserString();
				System.out.println(input);
				try {
					avdeling = avdelingEAO.finnAvdelingMedNavn(input);
					System.out.println("Henter ut avdeling med navn=" + input);
					System.out.println("   " + avdeling);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		}

		if (avdeling == null) {
			System.out.println("No avdeling found or invalid choice, returning.");
			pauseForInput();
		}

		return avdeling;
	}

	private void valgAvdeling() {
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn avdeling.\n" + "2. List alle avdelinger.\n" + "3. Oppdater avdeling.\n"
				+ "0. Return upwards.");

		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			finnAvdeling();
			pauseForInput();
			break;
		case 2:
			List<Avdeling> avdelingsb = avdelingEAO.finnAlleAvdelinger();
			System.out.println("b) Hente ut alle avdelinger");
			Iterator<Avdeling> iter = avdelingsb.iterator();
			while (iter.hasNext()) {
				System.out.println("   " + iter.next());
			}
			pauseForInput();
			break;
		case 3:
			Avdeling avdeling = finnAvdeling();
			
		case 0:
			System.out.println("Returning to main menu.");
			start();
			break;
		}
	}

	private Ansatt finnAnsatt() {
		System.out.println("Velg en ansatt: 1. ID eller 2. Brukernavn.");
		int selection = getUserInt();
		Ansatt ansatt = null;
		boolean loopHole = true;
		switch (selection) {
		case 1:
			while (loopHole) {
				System.out.println("Hvilket ansattID?");
				int inputInt = 0;
				inputInt = getUserInt();
				try {
					ansatt = ansattEAO.finnAnsattMedId(inputInt);
					System.out.println("Henter ut ansatt med ansattId=" + inputInt);
					System.out.println("   " + ansatt);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		case 2:
			while (loopHole) {
				System.out.println("Hvilket brukernavn?");
				String input = getUserString();
				System.out.println(input);
				try {
					ansatt = ansattEAO.finnAnsattMedBn(input);
					System.out.println("Henter ut ansatt med brukernavn=" + input);
					System.out.println("   " + ansatt);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		}

		if (ansatt == null) {
			System.out.println("No ansatt found or invalid choice, returning.");
			pauseForInput();
		}

		return ansatt;
	}

	private void valgAnsatt() {
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn ansatt." + "2. List alle ansatte.\n" + "3. Oppdatere ansatt. \n"
				+ "4. Legg til ny ansatt. \n" + "0. Return upwards.");

		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			finnAnsatt();
			pauseForInput();
			break;
		case 2:
			List<Ansatt> ansattsb = ansattEAO.finnAlleAnsatte();
			System.out.println("b) Hente ut alle ansatte");
			Iterator<Ansatt> iter = ansattsb.iterator();
			while (iter.hasNext()) {
				System.out.println("   " + iter.next());
			}
			pauseForInput();
			break;
		case 3: // Endrat
			Ansatt forandreAns = finnAnsatt();
			System.out.println("Oppdatera Lonn 1. eller Stilling 2.");
			int endre = getUserInt();
			if (endre == 1) {
				System.out.print("Skriv inn ny lonn");
				BigDecimal nyLonn = getUserBigDec();
				forandreAns.setMaanedslonn(nyLonn);
				ansattEAO.oppdaterAnsatt(forandreAns);
				System.out.println(ansattEAO.finnAnsattMedId(forandreAns.getAnsattId()));

			} else {
				System.out.print("Skriv inn ny stilling");
				String nyStilling = getUserString();
				forandreAns.setStilling(nyStilling);
				ansattEAO.oppdaterAnsatt(forandreAns);
				System.out.println(ansattEAO.finnAnsattMedId(forandreAns.getAnsattId()));
			}

			pauseForInput();
			break;
		case 4: // Endret av Niklas & Darren kan bli knas
			System.out.println("Legg til ny ansatt, skrev in Brukernavn XX");

			String nyBrukernavn = getUserString();
			System.out.println("Skriv inn Fornavn");
			String nyFornavn = getUserString();
			System.out.println("Skriv inn Etternavn");
			String nyEtternavn = getUserString();
			System.out.println("Skriv inn Aar: XXXX");
			int aar = getUserInt();
			System.out.println("Skriv inn Maaned: XX");
			int maaned = getUserInt();
			System.out.println("Skriv inn Dag XX");
			int dag = getUserInt();
			System.out.println("Angi Stilling");
			String nyStilling = getUserString();
			System.out.println("Angi Lonn");
			BigDecimal nyLonn = getUserBigDec();

			try {
			Ansatt nyAnsatt = new Ansatt(nyBrukernavn, nyFornavn, nyEtternavn, LocalDate.of(aar, maaned, dag),
					nyStilling, nyLonn, 1, 1);
			ansattEAO.lagreNyAnsatt(nyAnsatt);

			} catch (DateTimeException e) {
				System.out.println("Time/date not correct format: " + e + "\nPlease try again.");
			}
			pauseForInput();
			break;
		case 0:
			System.out.println("Returning to main menu.");
			start();
			break;
		}

	}

	private Prosjekt finnProsjekt() {
		System.out.println("Velg ett prosjekt: 1. ID eller 2. Navn.");
		int selection = getUserInt();
		Prosjekt prosjekt = null;
		boolean loopHole = true;
		switch (selection) {
		case 1:
			while (loopHole) {
				System.out.println("Hvilket prosjektID?");
				int inputInt = 0;
				inputInt = getUserInt();
				try {
					prosjekt = prosjektEAO.finnProsjektMedId(inputInt);
					System.out.println("Henter ut prosjekt med prosjektId=" + inputInt);
					System.out.println("   " + prosjekt);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		case 2:
			while (loopHole) {
				System.out.println("Hvilket prosjektnavn?");
				String input = getUserString();
				System.out.println(input);
				try {
					prosjekt = prosjektEAO.finnProsjektMedNavn(input);
					System.out.println("Henter ut prosjekt med navn=" + input);
					System.out.println("   " + prosjekt);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		}
		if (prosjekt == null) {
			System.out.println("No prosjekt found or invalid choice, returning.");
			pauseForInput();
		}
		return prosjekt;
	}

	private void valgProsjekt() {
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn prosjekt.\n" + "2. List alle prosjekt.\n" + "3. Oppdatere prosjekt. \n"
				+ "4. Legg til nytt prosjekt. \n" + "5. Registrer nye medlemmer i et prosjekt.\n"
				+ "6. Fjern medlemmer fra et prosjekt.\n" + "0. Return upwards.");

		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			finnProsjekt();
		case 2:
			List<Prosjekt> prosjekt = prosjektEAO.finnAlleProsjekter();
			System.out.println("Henter ut alle prosjekt");
			Iterator<Prosjekt> iter = prosjekt.iterator();
			while (iter.hasNext()) {
				System.out.println("   " + iter.next());
			}
			pauseForInput();
			break;
		case 3:
			Prosjekt prosjektChng = finnProsjekt();
			System.out.print("Skriv inn nytt navn paa prosjektet.");
			String navn = getUserString();
			prosjektChng.setProsjektNavn(navn);
			System.out.print("Skriv inn beskrivelse paa prosjektet.");
			String beskrivelse = getUserString();
			prosjektChng.setBeskrivelse(beskrivelse);
			prosjektEAO.oppdaterProsjekt(prosjektChng);

			pauseForInput();
			break;
		case 4: // Altered from above to fit this
			System.out.println("Legg til nytt prosjekt, skriv inn Prosjektnavn.");
			String nyProsjektnavn = getUserString();
			System.out.println("Angi beskrivelse.");
			String nyBeskrivelse = getUserString();

			Prosjekt nyProsjekt = new Prosjekt(nyProsjektnavn, nyBeskrivelse);
			prosjektEAO.lagreNyProsjekt(nyProsjekt);

			pauseForInput();
			break;
		case 5:
			Prosjekt prosjektAdd = finnProsjekt();
			Ansatt ansattToAdd = finnAnsatt();

			ansattEAO.registrerProsjektdeltagelse(ansattToAdd, prosjektAdd);
			pauseForInput();
			break;
//		case 6:
//			Prosjekt prosjektRemove = finnProsjekt();
//			Ansatt ansattToRemove = finnAnsatt();
//
//			ansattEAO.fjernProsjektdeltagelse(ansattToRemove, prosjektRemove);
//			pauseForInput();
//			break;
		case 0:
			System.out.println("Returning to main menu.");
			start();
			break;
		}
	}

	public void test() {
		start();


	}

}
