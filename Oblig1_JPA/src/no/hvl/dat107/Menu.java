package no.hvl.dat107;

import java.math.BigDecimal;
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

	private void valgAvdeling() {
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn avdeling via id.\n" + "2. Finn avdeling ved navn.\n" + "3. List alle avdelinger.\n"
				+ "0. Return upwards.");

		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			System.out.println("Hvilken avdelingID?");
			int inputInt = 0;
			inputInt = getUserInt();
			try {
				Avdeling avdeling = avdelingEAO.finnAvdelingMedId(inputInt);
				System.out.println("a) Hente ut ansatt med avdelingId=" + inputInt);
				System.out.println("   " + avdeling);
			} catch (NoResultException e) {
				System.out.println("No such result. " + e);
			}
			pauseForInput();
			break;
		case 2:
			while (true) {
				System.out.println("Hvilket avdelingsnavn?");
				String input = getUserString();
				System.out.println(input);
				Avdeling avdeling;
				try {
					avdeling = avdelingEAO.finnAvdelingMedNavn(input);
					System.out.println("a) Hente ut ansatt med bn=" + input);
					System.out.println("   " + avdeling);
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		case 3:
			List<Avdeling> avdelingsb = avdelingEAO.finnAlleAvdelinger();
			System.out.println("b) Hente ut alle avdelinger");
			Iterator<Avdeling> iter = avdelingsb.iterator();
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
	
	private Ansatt finnAnsatt() {
		System.out.println("Velg ett prosjekt: 1. ID eller 2. Navn.");
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
					System.out.println("Henter ut prosjekt med prosjektId=" + inputInt);
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
					System.out.println("Henter ut prosjekt med navn=" + input);
					System.out.println("   " + ansatt);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		}
		return ansatt;
	}

	private void valgAnsatt() {
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn ansatt via id.\n" + "2. Finn ansatt ved brukernavn.\n" + "3. List alle ansatte.\n"
				+ "4. Oppdatere ansatt. \n" + "5. Legg til ny ansatt. \n" + "0. Return upwards.");

		int userSelection = getUserInt();
		switch (userSelection) {
		case 1:
			System.out.println("Hvilken ansattID?");
			int inputInt = 0;
			inputInt = getUserInt();
			try {
				Ansatt ansatt = ansattEAO.finnAnsattMedId(inputInt);
				System.out.println("a) Hente ut ansatt med ansattId=" + inputInt);
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
			System.out.println("b) Hente ut alle ansatte");
			Iterator<Ansatt> iter = ansattsb.iterator();
			while (iter.hasNext()) {
				System.out.println("   " + iter.next());
			}
			pauseForInput();
			break;
		case 4: // Endrat
			System.out.println("Oppdatera Lonn 1. eller Stilling 2.");
//			String input = getUserInt();
//			System.out.println(input);

			int endre = getUserInt();
			if (endre == 1) {
				System.out.print("Skriv id paa ansatt som skal forandres");
				int finn = getUserInt();
				Ansatt forandreAns = ansattEAO.finnAnsattMedId(finn);
				System.out.print("Skriv inn ny lonn");
				BigDecimal nyLonn = getUserBigDec();
				forandreAns.setMaanedslonn(nyLonn);
				ansattEAO.oppdaterAnsatt(forandreAns);
				System.out.println(ansattEAO.finnAnsattMedId(finn));

			} else {
				System.out.print("Skriv inn ID paa ansatt som skal forandres");
				int finn1 = getUserInt();
				Ansatt forandreAns = ansattEAO.finnAnsattMedId(finn1);
				System.out.print("Skriv inn ny stilling");
				String nyStilling = getUserString();
				forandreAns.setStilling(nyStilling);
				ansattEAO.oppdaterAnsatt(forandreAns);
				System.out.println(ansattEAO.finnAnsattMedId(finn1));
			}

			pauseForInput();
			break;
		case 5: // Endret av Niklas & Darren kan bli knas
			System.out.println("Legg til ny ansatt, skrev in Brukernavn XX");

			String nyBrukernavn = getUserString();
			System.out.println("Skriv inn Fornavn");
			String nyFornavn = getUserString();
			System.out.println("Skriv inn Etternavn");
			String nyEtternavn = getUserString();
			System.out.println("Skriv inn År: XXXX");
			int aar = getUserInt();
			System.out.println("Skriv inn Månad: XX");
			int maaned = getUserInt();
			System.out.println("Skriv inn Dag XX");
			int dag = getUserInt();
			System.out.println("Angi Stilling");
			String nyStilling = getUserString();
			System.out.println("Angi Lonn");
			BigDecimal nyLonn = getUserBigDec();

			Ansatt nyAnsatt = new Ansatt(nyBrukernavn, nyFornavn, nyEtternavn, LocalDate.of(aar, maaned, dag),
					nyStilling, nyLonn, 1, 1);
			ansattEAO.lagreNyAnsatt(nyAnsatt);

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
		return prosjekt;
	}

	private void valgProsjekt() {
		System.out.println("Velg en av de folgende: ");
		System.out.println("1. Finn prosjekt via id.\n" + "2. Finn prosjekt via prosjektnavn.\n"
				+ "3. List alle prosjekt.\n" + "4. Oppdatere prosjekt. \n" + "5. Legg til nytt prosjekt. \n"
				+ "6. Registrer nye medlemmer i et prosjekt.\n" + "7. Fjern medlemmer fra et prosjekt.\n"
				+ "0. Return upwards.");

		int userSelection = getUserInt();
		boolean loopHole = true;
		switch (userSelection) {
		case 1:
			while (loopHole) {
				System.out.println("Hvilket prosjektID?");
				int inputInt = getUserInt();
				try {
					Prosjekt prosjekt = prosjektEAO.finnProsjektMedId(inputInt);
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
				try {
					Prosjekt prosjekt = prosjektEAO.finnProsjektMedNavn(input);
					System.out.println("Henter ut prosjekt med navn=" + input);
					System.out.println("   " + prosjekt);
					loopHole = false;
				} catch (NoResultException e) {
					System.out.println("No such result. " + e);
				}
				pauseForInput();
				break;
			}
		case 3:
			List<Prosjekt> prosjekt = prosjektEAO.finnAlleProsjekter();
			System.out.println("b) Hente ut alle prosjekt");
			Iterator<Prosjekt> iter = prosjekt.iterator();
			while (iter.hasNext()) {
				System.out.println("   " + iter.next());
			}
			pauseForInput();
			break;
		case 4:
			System.out.println("Oppdatere 1. navn eller 2. beskrivelse.");
//			String input = getUserInt();
//			System.out.println(input);

			int endre = getUserInt();
			if (endre == 1) {
				System.out.print("Skriv id paa prosjekt som skal forandres");
				int finn = getUserInt();
				Prosjekt prosjektChng = prosjektEAO.finnProsjektMedId(finn);
				System.out.print("nytt navn");
				String navn = getUserString();
				prosjektChng.setProsjektNavn(navn);
				;
				prosjektEAO.oppdaterProsjekt(prosjektChng);
				System.out.println(prosjektEAO.finnProsjektMedId(finn));

			} else {
				System.out.print("Skriv inn ID paa prosjekt som skal forandres");
				int finn = getUserInt();
				Prosjekt prosjektChng = prosjektEAO.finnProsjektMedId(finn);
				System.out.print("Skriv inn ny beskrivelse");
				String nyBeskrivelse = getUserString();
				prosjektChng.setBeskrivelse(nyBeskrivelse);
				prosjektEAO.oppdaterProsjekt(prosjektChng);
				System.out.println(prosjektEAO.finnProsjektMedId(finn));
			}

			pauseForInput();
			break;
		case 5: // Altered from above to fit this
			System.out.println("Legg til nytt prosjekt, skriv in Prosjektnavn");

			String nyProsjektnavn = getUserString();
			System.out.println("Skriv inn Fornavn");
			System.out.println("Angi beskrivelse");
			String nyBeskrivelse = getUserString();

			Prosjekt nyProsjekt = new Prosjekt(nyProsjektnavn, nyBeskrivelse);
			prosjektEAO.lagreNyProsjekt(nyProsjekt);

			pauseForInput();
			break;
		case 6:
			Prosjekt prosjektAdd = finnProsjekt();
			if (prosjektAdd == null) {
				System.out.println("No project found or invalid choice, returning.");
				pauseForInput();
			}
			Ansatt ansattToAdd = finnAnsatt();
			if (ansattToAdd == null)  {
				System.out.println("No ansatt found or invalid choice, returning.");
				pauseForInput();
			}
			
			ansattEAO.registrerProsjektdeltagelse(ansattToAdd, prosjektAdd);
			pauseForInput();
			break;
		case 7:
			Prosjekt prosjektRemove = finnProsjekt();
			if (prosjektRemove == null) {
				System.out.println("No project found or invalid choice, returning.");
				pauseForInput();
			}
			Ansatt ansattToRemove = finnAnsatt();
			if (ansattToRemove == null)  {
				System.out.println("No ansatt found or invalid choice, returning.");
				pauseForInput();
			}
			
			ansattEAO.fjernProsjektdeltagelse(ansattToRemove, prosjektRemove);
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
