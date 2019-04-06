package no.hvl.dat107;

import java.util.Scanner;

public class Menu {
	Scanner userInput = new Scanner(System.in);
	
	public void test() {
		System.out.println("Please enter a name");
		String userName = userInput.nextLine();
		System.out.println("Name is: " + userName);
		userInput.close();
	}
	
}
